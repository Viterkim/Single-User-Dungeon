
package control;

import java.util.Random;
import model.*;

public class ActionController 
{
    RoomController rc;
    
    public ActionController(RoomController rc)
    {
        this.rc = rc;
    }
    
    public String processInput(String s)
    {
        // Used for the "use" command
        String itemUsage = ((s.contains("use") && s.length() > 4) ? s.substring(4) : "");
        s = s.replaceAll(" " + itemUsage, "");
        switch(s.toLowerCase())
        {
            case "north":
                return goNorth();
            case "south":
                return goSouth();
            case "west":
                return goWest();
            case "east":
                return goEast();
            case "help":
                return help();
            case "attack":
                return attack();
            case "pickup":
                return "Not Available";
            case "use":
                return "Not Available";
            case "load":
                return "Not Available";
            case "save":
                return "Not Available";
            case "quit":
                System.exit(0);
            case "delete":
                return "Formatting C:// Drive...";
            case "current":
                return rc.getCurrentRoom().getDescription();
            case "retreat":
                switch (rc.getLastDirection()) {
                    case RoomController.DIRECTION_NORTH:
                        return goSouth();
                    case RoomController.DIRECTION_SOUTH:
                        return goNorth();
                    case RoomController.DIRECTION_EAST:
                        return goWest();
                    default:
                        return goEast();
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
        return "north, east, south, west... more info senere #tropådet";
    }
    
    public String attack() 
    {
        if (rc.getCurrentRoom().getMonster() == null)
        {
            return "There's no monster in the room!";
        }
        Player p = rc.getPlayer();
        Weapon w = p.getBestWeapon();
        Monster m = rc.getCurrentRoom().getMonster();
        m.damageMonster(w.getDamage());
        if (m.getCurrentHp() > 0) 
        {
            Random rng = new Random();
            int dropChance = 45;
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
                return "You dealt " + w.getDamage() + " damage to the " + m.getDescription();
            }
        }
        return "You killed the " + m.getDescription();
    }
}
