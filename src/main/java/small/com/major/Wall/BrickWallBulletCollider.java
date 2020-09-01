package small.com.major.Wall;

import small.com.major.Collider;
import small.com.major.GameObject;
import small.com.major.bullets.Bullet;

public class BrickWallBulletCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof BrickWall){
            if (o1.getRectangle().intersects(o2.getRectangle())){
                Bullet bullet = (Bullet) o1;
                BrickWall brickWall = (BrickWall) o2;
                brickWall.die();
                bullet.die();
                brickWall.gameModule.remove(brickWall);
                bullet.gameModule.remove(bullet);
            }
            return false;
        }else if(o1 instanceof BrickWall && o2 instanceof Bullet){
            collide(o2,o1);
            return false;
        }
        return true;
    }
}
