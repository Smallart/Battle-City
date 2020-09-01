package small.com.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgrUtil {
    private ResourceMgrUtil(){}
    public static BufferedImage tankL,tankR,tankU,tankD,BulletL,BulletR,BulletU,BulletD;
    public static BufferedImage[] exploreList = new BufferedImage[16];
    public static BufferedImage brickWall;
    static {
        try {
            tankL= ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/KL.png"));
            tankR= ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/KR.png"));
            tankU= ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/KU.png"));
            tankD= ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/KD.png"));
            BulletL=ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/BL.png"));
            BulletR=ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/BR.png"));
            BulletU=ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/BU.png"));
            BulletD=ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/BD.png"));
            for (int i = 0; i < exploreList.length; i++) {
                exploreList[i]=ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/explore"+(i+1)+".png"));
            }
            brickWall=ImageIO.read(ResourceMgrUtil.class.getClassLoader().getResourceAsStream("img/BrickWall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
