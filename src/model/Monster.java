
package model;


public class Monster 
{
    private String name;
    private String description;
    private int maxHp, currentHp;
    private int damage;

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

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public int getMaxHp() 
    {
        return maxHp;
    }

    public void setMaxHp(int maxHp) 
    {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() 
    {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) 
    {
        this.currentHp = currentHp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) 
    {
        this.damage = damage;
    }
    
    
    
}
