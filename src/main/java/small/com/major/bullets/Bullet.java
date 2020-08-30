package small.com.major.bullets;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.gui.GameFrame;
import small.com.major.Explore;
import small.com.major.ResourceMgr;
import small.com.major.tanks.Tank;

import java.awt.*;

public class Bullet {
    public static final int WIDTH=ResourceMgr.BulletD.getWidth(),HEIGHT=ResourceMgr.BulletD.getHeight(),SPEED=5;
    private int positionX;
    private int positionY;
    private Direction dir;
    private boolean live=true;
    private Group group;
    private GameFrame gameFrame;
    private Rectangle rect = new Rectangle();

    public Bullet(int positionX, int positionY, Direction dir,Group group,GameFrame gameFrame) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.dir = dir;
        this.group=group;
        this.gameFrame=gameFrame;
        rect.x=positionX;
        rect.y= positionY;
        rect.width =WIDTH;
        rect.height=WIDTH;
    }

    public boolean isLive() {
        return live;
    }

    public void paint(Graphics g){
        if (!live) return;
        switch(dir){
            case UP:
                g.drawImage(ResourceMgr.BulletU,positionX,positionY,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BulletD,positionX,positionY,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.BulletL,positionX,positionY,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BulletR,positionX,positionY,null);
                break;
        }
        move();
    }

    private void move(){
        switch (dir){
            case UP:
                positionY-=SPEED;
                break;
            case DOWN:
                positionY+=SPEED;
                break;
            case LEFT:
                positionX-=SPEED;
                break;
            case RIGHT:
                positionX+=SPEED;
                break;
        }
        rect.x=positionX;
        rect.y=positionY;
        if (positionX<0||positionY<0||positionX>800||positionY>600) live=false;
    }

    public void collisionWith(Tank tank){
        if (tank.getGroup()==this.group) return;
        if (rect.intersects(tank.rec)){
            tank.die();
            this.die();
            gameFrame.exploreList.add(new Explore(tank.getPositionX()+Tank.WIDTH/3-Explore.WIDTH/2,tank.getPositionY()+Tank.HEIGHT/3-Explore.HEIGHT/2,gameFrame));
        }
    }

    public void die(){
        this.live=false;
    }

}
