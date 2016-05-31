
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RoomObjectGenerator 
{
    private static List<String> places = new ArrayList<String>(Arrays.asList("Green Lamp", "Red Lamp", "Normal Chest", "Giant Chest", "Stash Of Bones"));
    private static String[] DESCRIPTIONS = {"glimmering", "dirty", "shiny", "old", "new"};
    
    public static RoomObject GenerateRandomObject() 
    {
        if (places.size() <= 0)
        {
            return null;
        }
        Random random = new Random();
        int randNum = random.nextInt(places.size());
        String name = places.get(randNum);
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        places.remove(randNum);
        return new RoomObject(name, description);
    }
}
