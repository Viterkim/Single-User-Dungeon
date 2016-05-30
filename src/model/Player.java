
package model;

import java.util.ArrayList;

public class Player 
{
    private String name;
    private int level, currentHp, maxHp, gold;
    private ArrayList<Item> inventory;
    
    public Player(String name)
    {
        this.name = name;
        this.level = 1;
        this.maxHp = 30;
        this.currentHp = maxHp;
        this.gold = 0;
        inventory = new ArrayList<>();
        
    }
    
    public void levelUp()
    {
        this.level++;
        this.maxHp += 10;
        this.currentHp = maxHp;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getLevel() 
    {
        return level;
    }

    public void setLevel(int level) 
    {
        this.level = level;
    }

    public int getCurrentHp() 
    {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) 
    {
        this.currentHp = currentHp;
    }

    public int getMaxHp() 
    {
        return maxHp;
    }

    public void setMaxHp(int maxHp) 
    {
        this.maxHp = maxHp;
    }

    public ArrayList<Item> getInventory() 
    {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) 
    {
        this.inventory = inventory;
    }

    public int getGold() 
    {
        return gold;
    }

    public void setGold(int gold) 
    {
        this.gold = gold;
    }
    
    
    
    
}
