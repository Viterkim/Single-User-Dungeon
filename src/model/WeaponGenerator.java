
package model;

import java.util.Random;


public class WeaponGenerator 
{
    private static String[] NAMES = {"Bastard Sword", "Long Sword",};
    private static String[] DESCRIPTIONS = {"a shiny weapon", "a dirty weapon", "a factory new weapon"};
    private static int[] VALUE = {5, 7, 10, 12, 14, 15, 17, 20, 25};
    private static int[] DAMAGES = {5, 7, 10, 12, 14, 15, 17, 20};
    
    public static Weapon GenerateRandomWeapon() 
    {
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        int value = VALUE[random.nextInt(VALUE.length)];
        int damage = DAMAGES[random.nextInt(DAMAGES.length)];
        return new Weapon(name, description, value, damage);
    }
}
