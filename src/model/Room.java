
package model;

import control.RoomController;
import java.util.ArrayList;
import java.util.Random;


public class Room 
{
    
    ArrayList<RoomObject> roomObjects;
    ArrayList<Item> roomItems;
    
    private int x, y;
    private Monster monster;
    private boolean fightShown;
    private Random random;
    private String[] directionDescription;
    
    public Room(int x, int y) 
    {
        random = new Random();
        directionDescription = new String[4];
        fillDirectionalDescriptions();
        this.x = x;
        this.y = y;
        roomObjects = new ArrayList<>();
        roomItems = new ArrayList<>();
    }

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }
    
    public String generateDescription(Player p, RoomController rc, String command)
    {
        if (command.equalsIgnoreCase("help") || command.equalsIgnoreCase("inventory")) {
            return "";
        }
        String s = generateMonsterDescription(rc, p, command);
        if (s.equals(""))
        {
            s = generateItemDescription();
            s += generateGeneralDescription(rc);
        }
        return s;
    }
    
    private String generateMonsterDescription(RoomController rc, Player p, String command)
    {
        String s = "";
        getMonster();
        if (monster != null && !fightShown)
        {
            if (random.nextBoolean()) 
            {
                s += "You encounter " + monster.getName() + " which is a " + monster.getDescription() + ". You take " + monster.getDamage() + " from the initial encounter with the monster. You can attack or retreat.";
                p.damagePlayer(monster.getDamage());
            } 
            else 
            {
                s += "You encounter " + monster.getName() + " which is a " + monster.getDescription() + ". You take no damage from the initial encounter with the monster. You can attack or retreat.";
            }
            fightShown = true;
        }
        else if (monster != null && fightShown)
        {
            if (command.equalsIgnoreCase("current")) {
                return "You find yourself in a room with " + monster.getName() + " which is a " + monster.getDescription();
            }
            boolean buffActive = (rc.getBuffTurns(RoomController.BUFF_RESISTANCE) > 0);
            int damage = monster.getDamage() - (buffActive ? 3 : 0);
            if (buffActive) {
                s += "The monster deals a decreased damage to you because of the buff, you only take " + damage + " damage.";
            } else {
                s += "The monster deals " + damage + " damage to you.";
            }
            p.damagePlayer(damage);
        }
        return s;
    }
    
    private String generateItemDescription()
    {
        String s = "";
        if (!roomObjects.isEmpty())
        {
            for (RoomObject o : roomObjects)
            {
                s += "There's a " + o.getName() + " in the room, which looks " + o.getDescription() + "." + System.lineSeparator();
            }
        }
        if (!roomItems.isEmpty())
        {
            for (Item i : roomItems)
            {
                s += "There's a " + i.getName() + " on the floor, which looks "+ i.getDescription() + "." + System.lineSeparator();
            }
        }
        return s;
    }
    
    private void fillDirectionalDescriptions()
    {
        String flavorAr[] = {"You see a hallway leading", "You see a passage going", "A door is located to the", "A set of stairs is available to the", "There's a small path leading", "A hole in the wall is located", "There's a hole in the ground you can climb through"};
        Random rng = new Random();
        for (int i = 0; i < 4; i++) 
        {
            directionDescription[i] = flavorAr[rng.nextInt(flavorAr.length)];
        }
    }
    
    private String generateGeneralDescription(RoomController rc)
    {
        String s = "";
        if (rc.getNorth(this) != null)
        {
            s += directionDescription[RoomController.DIRECTION_NORTH] + " north" + System.lineSeparator();
        }
        if (rc.getSouth(this) != null)
        {
            s += directionDescription[RoomController.DIRECTION_SOUTH] + " south" + System.lineSeparator();
        }
        if (rc.getWest(this) != null)
        {
            s += directionDescription[RoomController.DIRECTION_WEST] + " west" + System.lineSeparator();
        }
        if (rc.getEast(this) != null)
        {
            s += directionDescription[RoomController.DIRECTION_EAST] + " east" + System.lineSeparator();
        }
        return s;
    }
    
    public boolean hasObject(String s)
    {
        for (RoomObject o : roomObjects)
        {
            if (o.getName().equalsIgnoreCase(s))
            {
                return true;
            }
        }
        return false;
    }
    
    public void addObject(RoomObject object) 
    {
        roomObjects.add(object);
    }
    
    public void addItem(Item item) 
    {
        roomItems.add(item);
    }
    
    public void addMonster(Monster monster)
    {
        if (this.monster == null) 
        {
            this.monster = monster; 
        } 
        else 
        {
            System.out.println("Error! Monster already exists in this room!");
        }
    }

    public Monster getMonster() 
    {
        if (monster != null && monster.getCurrentHp() <= 0)
        {
            monster = null;
        }
        return monster;
    }

    public ArrayList<RoomObject> getRoomObjects() 
    {
        return roomObjects;
    }

    public ArrayList<Item> getRoomItems() 
    {
        return roomItems;
    }
    
    public void removeItem(Item i) 
    {
        roomItems.remove(i);
    }
 
    public void removeObject(String name) 
    {
        ArrayList<RoomObject> cloned = (ArrayList<RoomObject>) roomObjects.clone();
        for (RoomObject o : cloned) 
        {
            if (o.getName().equalsIgnoreCase(name)) 
            {
                roomObjects.remove(o);
                return;
            }
        }
    }
    
}