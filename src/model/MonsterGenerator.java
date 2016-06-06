
package model;

import java.util.Random;


public class MonsterGenerator 
{
 
    private static final String[] NAMES = {"Frank", "Billy", "Tom", "Casper", "Ongo", "Viggo", "Hugo", "Peter", "Chris", "Viktor", "Mathias", "Muhammed", "Abdul", "Jesus", "Zelda"};
    private static final String[] DESCRIPTIONS = {"blob of goo", "huge skeleton", "angry dwarf", "big snake", "cockraoch", "magical angry rock", "flying bat", "small gnoll", "angry robot"};
    private static final int[] HPS = {5, 6 , 7 , 8, 9, 10, 15, 20, 25, 30, 35};
    private static final int[] DAMAGES = {3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15};
    
    public static Monster GenerateRandomMonster() 
    {
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        int hp = HPS[random.nextInt(HPS.length)];
        int damage = DAMAGES[random.nextInt(DAMAGES.length)];
        return new Monster(name, description, hp, hp, damage);
    }
    
}