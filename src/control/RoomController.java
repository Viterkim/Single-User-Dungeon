
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextArea;
import model.Item;
import model.MonsterGenerator;
import model.Player;
import model.Room;
import model.RoomObject;
import model.RoomObjectGenerator;
import model.Weapon;
import view.MainWindow;

public class RoomController
{
    
    static final String[] DIRECTIONS = {"North", "South", "East", "West"};
    
    public static final int DIRECTION_NORTH = 0;
    public static final int DIRECTION_SOUTH = 1;
    public static final int DIRECTION_EAST = 2;
    public static final int DIRECTION_WEST = 3;
    
    public static final int BUFF_DAMAGE = 0;
    public static final int BUFF_HP = 1;
    public static final int BUFF_RESISTANCE = 2;
    
    private ArrayList<Room> map;
    private ArrayList<Item> merchantWares;
    private ActionController ac;
    private Room currentRoom;
    private Player player;
    private int lastDirection = -1;
    private int dungeonHeight, dungeonWidth, turnsUsed;
    private int[] BUFFS;
    private Random random;
    
    public RoomController(Player player)
    {
        random = new Random();
        ac = new ActionController(this);
        map = new ArrayList<>();
        merchantWares = new ArrayList<>();
        this.player = player;
        //hardGenerateMap();
        dungeonHeight = 3;
        dungeonWidth = 3;
        randomGenerateMap(dungeonWidth, dungeonHeight, 30, 23);
        BUFFS = new int[3];
    }
    
    public void randomGenerateMap(int width, int height, int monsterChance, int objectChance) 
    {
        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++) 
            {
                Room r = new Room(x, y);
                if (random.nextInt(100) <= monsterChance) 
                {
                    r.addMonster(MonsterGenerator.GenerateRandomMonster());
                }
                if (random.nextInt(100) < objectChance)
                {
                    RoomObject tempObj = RoomObjectGenerator.GenerateRandomObject();
                    if (tempObj != null)
                    {
                        r.addObject(tempObj);
                    }
                }
                map.add(r);
            }
        }
        currentRoom = getRoom(0, 0);
        if (currentRoom.getMonster() != null) 
        {
            currentRoom.getMonster().damageMonster(999);
        }
        placeMandatoryObjects();
        placeMandatoryItems();
        prepareMerchant();
    }

    public void placeMandatoryObjects()
    {
        Random rng = new Random();
        //Adds an endgame chest somewhere (NOT in spawn)
        Room tempRoom = getRoom(rng.nextInt(dungeonWidth - 1) +1, rng.nextInt(dungeonHeight - 1) +1);
        tempRoom.addObject(new RoomObject("Endgame Chest", "overflowing with coolness!"));
        //Adds a merchant to the spawn room
        getRoom(0,0).addObject(new RoomObject("Merchant", "like a nice fella with a lot of goods (type \"wares\" to see his goods)"));
    }
    
    public void placeMandatoryItems()
    {
        Random rng = new Random();
        Room tempRoom = getRoom(rng.nextInt(dungeonWidth - 1) +1, rng.nextInt(dungeonHeight - 1) +1);
        if (tempRoom.hasObject("endgame chest"))
        {
            placeMandatoryItems();
            return;
        }
        tempRoom.addItem(new Item("Master Key", "", -1));
    }
    
    public void hardGenerateMap()
    {
        map.add(new Room(0,0));
        map.add(new Room(0,1));
        map.add(new Room(1,0));
        map.add(new Room(1,1));
        // Temp Start Room
        currentRoom = getRoom(0,0);
    }

    public Player getPlayer() {
        return player;
    }
    
    public String getCurrentRoomDescription(String command)
    {
        return currentRoom.generateDescription(player, this, command);
    }
    
    public Room getRoom(int x, int y)
    {
        for (Room r: map)
        {
            if (r.getX() == x && r.getY() == y)
            {
                return r;
            }
        }
        return null;
    }

    public void prepareMerchant()
    {
        merchantWares.add(new Item("Potion", "", 20));
        merchantWares.add(new Item("Potion", "", 20));
        merchantWares.add(new Item("Weapon Shard", "", 20));
        merchantWares.add(new Weapon("Giant Axe", "A big axe...", 50, 30));
        merchantWares.add(new Weapon("Small Axe", "An axe", 25, 12));
        merchantWares.add(new Weapon("Rubber Chicken", "Literally the best weapon in the game", 250, 850));
    }
    
    public String getMerchantWaresString()
    {
        String s = "The merchant has the following items for sale:" + System.lineSeparator();
        for (Item i : merchantWares)
        {
            String weapon = "";
            if (i.getClass().getName().equals("model.Weapon"))
            {
                weapon = " | Damage: " + ((Weapon)i).getDamage();
            }
            s += i.getName() + " | " + i.getDescription() + " | Price: " + i.getGoldValue() + weapon + System.lineSeparator();
        }
        return s;
    }
    
    public String buyMerchantItem(String itemName)
    {
        Item tempItem = getMerchantItem(itemName);
        if (player.getGold() >= tempItem.getGoldValue())
        {
            player.addItem(tempItem);
            player.decreaseGold(tempItem.getGoldValue());
            removeMerchantItem(tempItem.getName());
            return "Bought " + tempItem.getName() + "!";
        }
        return "You don't have enough gold to buy \"" + itemName + "\"";
    }
    
    public String sellToMerchant(String itemName)
    {
        Item tempItem = player.getItem(itemName);
        // Makes sure the price isn't -1 used for the end game key
        if (tempItem != null)
        {
            if (tempItem.getGoldValue() <= 0)
            {
                return "The merchant does not want that item";
            }
            int newPrice = tempItem.getGoldValue() / 2;
            addMerchantItem(tempItem);
            player.removeFromInventory(itemName);
            player.increaseGold(newPrice);
            return "Sold " + tempItem.getName() + " to the merchant for a price of " + newPrice;
        }
        return "You don't have the item \"" + itemName + "\"";
    }
    
    public Item getMerchantItem(String s)
    {
        for (Item i : merchantWares)
        {
            if (i.getName().equalsIgnoreCase(s))
            {
                return i;
            }
        }
        return null;
    }
    
    public void addMerchantItem(Item i)
    {
        merchantWares.add(i);
    }
    
    public void removeMerchantItem(String s)
    {
        for (int i = 0; i < merchantWares.size(); i++)
        {
            Item tempItem = merchantWares.get(i);
            if (tempItem.getName().equalsIgnoreCase(s))
            {
                merchantWares.remove(i);
                break;
            }
        }
    }
    
    public Room getCurrentRoom() 
    {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) 
    {
        this.currentRoom = currentRoom;
    }
    
    public Room getNorth(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX(), currentRoom.getY()+1);
        return r;
    }
    
    public Room getEast(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX()+1, currentRoom.getY());
        return r;
    }
    
    public Room getWest(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX()-1, currentRoom.getY());
        return r;
    }
    
    public Room getSouth(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX(), currentRoom.getY()-1);
        return r;
    }

    public int getLastDirection() 
    {
        return lastDirection;
    }
    
    public void setLastDirection(int dir) 
    {
        lastDirection = dir;
    }
    
    public String processInput(String s)
    {
        return ac.processInput(s);
    }
    
    public void addBuffTurns(int buff, int turns) {
        BUFFS[buff] += turns;
    }
    
    public int getBuffTurns(int buff) {
        return BUFFS[buff];
    }

    public int getTurnsUsed() {
        return turnsUsed;
    }
    
    public void nextTurn(MainWindow gui, boolean increment) {
        if (!increment) {
            gui.print("Turn: " + turnsUsed, true);
            return;
        }
        for (int i = 0; i < BUFFS.length; i++) {
            if (BUFFS[i] > 0) {
                BUFFS[i]--;
                if (BUFFS[i] == 0) {
                    gui.print("You feel the " + getBuffName(i) + " slowly dissipate from you.", true);
                    if (i == 1) {
                        player.decreaseMaxHp(10);
                        player.damagePlayer(10);
                    }
                }
            }
        }
        turnsUsed++;
        gui.print("Turn: " + turnsUsed, true);
    }
    
    private String getBuffName(int buff) {
        String[] buffs = {"buff of greater strength", "buff of greater health", "buff of greater resistance"};
        return buffs[buff];
    } 
    
}
