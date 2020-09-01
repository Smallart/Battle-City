package small.com.major.Wall;

import small.com.gui.GameModule;
import small.com.major.GameObject;
import small.com.utils.ResourceMgrUtil;

import java.awt.*;

public class BrickWall extends GameObject {

    private boolean living=false;
    public static int HEIGHT = ResourceMgrUtil.brickWall.getHeight();
    public static int WIDTH= ResourceMgrUtil.brickWall.getWidth();
    public GameModule gameModule;

    public BrickWall(int positionX,int positionY,GameModule gameModule) {
        this.positionX=positionX;
        this.positionY=positionY;
        rectangle.x=positionX;
        rectangle.y=positionY;
        rectangle.height=HEIGHT;
        rectangle.width=WIDTH;
        this.gameModule = gameModule;
        living=true;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgrUtil.brickWall,positionX,positionY,null);
    }

    public void die(){
        this.living=false;
    }
}
