
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RoomObjectGenerator 
{
    private static final List<String> objects = new ArrayList<>(Arrays.asList("Green Lamp", "Red Lamp", "Blue Lamp", "Normal Chest", "Giant Chest", "Stash Of Bones"));
    private static final String[] DESCRIPTIONS = {"glimmering", "dirty", "shiny", "old", "new"};
    
    public static RoomObject GenerateRandomObject() 
    {
        if (objects.size() <= 0)
        {
            return null;
        }
        Random random = new Random();
        int randNum = random.nextInt(objects.size());
        String name = objects.get(randNum);
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        objects.remove(randNum);
        return new RoomObject(name, description);
    }
}
