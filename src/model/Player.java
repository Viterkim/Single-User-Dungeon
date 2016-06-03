
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
        inventory.add(new Weapon("Fists", "your own fists", -1, 5));
        inventory.add(new Item("Potion", "", 20));
        inventory.add(new Item("Potion", "", 20));
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
        String story = "85 years ago in a small country called Russia, a small village was inhabited by 85 villagers and one of them was called " + name + "." + 
                        System.lineSeparator() + 
                        "One day while travelling to the market to buy some apples, " + name + " fell into a hole and suddenly found themselves in a weird dungeon." + 
                        System.lineSeparator() +
                        "On the ground, a few feet away from the fall location, " + name + " sees 2 flasks with a red liquid in them.\n" + name + " quickly picks them up, and looks around the room." +
                        System.lineSeparator();
                        //"Your story starts here. Good luck." + System.lineSeparator();
        return story;
    }
    
    public boolean hasItem(String s)
    {
        for (Item i : inventory)
        {
            if (i.getName().equalsIgnoreCase(s))
            {
                return true;
            }
        }
        return false;
    }
    
    public Item getItem(String s)
    {
        for (Item i : inventory)
        {
            if (i.getName().equalsIgnoreCase(s))
            {
                return i;
            }
        }
        return null;
    }
    
    public void increaseMaxHp(int amount)
    {
        this.maxHp += amount;
    }
    
    public void decreaseMaxHp(int amount)
    {
        this.maxHp -= amount;
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
