
package model;


public class RoomObject 
{
    private String name;
    private String description;
    
    public RoomObject(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    public String interact(Player p)
    {
        switch(name.toLowerCase())
        {
            case "endgame chest":
                p.doEndSequence();
                return "You win the game! Congratulations! PLAYER STAT WIP KOMMER HER";
            case "lamp":
                return "You feel the mighty power of the magic lamp! You receive a buff of greater strength!";
            default:
                return "There is no object to interact with";
                    
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
