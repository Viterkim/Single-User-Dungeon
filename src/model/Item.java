
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
                return "Used " + name + " your healt has returned to max!" + System.lineSeparator();
            case "weapon shard":
                p.getBestWeapon().increaseDamage(10);
                return "Used " + name + " your current sword's damage has increased by 10!" + System.lineSeparator();
            case "shroom":
                p.damagePlayer(20);
                return "Used " + name + "you lose 20 health! (What are you doing???)" + System.lineSeparator();
            default:
                return "You can't use this item!";
        }
    }
    

}
