
package model;

import java.util.Random;


public class WeaponGenerator 
{
    private static final String[] NAMES = {"Bastard Sword", "Long Sword", "Short Sword"};
    private static final String[] DESCRIPTIONS = {"a shiny weapon", "a dirty weapon", "a factory new weapon"};
    private static final int[] VALUE = {5, 7, 10, 12, 14, 15, 17, 20, 25};
    private static final int[] DAMAGES = {5, 7, 10, 12, 14, 15, 17, 20};
     
    /**
     * Generates a random weapon from the above table values.
     * @return A randomly generated weapon.
     */
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
