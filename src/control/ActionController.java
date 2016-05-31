
package control;

import java.util.ArrayList;
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
        String itemUsage = ((s.contains("use") && s.length() > 4) ? s.substring(4) : "").toLowerCase();
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
                return pickup();
            case "use":
                return use(itemUsage);
            case "inventory":
                return inventory();
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
                return "You dealt " + w.getDamage() + " damage to the " + m.getDescription();
            }
        }
        return "You killed the " + m.getDescription();
    }
    
    public String pickup() {
        String items = "";
        ArrayList<Item> list = (ArrayList<Item>) rc.getCurrentRoom().getRoomItems().clone();
        if (list.size() <= 0) {
            return "No items available to pick up!";
        }
        for (Item i : list) {
            rc.getPlayer().addItem(i);
            rc.getCurrentRoom().removeItem(i);
            items += i.getName() + ", ";
        }
        items = items.substring(0, items.length() - 1);
        return "You picked up " + items + " from the floor.";
    }
    
    public String use(String itemName) {
        ArrayList<Item> items = (ArrayList<Item>) rc.getPlayer().getInventory().clone();
        for (Item i : items) {
            if (i.getName().toLowerCase().equals(itemName)) {
                return i.use(rc.getPlayer());
            }
        }
        return "You don't have that item in your inventory.";
    }
    
    public String inventory() {
        String s = "Your inventory contains:" + System.lineSeparator();
        for (Item i : rc.getPlayer().getInventory()) {
            s += "- " + i.getName() + System.lineSeparator();
        }
        return s;
    }

}