
package model;

import java.util.ArrayList;

public class Player 
{
    private String name;
    private int level, currentHp, maxHp;
    private ArrayList<Item> inventory;
    
    public Player(String name)
    {
        this.name = name;
        this.level = 1;
        this.maxHp = 30;
        this.currentHp = maxHp;
        inventory = new ArrayList<>();
        
    }
    public void levelUp()
    {
        this.maxHp += 10;
        this.currentHp = maxHp;
    }
}
