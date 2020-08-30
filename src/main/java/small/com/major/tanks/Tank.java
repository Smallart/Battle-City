package small.com.major.tanks;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.gui.GameFrame;
import small.com.major.ResourceMgr;
import small.com.major.bullets.Bullet;

import java.awt.*;
import java.util.Random;

public class Tank {
    public static final int WIDTH=ResourceMgr.tankD.getWidth(),HEIGHT=ResourceMgr.tankD.getHeight();
    protected int positionX;
    protected int positionY;
    protected static int SPEED=10;
    protected Direction dir;
    protected GameFrame gameFrame;
    private Boolean moving=true;
    private Boolean living=true;
    private Group group;
    private Random random = new Random();
    public Rectangle rec = new Rectangle();

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Tank(int positionX, int positionY, Direction dir,GameFrame gameFrame,Group group) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.dir = dir;
        this.gameFrame=gameFrame;
        this.group=group;
        rec.x=positionX;
        rec.y=positionY;
        rec.height=HEIGHT;
        rec.width=WIDTH;
    }

    public void setMoving(Boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g){
        if (moving){
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
            rec.x=positionX;
            rec.y=positionY;
            boundsCheck();
        }
        if (living){
            switch(dir){
                case UP:
                    g.drawImage(ResourceMgr.tankU,positionX,positionY,null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.tankD,positionX,positionY,null);
                    break;
                case LEFT:
                    g.drawImage(ResourceMgr.tankL,positionX,positionY,null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.tankR,positionX,positionY,null);
                    break;
            }
        }
        if (this.getGroup()==Group.RED&& random.nextInt(100)>95){
            this.fire();
            randomDir();
        }
    }

    private void randomDir(){
       this.dir = Direction.values()[random.nextInt(4)];
    }

    public Group getGroup() {
        return group;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Boolean getLiving() {
        return living;
    }

    public void fire(){
        gameFrame.bulletList.add(new Bullet(positionX+(WIDTH/2-Bullet.WIDTH/2),positionY+(HEIGHT/2-Bullet.HEIGHT/2),dir,group,gameFrame));
    }

    public void die(){
        this.living=false;
    }

    private void boundsCheck(){
        if (this.positionX<0) positionX=0;
        if (this.positionY<30) positionY=30;
        if (this.positionY+HEIGHT>GameFrame.GAME_HEIGHT) positionY=GameFrame.GAME_HEIGHT-HEIGHT;
        if (this.positionX+WIDTH>GameFrame.GAME_WIDTH) positionX = GameFrame.GAME_WIDTH-WIDTH;
    }
}
