
package control;

import java.util.ArrayList;
import model.Player;
import model.Room;

public class RoomController 
{
    
    static final int DIRECTION_NORTH = 0;
    static final int DIRECTION_SOUTH = 1;
    static final int DIRECTION_EAST = 2;
    static final int DIRECTION_WEST = 3;
    
    private ArrayList<Room> map;
    private ActionController ac;
    private Room currentRoom;
    private Player player;
    private int lastDirection;
    
    
    public RoomController(Player player)
    {
        ac = new ActionController(this);
        map = new ArrayList<>();
        this.player = player;
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
    
    public String getCurrentRoomDescription()
    {
        return currentRoom.generateDescription(player, this);
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
        Room r = getRoom(currentRoom.getX(), currentRoom.getY()+1);
        if (r != null) {
            lastDirection = DIRECTION_NORTH;
        }
        return r;
    }
    
    public Room getEast(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX()+1, currentRoom.getY());
        if (r != null) {
            lastDirection = DIRECTION_EAST;
        }
        return r;
    }
    
    public Room getWest(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX()-1, currentRoom.getY());
        if (r != null) {
            lastDirection = DIRECTION_WEST;
        }
        return r;
    }
    
    public Room getSouth(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX(), currentRoom.getY()-1);
        if (r != null) {
            lastDirection = DIRECTION_SOUTH;
        }
        return r;
    }

    public int getLastDirection() {
        return lastDirection;
    }
    
    public String processInput(String s)
    {
        return ac.processInput(s);
    }
}
