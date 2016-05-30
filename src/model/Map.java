
package model;

import java.util.ArrayList;


public class Map 
{
    private ArrayList<Room> rooms;
    
    public Map()
    {
        rooms = new ArrayList<>();
    }
    
    //Hardcode temp
    public void generateMap()
    {
        rooms.add(new Room(0,0));
        rooms.add(new Room(0,1));
        rooms.add(new Room(1,0));
        rooms.add(new Room(1,1));
    }
    
    public Room getRoom(int x, int y)
    {
        for (Room r: rooms)
        {
            if (r.getX() == x && r.getY() == y)
            {
                return r;
            }
        }
        return null;
    }
    
    public Room getNorth(Room currentRoom)
    {
        return getRoom(currentRoom.getX(), currentRoom.getY()+1);
    }
    
    public Room getEast(Room currentRoom)
    {
        return getRoom(currentRoom.getX()+1, currentRoom.getY());
    }
    
    public Room getWest(Room currentRoom)
    {
        return getRoom(currentRoom.getX()-1, currentRoom.getY());
    }
    
    public Room getSouth(Room currentRoom)
    {
        return getRoom(currentRoom.getX(), currentRoom.getY()-1);
    }
}
