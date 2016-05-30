
package control;

import java.util.ArrayList;
import model.Room;

public class RoomController 
{
    private ArrayList<Room> map;
    private ActionController ac;
    private Room currentRoom;
    
    public RoomController()
    {
        ac = new ActionController(this);
        map = new ArrayList<>();
        generateMap();
    }
    
    //Hardcode temp
    public void generateMap()
    {
        map.add(new Room(0,0));
        map.add(new Room(0,1));
        map.add(new Room(1,0));
        map.add(new Room(1,1));
        // Temp Start Room
        currentRoom = getRoom(0,0);
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
    
    public String processInput(String s)
    {
        return ac.processInput(s);
    }
}
