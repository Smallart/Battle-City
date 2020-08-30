package small.com;

import org.junit.Assert;
import org.junit.Test;
import small.com.major.ResourceMgr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        BufferedImage[] exploreList = new BufferedImage[5];
        for (int i = 0; i < exploreList.length; i++) {
            exploreList[i]=ImageIO.read(AppTest.class.getClassLoader().getResourceAsStream("img/explore"+(i+1)+".png"));
        }
        Assert.assertNotNull(exploreList);
    }
}
