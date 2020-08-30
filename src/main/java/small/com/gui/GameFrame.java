package small.com.gui;

import small.com.common.Direction;
import small.com.common.Group;
import small.com.major.Explore;
import small.com.major.bullets.Bullet;
import small.com.major.bullets.FireStrategy.Impl.CommonFire;
import small.com.major.bullets.FireStrategy.Impl.FourDirFire;
import small.com.major.tanks.Tank;
import small.com.utils.PropertyMagrUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameFrame extends Frame {
    private Tank myTank = new Tank(200,200,Direction.UP,this, Group.BLUE);
    public List<Tank> enemyTanks=new ArrayList<>();
    public List<Bullet> bulletList=new ArrayList<>();
    public List<Explore> exploreList = new ArrayList<>();
    Image offScreenImage=null;
    public static int GAME_WIDTH=800,GAME_HEIGHT=600;

    public GameFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);;
            }
        });
    }
    //重新绘制时，会将原来的东西清除之后，调用paint方法再绘制
    @Override
    public void paint(Graphics g) {
        Color c =g.getColor();
        g.setColor(Color.red);
        g.drawString("子弹数量："+bulletList.size(),10,60);
        g.drawString("敌方坦克数量："+enemyTanks.size(),10,80);
        g.drawString("爆炸的数量："+exploreList.size(),10,100);
        g.setColor(c);
        myTank.paint(g);
        //敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTanks.get(i).paint(g);
        }
        // 绘画爆炸
        for (int i = 0; i < exploreList.size(); i++) {
            exploreList.get(i).paint(g);
        }
        //子弹
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        //碰撞检测
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < enemyTanks.size(); j++) {
                bulletList.get(i).collisionWith(enemyTanks.get(j));
                if (!enemyTanks.get(j).getLiving()){
                    enemyTanks.remove(j);
                }
            }
            if (!bulletList.get(i).isLive()) bulletList.remove(i);
        }
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage==null){
            offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage,0,0,null);
    }

    //键盘监听事件
    class MyKeyListener extends KeyAdapter{
        private boolean KL;
        private boolean KR;
        private boolean KU;
        private boolean KD;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    KL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    KR=true;
                    break;
                case KeyEvent.VK_UP:
                    KU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    KD=true;
                    break;
            }
            SetDirection();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    KL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    KR=false;
                    break;
                case KeyEvent.VK_UP:
                    KU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    KD=false;
                    break;
                case KeyEvent.VK_C:
                    String fourDirFire =(String)PropertyMagrUtil.get("FourDirFire");
                    try {
                        myTank.fire((FourDirFire)Class.forName(fourDirFire).getDeclaredConstructor().newInstance());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire(CommonFire.getInstance());
                    break;
            }
            SetDirection();
        }

        private void SetDirection(){
            if (KL) myTank.setDir(Direction.LEFT);
            if (KR) myTank.setDir(Direction.RIGHT);
            if (KU) myTank.setDir(Direction.UP);
            if (KD) myTank.setDir(Direction.DOWN);
            if (!KL&&!KR&&!KU&&!KD) {
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
            }
        }
    }
}
