
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import model.*;
import view.MainWindow;

public class ActionController implements Serializable
{
    final int NORMAL_ATTACK = 0;
    final int POWER_ATTACK = 1;
    final int SUPER_ATTACK = 2;

    final int POWER_BUFF = 3;
    final int SUPER_BUFF = 10;
    
    final int POWER_COST = 5;
    final int SUPER_COST = 10;
    
    RoomController rc;
    
    public ActionController(RoomController rc)
    {
        this.rc = rc;
    }
    
    public String processInput(String s)
    {
        // Used for the "use" command
        s = s.toLowerCase();
        String itemUsage = ((s.contains("use") && s.length() > "use".length() + 1) ? s.substring("use".length()+1) : "").toLowerCase();
        String objectUsage = "";
        if (s.contains("interact") && s.length() > "interact".length() + 1) 
        {
            objectUsage = s.substring("interact".length()+1).toLowerCase();
        }
        if (s.contains("open") && s.length() > "open".length() + 1) 
        {
            objectUsage = s.substring("open".length() + 1).toLowerCase();
        }
        if (s.contains("buy") && s.length() > "buy".length() + 1) 
        {
            itemUsage = s.substring("buy".length() + 1).toLowerCase();
        }
        if (s.contains("sell") && s.length() > "sell".length() + 1) 
        {
            itemUsage = s.substring("sell".length() + 1).toLowerCase();
        }
        if (!itemUsage.equalsIgnoreCase(""))
        {
            s = s.replaceAll(" " + itemUsage, "");
        }
        else if(!objectUsage.equalsIgnoreCase(""))
        {
            s = s.replaceAll(" " + objectUsage, "");
        }
        switch(s.toLowerCase())
        {
            case "north":
                return goNorth();
            case "up":
                return goNorth();
            case "south":
                return goSouth();
            case "down":
                return goSouth();
            case "west":
                return goWest();
            case "left":
                return goWest();
            case "east":
                return goEast();
            case "right":
                return goEast();
            case "help":
                return help();
            case "attack":
                return attack(0);
            case "powerattack":
                if (rc.getPlayer().getCurrentEnergy() >= POWER_COST)
                {
                    return attack(1);
                }
                return "Don't have enough energy for a power attack!";
            case "superattack":
                if (rc.getPlayer().getCurrentEnergy() >= SUPER_COST)
                {
                    return attack(2);
                }
                return "Don't have enough energy for a super attack!";
            case "pickup":
                return pickup();
            case "use":
                return use(itemUsage);
            case "inventory":
                return inventory();
            case "load":
                String playerName = rc.getPlayer().getName();
                RoomController newController = SaveLoadHandler.load(playerName);
                if (newController == null)
                {
                    return "No saves found for " + playerName + "!";
                }
                this.rc = newController;
                MainWindow.setRoomController(newController);
                return "Loaded from save!";
            case "save":
                SaveLoadHandler.save(rc, rc.getPlayer().getName());
                return "Saved the game!";
            case "quit":
                System.exit(0);
            case "interact":
                return interact(objectUsage);
            case "open":
                return interact(objectUsage);
            case "story":
                return rc.getPlayer().getStory();
            case "delete":
                return "Formatting C:// Drive...";
            case "current":
                return rc.getCurrentRoom().generateDescription(rc.getPlayer(), rc, s);
            case "retreat":
                switch (rc.getLastDirection()) 
                {
                    case RoomController.DIRECTION_NORTH:
                        return goSouth();
                    case RoomController.DIRECTION_SOUTH:
                        return goNorth();
                    case RoomController.DIRECTION_EAST:
                        return goWest();
                    default:
                        return goEast();
                }
            case "buy":
                if (rc.getCurrentRoom().hasObject("merchant"))
                {
                    return rc.buyMerchantItem(itemUsage);
                }
                return "There's no merchant in the room!";
            case "sell":
                if (rc.getCurrentRoom().hasObject("merchant"))
                {
                    return rc.sellToMerchant(itemUsage);
                }
                return "There's no merchant in the room!";
            case "wares":
            {
                if (rc.getCurrentRoom().hasObject("merchant"))
                {
                    return rc.getMerchantWaresString();
                }
                return "There's no merchant in the room!";
            }
            default:
                return "Unknown Command";
        }
    }
    
    public String goNorth() 
    {
        Room current = rc.getCurrentRoom();
        Room north = rc.getNorth(current);
        if (north != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_SOUTH) 
            {
                
                rc.setCurrentRoom(north);
                rc.setLastDirection(RoomController.DIRECTION_NORTH);
                return "Sucessfully entered the northern room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the north" + System.lineSeparator();
        }
        return "You cannot go north";
    }
    
    public String goSouth() 
    {
        Room current = rc.getCurrentRoom();
        Room south = rc.getSouth(current);
        if (south != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_NORTH) 
            {
                rc.setCurrentRoom(south);
                rc.setLastDirection(RoomController.DIRECTION_SOUTH);
                return "Sucessfully entered the southern room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the south" + System.lineSeparator();
        }
        return "You cannot go south";
    }
    
    public String goWest() 
    {
        Room current = rc.getCurrentRoom();
        Room west = rc.getWest(current);
        if (west != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_EAST) 
            {
                rc.setCurrentRoom(west);
                rc.setLastDirection(RoomController.DIRECTION_WEST);
                return "Sucessfully entered the western room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the west" + System.lineSeparator();
        }
        return "You cannot go west";
    }
    
    public String goEast() 
    {
        Room current = rc.getCurrentRoom();
        Room east = rc.getEast(current);
        if (east != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_WEST) 
            {
                rc.setCurrentRoom(east);
                rc.setLastDirection(RoomController.DIRECTION_EAST);
                return "Sucessfully entered the eastern room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the east" + System.lineSeparator();
        }
        return "You cannot go east";
    }
    
    public String help()
    {
        return "north/up    |   travels in the given direction" + System.lineSeparator()
                + "east/right   |   travels in the given direction," + System.lineSeparator()
                + "south/down   |   travels in the given direction," + System.lineSeparator()
                + "west/left    |   travels in the given direction" + System.lineSeparator()
                + "retreat  |    retreats back to the room you were in before" + System.lineSeparator()
                + "attack |   uses a turn on damaging a monster" + System.lineSeparator()
                + "powerattack |   a more powerful attack (costs 5 energy)" + System.lineSeparator()
                + "superattack |   a SUPER powerful attack (costs 10 energy)" + System.lineSeparator()
                + "pickup   | picks up all items from the floor" + System.lineSeparator()
                + "interact/open + xxx   |   interacts with an object in the room (ex: \"interact chest\")" + System.lineSeparator()
                + "current  |   gives current information about the room you are in" + System.lineSeparator()
                + "load/save    |   loads or saves the game" + System.lineSeparator()
                + "inventory    |  displays your inventory" + System.lineSeparator()
                + "delete   | give it a shot..." + System.lineSeparator()
                + "use + xxx    |   uses an item from your inventory (ex: \"use potion\")" + System.lineSeparator()
                + "story    |   depicts the tale of our epic hero as a figurative tsunami" + System.lineSeparator()
                + "quit |   quits the game";
    }
    
    public String attack(int type) 
    {
        if (rc.getCurrentRoom().getMonster() == null)
        {
            return "There's no monster in the room!";
        }
        int buff = (rc.getBuffTurns(RoomController.BUFF_DAMAGE) > 0 ? 5 : 0);
        int typeBuff = 0;
        
        if (type != NORMAL_ATTACK)
        {
            if (type == POWER_ATTACK)
            {
                typeBuff += POWER_BUFF;
            }
            else if (type == SUPER_ATTACK)
            {
                typeBuff += SUPER_BUFF;
            }
        }
        Player p = rc.getPlayer();
        Weapon w = p.getBestWeapon();
        Monster m = rc.getCurrentRoom().getMonster();
        m.damageMonster(w.getDamage() + buff + typeBuff);
        if (m.getCurrentHp() > 0) 
        {
            Random rng = new Random();
            int dropChance = 100;
            if (rng.nextInt(100) <= dropChance)
            {
                int weaponDropChance = 20;
                if (rng.nextInt(100) < weaponDropChance)
                {
                    rc.getCurrentRoom().addItem(WeaponGenerator.GenerateRandomWeapon());
                }
                else
                {
                    rc.getCurrentRoom().addItem(ItemGenerator.GenerateRandomItem());
                }
            }
            if (m.getCurrentHp() > 0) 
            {
                String flavorText = "";
                if (buff > 0) 
                {
                    flavorText += "And an extra " + buff + " from your greater strength buff. ";
                }
                if (typeBuff > 0)
                {
                    flavorText += "Your special attack buffed your attack by " + typeBuff;
                }
                return "You dealt " + w.getDamage() + " damage to the " + m.getDescription() + "! " + flavorText;
            }
        }
        return "You killed the " + m.getDescription();
    }
    
    public String pickup() 
    {
        String items = "";
        ArrayList<Item> list = (ArrayList<Item>) rc.getCurrentRoom().getRoomItems().clone();
        if (list.size() <= 0) 
        {
            return "No items available to pick up!";
        }
        for (Item i : list) 
        {
            rc.getPlayer().addItem(i);
            rc.getCurrentRoom().removeItem(i);
            items += i.getName() + ", ";
        }
        items = items.substring(0, items.length() - 1);
        return "You picked up " + items + " from the floor.";
    }
    
    public String use(String itemName) 
    {
        ArrayList<Item> items = (ArrayList<Item>) rc.getPlayer().getInventory().clone();
        for (Item i : items) 
        {
            if (i.getName().toLowerCase().equals(itemName)) 
            {
                return i.use(rc.getPlayer());
            }
        }
        return "You don't have the item \"" + itemName + "\" in your inventory.";
    }
    
    public String interact(String objectName) 
    {
        ArrayList<RoomObject> objects = rc.getCurrentRoom().getRoomObjects();
        for (RoomObject o : objects) 
        {
            if (o.getName().equalsIgnoreCase(objectName)) 
            {
                return o.interact(rc);
            }
        }
        return "This object does not exist!";
    }
    
    public String inventory() 
    {
        String s = "Your inventory contains:" + System.lineSeparator();
        for (Item i : rc.getPlayer().getInventory()) 
        {
            String wepDmg = (i.getClass().getName().equals("model.Weapon") ? " | " + ((Weapon) i).getDamage() + " damage" : "");
            s += "- " + i.getName() + " | " + i.getDescription() + wepDmg + System.lineSeparator();
        }
        return s;
    }
    
}