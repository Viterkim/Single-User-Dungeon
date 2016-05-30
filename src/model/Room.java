
package model;

import java.util.ArrayList;


public class Room 
{
    
    ArrayList<RoomObject> objects;
    
    private int x, y;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        objects = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void addObject(RoomObject object) {
        objects.add(object);
    }
    
    
    
}