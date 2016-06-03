
package control;

import java.util.ArrayList;
import java.util.Random;
import model.MonsterGenerator;
import model.Player;
import model.Room;
import model.RoomObject;
import model.RoomObjectGenerator;

public class RoomController 
{
    
    static final String[] DIRECTIONS = {"North", "South", "East", "West"};
    
    public static final int DIRECTION_NORTH = 0;
    public static final int DIRECTION_SOUTH = 1;
    public static final int DIRECTION_EAST = 2;
    public static final int DIRECTION_WEST = 3;
    
    private ArrayList<Room> map;
    private ActionController ac;
    private Room currentRoom;
    private Player player;
    private int lastDirection = -1;
    private int dungeonHeight, dungeonWidth;
    private Random random;
    
    public RoomController(Player player)
    {
        random = new Random();
        ac = new ActionController(this);
        map = new ArrayList<>();
        this.player = player;
        //hardGenerateMap();
        dungeonHeight = 3;
        dungeonWidth = 3;
        randomGenerateMap(dungeonWidth, dungeonHeight, 30, 5);
    }
    
    public void randomGenerateMap(int width, int height, int monsterChance, int objectChance) 
    {
        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++) 
            {
                Room r = new Room(x, y);
                if (random.nextInt(100) <= monsterChance) 
                {
                    r.addMonster(MonsterGenerator.GenerateRandomMonster());
                }
                if (random.nextInt(100) < objectChance)
                {
                    RoomObject tempObj = RoomObjectGenerator.GenerateRandomObject();
                    if (tempObj != null)
                    {
                        r.addObject(tempObj);
                    }
                }
                map.add(r);
            }
        }
        currentRoom = getRoom(0, 0);
        if (currentRoom.getMonster() != null) 
        {
            currentRoom.getMonster().damageMonster(999);
        }
        placeMandatoryObjects();
    }

    public void placeMandatoryObjects()
    {
        Random rng = new Random();
        Room tempRoom = getRoom(rng.nextInt(dungeonWidth - 1) +1, rng.nextInt(dungeonHeight - 1) +1);
        tempRoom.addObject(new RoomObject("Endgame Chest", "overflowing with coolness!"));
    }
    
    public void hardGenerateMap()
    {
        map.add(new Room(0,0));
        map.add(new Room(0,1));
        map.add(new Room(1,0));
        map.add(new Room(1,1));
        // Temp Start Room
        currentRoom = getRoom(0,0);
    }

    public Player getPlayer() {
        return player;
    }
    
    public String getCurrentRoomDescription(String command)
    {
        return currentRoom.generateDescription(player, this, command);
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
        return r;
    }
    
    public Room getEast(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX()+1, currentRoom.getY());
        return r;
    }
    
    public Room getWest(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX()-1, currentRoom.getY());
        return r;
    }
    
    public Room getSouth(Room currentRoom)
    {
        Room r = getRoom(currentRoom.getX(), currentRoom.getY()-1);
        return r;
    }

    public int getLastDirection() 
    {
        return lastDirection;
    }
    
    public void setLastDirection(int dir) 
    {
        lastDirection = dir;
    }
    
    public String processInput(String s)
    {
        return ac.processInput(s);
    }
}
