package small.com.gui;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.major.Collider;
import small.com.major.ColliderChain;
import small.com.major.Explore;
import small.com.major.GameObject;
import small.com.major.bullets.Bullet;
import small.com.major.bullets.BulletTankCollider;
import small.com.major.tanks.Tank;
import small.com.utils.PropertyMagrUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModule {

    private Tank myTank = new Tank(200,200, Direction.UP,this, Group.BLUE);

    private ColliderChain colliderChain = new ColliderChain();

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameModule() {
        int initTankCount = Integer.parseInt((String) PropertyMagrUtil.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            this.gameObjects.add(new Tank((i+1)*80,200, Direction.DOWN,this, Group.RED));
        }
        add(myTank);
    }

    public void add(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject){
        this.gameObjects.remove(gameObject);
    }

    public void paint(Graphics g){
//        Color c =g.getColor();
//        g.setColor(Color.red);
//        g.drawString("子弹数量："+bulletList.size(),10,60);
//        g.drawString("敌方坦克数量："+enemyTanks.size(),10,80);
//        g.drawString("爆炸的数量："+exploreList.size(),10,100);
//        g.setColor(c);
//        myTank.paint(g);
//        //敌方坦克
//        for (int i = 0; i < enemyTanks.size(); i++) {
//            enemyTanks.get(i).paint(g);
//        }
//        // 绘画爆炸
//        for (int i = 0; i < exploreList.size(); i++) {
//            exploreList.get(i).paint(g);
//        }
//        //子弹
//        for (int i = 0; i < bulletList.size(); i++) {
//            bulletList.get(i).paint(g);
//        }
//        //碰撞检测
//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < enemyTanks.size(); j++) {
//                bulletList.get(i).collisionWith(enemyTanks.get(j));
//                if (!enemyTanks.get(j).getLiving()){
//                    enemyTanks.remove(j);
//                }
//            }
//            if (!bulletList.get(i).isLive()) bulletList.remove(i);
//        }

        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i+1; j < gameObjects.size(); j++) {
                colliderChain.collide(gameObjects.get(i),gameObjects.get(j));
            }
        }
    }

    public Tank getMainTank(){
        return myTank;
    }
}
