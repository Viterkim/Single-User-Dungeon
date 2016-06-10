
package model;

import control.RoomController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * A class to save or load the RoomController from/to serializable data
 */
public class SaveLoadHandler 
{
    
    /**
     * Saves the RoomController to serializable data
     * @param rc The RoomController
     * @param playerName The player name
     */
    public static void save(RoomController rc, String playerName)
    {
        playerName = playerName.toLowerCase();
        save(rc, new File("saves/" + playerName + ".txt"));
    }
    
    /**
     * Saves the RoomController to serializable data
     * @param rc The RoomController
     * @param playerName The player name
     */
    private static void save(RoomController rc, File f)
    {
        try
        {
            File savePath = new File("saves/");
            if (!savePath.exists())
            {
                savePath.mkdir();
            }
            if (!f.exists())
            {
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            new ObjectOutputStream(fos).writeObject(rc);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Loads the RoomController from the specified player's name
     * @param playerName The player name
     * @return The loaded RoomController
     */
    public static RoomController load(String playerName)
    {
        playerName = playerName.toLowerCase();
        try
        {
            File f = new File("saves/" + playerName + ".txt");
            if (!f.exists())
            {
                return null;
            }
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            RoomController newRc = (RoomController) o;
            return newRc;
        }
        catch(IOException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
