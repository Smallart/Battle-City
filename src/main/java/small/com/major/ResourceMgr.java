package small.com.major;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD,BulletL,BulletR,BulletU,BulletD;
    public static BufferedImage[] exploreList = new BufferedImage[16];
    static {
        try {
            tankL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/KL.png"));
            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/KR.png"));
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/KU.png"));
            tankD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/KD.png"));
            BulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/BL.png"));
            BulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/BR.png"));
            BulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/BU.png"));
            BulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/BD.png"));
            for (int i = 0; i < exploreList.length; i++) {
                exploreList[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/explore"+(i+1)+".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
