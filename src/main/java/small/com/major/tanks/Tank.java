package small.com.major.tanks;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.gui.GameFrame;
import small.com.gui.GameModule;
import small.com.major.GameObject;
import small.com.major.bullets.FireStrategy.FireStrategyInter;
import small.com.major.bullets.FireStrategy.Impl.CommonFire;
import small.com.utils.ResourceMgrUtil;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    public static final int WIDTH= ResourceMgrUtil.tankD.getWidth(),HEIGHT= ResourceMgrUtil.tankD.getHeight();
    protected static int SPEED=10;
    protected Direction dir;
    protected GameModule gameModule;
    //记录上一步坦克的X位置
    private int prePositionX;
    //记录上一步坦克的Y位置
    private int prePositionY;
    private Boolean moving=true;
    private Boolean living=true;
    private Group group;
    private Random random = new Random();
    public Rectangle rec = new Rectangle();

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Tank(int positionX, int positionY, Direction dir,GameModule gameModule,Group group) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.dir = dir;
        this.gameModule=gameModule;
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
        prePositionX=positionX;
        prePositionY=positionY;
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
                    g.drawImage(ResourceMgrUtil.tankU,positionX,positionY,null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgrUtil.tankD,positionX,positionY,null);
                    break;
                case LEFT:
                    g.drawImage(ResourceMgrUtil.tankL,positionX,positionY,null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgrUtil.tankR,positionX,positionY,null);
                    break;
            }
        }
        if (this.getGroup()==Group.RED&& random.nextInt(100)>95){
            this.fire(CommonFire.getInstance());
            randomDir();
        }
    }

    private void randomDir(){
       this.dir = Direction.values()[random.nextInt(4)];
    }

    public Group getGroup() {
        return group;
    }

    public Direction getDir() {
        return dir;
    }

    public GameModule getGameFrame() {
        return gameModule;
    }

    public int getPrePositionX() {
        return prePositionX;
    }

    public void setPrePositionX(int prePositionX) {
        this.prePositionX = prePositionX;
    }

    public int getPrePositionY() {
        return prePositionY;
    }

    public void setPrePositionY(int prePositionY) {
        this.prePositionY = prePositionY;
    }

    public Boolean getLiving() {
        return living;
    }

    public void fire(FireStrategyInter fireStrategy){
        fireStrategy.fireBullet(this);
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
