package small.com.major.bullets;

import small.com.major.Collider;
import small.com.major.GameObject;
import small.com.major.tanks.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            b.collisionWith(t);
            return false;
        }if (o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2,o1);
            return false;
        }
        return true;
    }
}
