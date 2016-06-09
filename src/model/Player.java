
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * The player class holds all important information for the player, such as stats, inventory, gold, etc.
 */
public final class Player implements Serializable
{
    private String name;
    private int level, currentHp, maxHp, gold, currentEnergy, maxEnergy;
    private final ArrayList<Item> inventory;
    
    public Player()
    {
        setNewName();
        this.maxEnergy = 10;
        this.currentEnergy = maxEnergy;
        this.level = 1;
        this.maxHp = 30;
        this.currentHp = maxHp;
        this.gold = 20;
        inventory = new ArrayList<>();
        if (name.equalsIgnoreCase("pelo"))
        {
            this.gold = 9001;
            this.maxHp = 9001;
            this.currentHp = 9001;
            this.maxEnergy = 9001;
            this.currentEnergy = 9001;
            JOptionPane.showMessageDialog(null, "Activated god mode. Welcome Pelo. (Please enter a normal name if you wish to play a normal game)");
        }
        initInventory();
    }
    
    /**
     * Initializes the inventory of the player to start with 2 potions, and their bare fists as a starting weapon.
     */
    private void initInventory() 
    {
        inventory.clear();
        inventory.add(new Weapon("Fists", "your own fists", -1, 5));
        inventory.add(new Item("Potion", "", 20));
        inventory.add(new Item("Potion", "", 20));
    }
     
    /**
     * Levels up the player, giving him increased stats
     */
    public void levelUp()
    {
        this.level++;
        this.maxHp += 10;
        this.currentHp = maxHp;
    }
    
    /**
     * Calls the end sequence, informing the player of their ending score
     */
    public void doEndSequence()
    {
        int totalPoints = 0;
        if (inventory != null)
        {
            for (Item i : inventory) 
            {
                if (i != null && i.getGoldValue() > 0)
                {
                    totalPoints += i.getGoldValue();
                }
            }
        }
        totalPoints += gold;
        
        String endMessage = "As you open the chest using the master key, you see a ladder extend from the bottom of the chests base.\n" +
        "It goes through the ceiling and far beyond what you can see.\n" +
        "You ponder the opportunity a moment, but swiftly decide...\n" +
        "\n" +
        "As you are approaching the top of the ladder, light fills your eyes.\n" +
        "You are blinded, but continue climbing.\n" +
        "\n" +
        "You reach the top, step out onto the field where you fell into the hole to begin with.\n" +
        "You look around, but no hole is to be seen?\n" +
        "\n" +
        "Has this whole thing been a dream? A fantasy because of your craving for adventure?\n" +
        "You're not sure, how would you prove to yourself this actually happened?\n" +
        "\n" +
        "You slowly move your hand into your pocket.\n" +
        "Out of it, you pull " + totalPoints + " gold coins...";
        JOptionPane.showMessageDialog(null, endMessage);
        System.exit(0);
    }
    
    /**
     * Used to set the players name
     */
    public void setNewName()
    {
        String tempName = JOptionPane.showInputDialog(null, "What is your name?");
        if (tempName == null || tempName.equals(""))
        {
            tempName = "Bingotrolden";
        }
        this.name = tempName;
    }
    
    /**
     * 
     * @return The intro story, introducing the player to the dungeon.
     */
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
    
    /**
     * Checks if the player has a certain item with the specified name in their inventory.
     * @param s The name of the item
     * @return True: If player has the item in inventory, else false
     */
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
    
    /**
     * Gets an item by the specified string
     * @param s The name of the item
     * @return The item by name s, or null, if no item is found.
     */
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

    /**
     * Removes the first instance of an item with the same name as the parsed name in the parameter
     * @param name The name of the item.
     */
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
    
    /**
     * Checks all available weapons, and will return the one with the highest damage
     * @return The weapon with the most damage, null if no weapon is found.
     */
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

    public int getCurrentEnergy() 
    {
        return currentEnergy;
    }
    
    public void increaseCurrentEnergy(int x)
    {
        this.currentEnergy += x;
        if (currentEnergy >= maxEnergy)
        {
            this.currentEnergy = maxEnergy;
        }
    }
    
    public void decreaseCurrentEnergy(int x)
    {
        this.currentEnergy -= x;
        if (currentEnergy <= 0)
        {
            this.currentEnergy = 0;
        }
    }

    public int getMaxEnergy() 
    {
        return maxEnergy;
    }
    
}
