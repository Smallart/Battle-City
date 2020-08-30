package small.com.major.bullets.FireStrategy.Impl;

import small.com.major.bullets.Bullet;
import small.com.major.bullets.FireStrategy.FireStrategyInter;
import small.com.major.tanks.Tank;

public class CommonFire implements FireStrategyInter {
    private CommonFire(){}

    private static CommonFire commonFire = new CommonFire();

    @Override
    public void fireBullet(Tank tank) {
        new Bullet(tank.getPositionX()+(Tank.WIDTH/2-Bullet.WIDTH/2),tank.getPositionY()+(Tank.HEIGHT/2-Bullet.HEIGHT/2),tank.getDir(),tank.getGroup(),tank.getGameFrame());
    }

    public static CommonFire getInstance(){
        return commonFire;
    }
}
