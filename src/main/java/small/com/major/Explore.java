package small.com.major;
import small.com.gui.GameFrame;
import small.com.gui.GameModule;
import small.com.utils.ResourceMgrUtil;

import java.awt.*;

/**
 * 爆炸类
 */
public class Explore extends GameObject{

    public static int WIDTH= ResourceMgrUtil.exploreList[0].getWidth();
    public static int HEIGHT= ResourceMgrUtil.exploreList[0].getHeight();
    private GameModule gameModule;
    private int step = 0;

    public Explore(int x, int y, GameModule gameModule) {
        this.positionX = x;
        this.positionY = y;
        this.gameModule = gameModule;
        new Thread(()->new Audio("audio/blast.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgrUtil.exploreList[step++],positionX,positionY,null);
        if (step>= ResourceMgrUtil.exploreList.length){
            gameModule.remove(this);
        }
    }
}
