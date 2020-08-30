package small.com.major.bullets.FireStrategy.Impl;

import small.com.common.Direction;
import small.com.major.bullets.Bullet;
import small.com.major.bullets.FireStrategy.FireStrategyInter;
import small.com.major.tanks.Tank;

public class FourDirFire implements FireStrategyInter {
    //private FourDirFire(){}
    private static FourDirFire fourDirFire = new FourDirFire();
    @Override
    public void fireBullet(Tank tank) {
        Direction[] values = Direction.values();
        for (Direction value : values) {
            new Bullet(tank.getPositionX()+(Tank.WIDTH/2-Bullet.WIDTH/2),tank.getPositionY()+(Tank.HEIGHT/2-Bullet.HEIGHT/2),value,tank.getGroup(),tank.getGameFrame());
        }
    }

    public static FourDirFire getInstance(){
        return fourDirFire;
    }
}
