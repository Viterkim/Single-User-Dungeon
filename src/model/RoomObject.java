
package model;


public abstract class RoomObject 
{
    private String name;
    private String description;
    
    public RoomObject(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    public abstract void interact();

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
