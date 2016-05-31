
package control;

import model.Player;
import view.MainWindow;


public class MainClass 
{
    public static void main(String[] args) 
    {
        new MainWindow(new RoomController(new Player()));
    }
}
