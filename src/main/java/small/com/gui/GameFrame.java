package small.com.gui;

import small.com.common.Direction;
import small.com.major.bullets.FireStrategy.Impl.CommonFire;
import small.com.major.bullets.FireStrategy.Impl.FourDirFire;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {

    private GameModule gameModule = new GameModule();
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
        gameModule.paint(g);
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
//                    String fourDirFire =(String)PropertyMagrUtil.get("FourDirFire");
//                    try {
//                        myTank.fire((FourDirFire)Class.forName(fourDirFire).getDeclaredConstructor().newInstance());
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
                    //gameModule.getMainTank().fire(FourDirFire.getInstance());
                    gameModule.getMainTank().handleFireKey();
                    break;
                case KeyEvent.VK_CONTROL:
                    gameModule.getMainTank().fire(CommonFire.getInstance());
                    break;
            }
            SetDirection();
        }

        private void SetDirection(){
            if (KL) gameModule.getMainTank().setDir(Direction.LEFT);
            if (KR) gameModule.getMainTank().setDir(Direction.RIGHT);
            if (KU) gameModule.getMainTank().setDir(Direction.UP);
            if (KD) gameModule.getMainTank().setDir(Direction.DOWN);
            if (!KL&&!KR&&!KU&&!KD) {
                gameModule.getMainTank().setMoving(false);
            }else {
                gameModule.getMainTank().setMoving(true);
            }
        }
    }
}
