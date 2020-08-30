package small.com;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.gui.GameFrame;
import small.com.major.Audio;
import small.com.major.tanks.Tank;
import small.com.utils.PropertyMagrUtil;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Start
{
    public static void main( String[] args )
    {
        GameFrame gameFrame = new GameFrame();
        int initTankCount = Integer.parseInt((String) PropertyMagrUtil.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            gameFrame.enemyTanks.add(new Tank((i+1)*80,200, Direction.DOWN,gameFrame, Group.RED));
        }
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
