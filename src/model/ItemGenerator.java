
package model;

import java.util.Random;


public class ItemGenerator 
{
    private static String[] NAMES = {"Ruby", "Pearl", "Silver Necklace", "Golden Nugget", "Gold Coins", "Potion", "Weapon Shard", "Shroom", "armor"};
    private static String[] DESCRIPTIONS = {"shiny", "dirty", "broken"};
    private static int[] VALUE = {10, 20 , 25, 50, 200, 300};
    
    public static Item GenerateRandomItem() 
    {
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        int value = VALUE[random.nextInt(VALUE.length)];
        return new Item(name, description, value);
    }
    
}