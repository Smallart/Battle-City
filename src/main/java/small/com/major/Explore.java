package small.com.major;
import small.com.gui.GameFrame;

import java.awt.*;

/**
 * 爆炸类
 */
public class Explore {

    public static int WIDTH=ResourceMgr.exploreList[0].getWidth();
    public static int HEIGHT=ResourceMgr.exploreList[0].getHeight();
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
        g.drawImage(ResourceMgr.exploreList[step++],x,y,null);
        if (step>=ResourceMgr.exploreList.length){
            gameFrame.exploreList.remove(this);
        }
    }
}
