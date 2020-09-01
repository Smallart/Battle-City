package small.com.major.Wall;

import small.com.major.Collider;
import small.com.major.GameObject;
import small.com.major.tanks.Tank;

public class BrickWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BrickWall&&o2 instanceof Tank){
            if (o1.getRectangle().intersects(o2.getRectangle())){
                o2.setPositionX(o2.getPositionX());
                o2.setPositionY(o2.getPositionX());
            }
            return false;
        }else if(o1 instanceof Tank&&o2 instanceof BrickWall){
            collide(o2,o1);
            return false;
        }
        return true;
    }
}
