
package model;

import java.io.Serializable;


public class Monster implements Serializable
{
    private final String name, description;
    private final int maxHp, damage;
    private int currentHp;

    public Monster(String name, String description, int maxHp, int currentHp, int damage) 
    {
        this.name = name;
        this.description = description;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.damage = damage;
    }
    
    public String getName() 
    {
        return name;
    }

    public String getDescription() 
    {
        return description;
    }

    public int getMaxHp() 
    {
        return maxHp;
    }

    public int getCurrentHp() 
    {
        return currentHp;
    }

    public int getDamage() 
    {
        return damage;
    }
    
    public void damageMonster(int damage) 
    {
        currentHp -= damage;
    }
    
}
