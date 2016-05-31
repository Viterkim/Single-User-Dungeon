
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
        inventory.add(new Weapon("Fists", "your own fists", 0, 5));
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

    public int getLevel() 
    {
        return level;
    }

    public int getCurrentHp() 
    {
        return currentHp;
    }
    
    public void damagePlayer(int damage)
    {
        this.currentHp -= damage;
    }
    
    public void healPlayer(int damage)
    {
        this.currentHp += damage;
        if (currentHp > maxHp)
        {
            currentHp = maxHp;
        }
    }

    public int getMaxHp() 
    {
        return maxHp;
    }

    public ArrayList<Item> getInventory() 
    {
        return inventory;
    }

    public int getGold() 
    {
        return gold;
    }

    public void increaseGold(int gold) 
    {
        this.gold += gold;
    }
    
    public void decreaseGold(int gold) 
    {
        this.gold -= gold;
    }
    
    public void addItem(Item item) {
        inventory.add(item);
    }
    
    public Weapon getBestWeapon() {
        Weapon bestWeapon = null;
        for (Item i : inventory) {
            if (i instanceof Weapon) {
                if (bestWeapon == null || bestWeapon.getDamage() < ((Weapon) i).getDamage()) {
                    bestWeapon = (Weapon) i;
                }
            }
        }
        return bestWeapon;
    }
    
}
