
package model;

public class Item
{
    private String name;
    private String description;
    private int goldValue;

    public Item(String name, String description, int goldValue) 
    {
        this.name = name;
        this.description = description;
        this.goldValue = goldValue;
        switch (name.toLowerCase())
        {
            case "gold coins":
                this.description = "lovely money!";
                break;
            case "potion":
                this.description = "a potion that heals you to full health!";
                break;
            case "weapon shard":
                this.description = "a magical shard, it will increase your weapon damage!";
                break;
            case "shroom":
                this.description = "dirty (you probably shouldn't eat this)";
                break;
            case "armor":
                this.description = "able to increase your max HP by 20";
                break;
        }
    }
    
    public String getName() 
    {
        return name;
    }
    
    public String getDescription() 
    {
        return description;
    }
    
    public int getGoldValue() 
    {
        return goldValue;
    }
    
    public String use(Player p)
    {
        switch (name.toLowerCase())
        {
            case "potion":
                p.healPlayer(p.getMaxHp());
                p.removeFromInventory(name);
                return "You used the " + name + " and your health has returned to max!" + System.lineSeparator();
            case "weapon shard":
                p.getBestWeapon().increaseDamage(10);
                p.removeFromInventory(name);
                return "You used the " + name + " and your " + p.getBestWeapon().getName() + "'s damage has increased by 10!" + System.lineSeparator();
            case "shroom":
                int shroomDmg = p.getCurrentHp() - 5;
                if (shroomDmg < 5)
                {
                    shroomDmg = 5;
                }
                p.damagePlayer(shroomDmg);
                p.removeFromInventory(name);
                return "You used the " + name + " and lose " + shroomDmg + " health! (What are you doing???)" + System.lineSeparator();
            case "armor":
                p.increaseMaxHp(20);
                p.healPlayer(20);
                p.removeFromInventory(name);
                return "You equipped the " + name + " and max health increased by 20!" + System.lineSeparator();
            default:
                return "You can't use this item!";
        }
    }
    

}
