
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
            rc.setCurrentRoom(north);
            return "Sucessfully entered the northern room";
        }
        return "Fail";
    }
    
    public String goSouth() 
    {
        Room current = rc.getCurrentRoom();
        Room south = rc.getSouth(current);
        if (south != null)
        {
            rc.setCurrentRoom(south);
            return "Sucessfully entered the southern room";
        }
        return "Fail";
    }
    
    public String goWest() 
    {
        Room current = rc.getCurrentRoom();
        Room west = rc.getWest(current);
        if (west != null)
        {
            rc.setCurrentRoom(west);
            return "Sucessfully entered the western room";
        }
        return "Fail";
    }
    
    public String goEast() 
    {
        Room current = rc.getCurrentRoom();
        Room east = rc.getEast(current);
        if (east != null)
        {
            rc.setCurrentRoom(east);
            return "Sucessfully entered the eastern room";
        }
        return "Fail";
    }
    
    public String help()
    {
        return "Tro på det";
    }
}
