package small.com.major;
import small.com.gui.GameFrame;
import small.com.utils.ResourceMgrUtil;

import java.awt.*;

/**
 * 爆炸类
 */
public class Explore {

    public static int WIDTH= ResourceMgrUtil.exploreList[0].getWidth();
    public static int HEIGHT= ResourceMgrUtil.exploreList[0].getHeight();
    private int x,y;
    private GameFrame gameFrame;
    private int step = 0;

    public Explore(int x, int y, GameFrame gameFrame) {
        this.x = x;
        this.y = y;
        this.gameFrame = gameFrame;
        new Thread(()->new Audio("audio/blast.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgrUtil.exploreList[step++],x,y,null);
        if (step>= ResourceMgrUtil.exploreList.length){
            gameFrame.exploreList.remove(this);
        }
    }
}
