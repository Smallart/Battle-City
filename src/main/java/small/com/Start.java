package small.com;

import small.com.gui.GameFrame;

/**
 * Hello world!
 *
 */
public class Start
{
    public static void main( String[] args )
    {
        GameFrame gameFrame = new GameFrame();
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameFrame.repaint();
        }
    }
}
