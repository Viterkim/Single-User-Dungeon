
package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Player 
{
    private String name;
    private int level, currentHp, maxHp, gold;
    private ArrayList<Item> inventory;
    
    public Player()
    {
        setNewName();
        this.level = 1;
        this.maxHp = 30;
        this.currentHp = maxHp;
        this.gold = 20;
        inventory = new ArrayList<>();
        initInventory();
    }
    
    private void initInventory() 
    {
        inventory.clear();
        inventory.add(new Weapon("Fists", "your own fists", 0, 5));
        inventory.add(new Item("Potion", "", 50));
        inventory.add(new Item("Potion", "", 50));
    }
    
    public void levelUp()
    {
        this.level++;
        this.maxHp += 10;
        this.currentHp = maxHp;
    }
    
    public void doEndSequence()
    {
        JOptionPane.showMessageDialog(null, "Ez win game best game eu");
        System.exit(0);
    }
    
    public void setNewName()
    {
        String tempName = JOptionPane.showInputDialog(null, "What is your name?");
        if (tempName.equals(""))
        {
            tempName = "Player";
        }
        this.name = tempName;
    }
    
    public String getStory()
    {
        String story = "85 years ago in a small country called Russia. A small village had around 85 villagers and one of those were called " + name +
                ".\nOne day while travelling to the market to buy some apples, " + name + " fell into a hole and suddenly they found themselves in this weird dungeon.\nGood luck";
        return story;
    }
    
    public void increaseMaxHp(int amount)
    {
        this.maxHp += amount;
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

    public void removeFromInventory(String name)
    {
        for (Item i : inventory)
        {
            if (i.getName().equalsIgnoreCase(name))
            {
                inventory.remove(i);
                return;
            }
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
    
    public void addItem(Item item)
    {
        inventory.add(item);
    }
    
    public Weapon getBestWeapon() 
    {
        Weapon bestWeapon = null;
        for (Item i : inventory) 
        {
            if (i instanceof Weapon) 
            {
                if (bestWeapon == null || bestWeapon.getDamage() < ((Weapon) i).getDamage()) {
                    bestWeapon = (Weapon) i;
                }
            }
        }
        return bestWeapon;
    }
}
