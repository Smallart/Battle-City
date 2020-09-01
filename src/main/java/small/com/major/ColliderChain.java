package small.com.major;

import small.com.gui.GameModule;
import small.com.major.bullets.BulletTankCollider;
import small.com.major.tanks.TankCollider;

import java.util.LinkedList;
import java.util.List;

/**
 * 责任链模式
 */
public class ColliderChain implements Collider{
    private List<Collider> colliderList=new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankCollider());
    }

    public void add(Collider collider){
        colliderList.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliderList.size(); i++) {
            if(!colliderList.get(i).collide(o1,o2)) return false;
        }
        return true;
    }
}
