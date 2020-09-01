package small.com.major;

import small.com.gui.GameModule;
import small.com.major.Wall.BrickWallBulletCollider;
import small.com.major.Wall.BrickWallCollider;
import small.com.major.bullets.BulletTankCollider;
import small.com.major.tanks.TankCollider;
import small.com.utils.PropertyMagrUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * 责任链模式
 */
public class ColliderChain implements Collider{

    private List<Collider> colliderList=new LinkedList<>();

    public ColliderChain(){
        try {
            add((BulletTankCollider)Class.forName((String) PropertyMagrUtil.get("BulletTankCollider")).getDeclaredConstructor().newInstance());
            add((TankCollider)Class.forName((String) PropertyMagrUtil.get("TankCollider")).getDeclaredConstructor().newInstance());
            add((BrickWallBulletCollider)Class.forName((String) PropertyMagrUtil.get("BrickWallBulletCollider")).getDeclaredConstructor().newInstance());
            add((BrickWallCollider)Class.forName((String) PropertyMagrUtil.get("BrickWallCollider")).getDeclaredConstructor().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
