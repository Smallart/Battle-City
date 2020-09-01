package small.com.major.bullets;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.gui.GameModule;
import small.com.major.Explore;
import small.com.major.GameObject;
import small.com.major.tanks.Tank;
import small.com.utils.ResourceMgrUtil;

import java.awt.*;

public class Bullet extends GameObject {
    public static final int WIDTH= ResourceMgrUtil.BulletD.getWidth(),HEIGHT= ResourceMgrUtil.BulletD.getHeight(),SPEED=5;
    private Direction dir;
    private boolean live=true;
    private Group group;
    public GameModule gameModule;

    public Bullet(int positionX, int positionY, Direction dir,Group group,GameModule gameModule) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.dir = dir;
        this.group=group;
        this.gameModule=gameModule;
        rectangle.x=positionX;
        rectangle.y= positionY;
        rectangle.width =WIDTH;
        rectangle.height=WIDTH;
        //new出来后就放入集合中
        gameModule.add(this);
    }

    public boolean isLive() {
        return live;
    }

    public void paint(Graphics g){
        if (!live) return;
        switch(dir){
            case UP:
                g.drawImage(ResourceMgrUtil.BulletU,positionX,positionY,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgrUtil.BulletD,positionX,positionY,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgrUtil.BulletL,positionX,positionY,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgrUtil.BulletR,positionX,positionY,null);
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
        rectangle.x=positionX;
        rectangle.y=positionY;
        if (positionX<0||positionY<0||positionX>800||positionY>600) gameModule.remove(this); ;
    }

    public void collisionWith(Tank tank){
        if (tank.getGroup()==this.group) return;
        if (rectangle.intersects(tank.getRectangle())){
            tank.die();
            this.die();
            gameModule.add(new Explore(tank.getPositionX()+Tank.WIDTH/3-Explore.WIDTH/2,tank.getPositionY()+Tank.HEIGHT/3-Explore.HEIGHT/2,gameModule));
            gameModule.remove(this);
            gameModule.remove(tank);
        }
    }

    public void die(){
        this.live=false;
    }

}
