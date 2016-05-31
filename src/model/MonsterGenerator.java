/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author CHRIS
 */
public class MonsterGenerator 
{
 
    private static String[] NAMES = {"Frank", "Billy", "Tom", "Casper", "Ongo", "Viggo", "Hugo", "Peter"};
    private static String[] DESCRIPTIONS = {"blob of goo", "huge skeleton", "angry dwarf", "big snake", "cockraoch", "magical angry rock"};
    private static int[] HPS = {5, 6 , 7 , 8, 9, 10, 15, 20, 25, 30};
    private static int[] DAMAGES = {3, 4, 5, 6, 7, 8, 9, 10, 11};
    
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