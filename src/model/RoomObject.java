
package model;

import control.RoomController;
import java.io.Serializable;
import java.util.Random;


public class RoomObject implements Serializable
{
    private String name;
    private String description;
    private final Random r;
    
    public RoomObject(String name, String description)
    {
        r = new Random();
        this.name = name;
        this.description = description;
    }
    
    /**
     * This will try to interact with an object in the room, if the object is present.
     * @param rc The RoomController, so it can access some of the buffs/current room
     * @return Returns the action (if it failed, then an error on why it failed, else what happened based on that action)
     */
    public String interact(RoomController rc)
    {
        Player p = rc.getPlayer();
        switch(name.toLowerCase())
        {
            case "endgame chest":
                if (p.hasItem("master key"))
                {
                    p.doEndSequence();
                    return "You win the game! Congratulations! PLAYER STAT WIP KOMMER HER";
                }
                return "You try to open the chest, but unfortunately it's locked! (Maybe you should go look for a key?)";
            case "red lamp":
                int buff = RoomController.BUFF_DAMAGE;
                int turns = r.nextInt(10) + 7;
                rc.addBuffTurns(buff, turns);
                rc.getCurrentRoom().removeObject(name);
                return "You feel the mighty power of the magic lamp! You receive a buff of greater strength for " + turns + " turns!";
            case "green lamp":
                buff = RoomController.BUFF_HP;
                turns = r.nextInt(10) + 7;
                rc.addBuffTurns(buff, turns);
                p.increaseMaxHp(10);
                p.healPlayer(10);
                rc.getCurrentRoom().removeObject(name);
                return "You feel the mighty power of the magic lamp! You receive a buff of greater health for " + turns + " turns!";
            case "blue lamp":
                buff = RoomController.BUFF_RESISTANCE;
                turns = r.nextInt(10) + 7;
                rc.addBuffTurns(buff, turns);
                rc.getCurrentRoom().removeObject(name);
                return "You feel the mighty power of the magic lamp! You receive a buff of greater resistance for " + turns + " turns!";
            case "giant chest":
                Item i = ItemGenerator.GenerateRandomItem();
                // Removes clutter text from specific items which already have a set description
                String iText = (i.getDescription().length() < 10 ? i.getDescription() + " " + i.getName() : i.getName());
                Item i2 = ItemGenerator.GenerateRandomItem();
                String i2Text = (i2.getDescription().length() < 10 ? i2.getDescription() + " " + i2.getName() : i2.getName());
                p.addItem(i);
                p.addItem(i2);
                rc.getCurrentRoom().removeObject(name);
                return "You carefully open the chest and peek inside. You pick up " + iText + " and a " + i2Text;
            case "normal chest":
                i = ItemGenerator.GenerateRandomItem();
                // Removes clutter text from specific items which already have a set description
                iText = (i.getDescription().length() < 10 ? i.getDescription() + " " + i.getName() : i.getName());
                p.addItem(i);
                rc.getCurrentRoom().removeObject(name);
                return "You carefully open the chest and peek inside. pick up " + iText;
            default:
                return "Unemplemented interaction with the object: " + name;
                    
        }
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
    
    
    
    
}
