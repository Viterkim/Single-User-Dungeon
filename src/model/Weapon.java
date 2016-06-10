
package model;

import java.io.Serializable;

/**
 * This class extends Item, and has the extra field damage
 */
public class Weapon extends Item implements Serializable
{
    
    private int damage;
    
    public Weapon(String name, String description, int goldValue, int damage) 
    {
        super(name, description, goldValue);
        this.damage = damage;
    }
    
    public void increaseDamage(int amount)
    {
        damage += amount;
    }
    
    public int getDamage() 
    {
        return damage;
    }
    
}