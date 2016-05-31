
package model;

import java.util.Random;


public class ItemGenerator 
{
    private static String[] NAMES = {"Ruby", "Pearl", "Silver Necklace", "Golden Nugget", "Gold Coins", "Potion", "Weapon Shard", "Shroom"};
    private static String[] DESCRIPTIONS = {"a shiny item", "a dirty item", "a factory item"};
    private static int[] VALUE = {10, 20 , 25, 50, 200, 300};
    
    public static Item GenerateRandomItem() 
    {
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        switch (name.toLowerCase())
        {
            case "gold coins":
                description = "lovely money!";
                break;
            case "potion":
                description = "a potion that heals you to full health!";
                break;
            case "weapon shard":
                description = "a magical shard, it will increase your weapon damage!";
                break;
            case "shroom":
                description = "you probably shouldn't eat this";
                break;
        }
        int value = VALUE[random.nextInt(VALUE.length)];
        return new Item(name, description, value);
    }
}
