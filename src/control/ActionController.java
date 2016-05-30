
package control;

import model.Room;

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
                return "Not Available";
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
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_NORTH) 
            {
                rc.setCurrentRoom(north);
                return "Sucessfully entered the northern room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the north" + System.lineSeparator();
        }
        return "Fail";
    }
    
    public String goSouth() 
    {
        Room current = rc.getCurrentRoom();
        Room south = rc.getSouth(current);
        if (south != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_SOUTH) 
            {
                rc.setCurrentRoom(south);
                return "Sucessfully entered the southern room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the south" + System.lineSeparator();
        }
        return "Fail";
    }
    
    public String goWest() 
    {
        Room current = rc.getCurrentRoom();
        Room west = rc.getWest(current);
        if (west != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_WEST) 
            {
                rc.setCurrentRoom(west);
                return "Sucessfully entered the western room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the west" + System.lineSeparator();
        }
        return "Fail";
    }
    
    public String goEast() 
    {
        Room current = rc.getCurrentRoom();
        Room east = rc.getEast(current);
        if (east != null)
        {
            if (current.getMonster() == null || rc.getLastDirection() == RoomController.DIRECTION_EAST) 
            {
                rc.setCurrentRoom(east);
                return "Sucessfully entered the eastern room" + System.lineSeparator();
            }
            return "A monster blocks your path from leaving the room to the east" + System.lineSeparator();
        }
        return "Fail";
    }
    
    public String help()
    {
        return "north, east, south, west... more info senere #tropådet";
    }
}
