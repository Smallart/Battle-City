package small.com.major.tanks;

import small.com.major.Collider;
import small.com.major.GameObject;

public class TankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank&&o2 instanceof Tank){
            Tank tank1=(Tank) o1;
            Tank tank2=(Tank) o2;
            if (tank1.rec.intersects(tank2.rec)){
                tank1.setPositionX(tank1.getPrePositionX());
                tank1.setPositionY(tank1.getPrePositionY());
                tank2.setPositionX(tank2.getPrePositionX());
                tank2.setPositionY(tank2.getPrePositionY());
            }
            return false;
        }
        return true;
    }
}
