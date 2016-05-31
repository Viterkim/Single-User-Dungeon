
package model;

import control.RoomController;
import java.util.ArrayList;
import java.util.Random;


public class Room 
{
    
    ArrayList<RoomObject> roomObjects;
    ArrayList<Item> roomItems;
    
    private int x, y;
    private String description;
    private Monster monster;
    private boolean fightShown;
    private Random random;
    
    public Room(int x, int y) 
    {
        random = new Random();
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
    
    public String generateDescription(Player p, RoomController rc)
    {
        String s = generateMonsterDescription(p);
        if (s.equals(""))
        {
            s = generateItemDescription();
        }
        if (s.equals(""))
        {
            s = generateGeneralDescription(rc);
        }
        return s;
    }
    
    private String generateMonsterDescription(Player p)
    {
        String s = "";
        getMonster();
        if (monster != null && !fightShown)
        {
            if (random.nextBoolean()) {
                s += "You encounter a " + monster.getDescription() + ". You take " + monster.getDamage() + " from the initial encounter with the monster. You can attack or retreat.";
                p.damagePlayer(monster.getDamage());
            } else {
                s += "You encounter a " + monster.getDescription() + ". You take no damage from the initial encounter with the monster. You can attack or retreat.";
            }
            fightShown = true;
        }
        else if (monster != null && fightShown)
        {
            s += "The monster deals " + monster.getDamage() + " damage to you.";
            p.damagePlayer(monster.getDamage());
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
                s += "There's a " + o.getDescription() + " in the room." + System.lineSeparator();
            }
        }
        if (!roomItems.isEmpty())
        {
            for (Item i : roomItems)
            {
                s += "There's a " + i.getDescription() + " on the floor." + System.lineSeparator();
            }
        }
        return s;
    }
    
    private String generateGeneralDescription(RoomController rc)
    {
        String s = "";
        Random rng = new Random();
        String flavorAr[] = {"You see a hallway leading", "You see a passage going", "A door is located to the", "A set of stairs is available to the", "There's a small path leading", "A hole in the wall is located", "There's a hole in the ground you can climb through"};
        String flavorText = "";
        
        if (rc.getNorth(this) != null)
        {
            flavorText = flavorAr[rng.nextInt(flavorAr.length)];
            s += flavorText + " north" + System.lineSeparator();
        }
        if (rc.getSouth(this) != null)
        {
            flavorText = flavorAr[rng.nextInt(flavorAr.length)];
            s += flavorText + " south" + System.lineSeparator();
        }
        if (rc.getWest(this) != null)
        {
            flavorText = flavorAr[rng.nextInt(flavorAr.length)];
            s += flavorText + " west" + System.lineSeparator();
        }
        if (rc.getEast(this) != null)
        {
            flavorText = flavorAr[rng.nextInt(flavorAr.length)];
            s += flavorText + " east" + System.lineSeparator();
        }
        return s;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void addObject(RoomObject object) 
    {
        roomObjects.add(object);
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
    
}