
package model;

import control.RoomController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class SaveLoadHandler 
{
    public static void save(RoomController rc, String playerName)
    {
        playerName = playerName.toLowerCase();
        save(rc, new File("saves/" + playerName + ".txt"));
    }
    
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
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
