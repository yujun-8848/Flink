import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName ImageRotateTest.java
 * @Description TODO
 * @createTime 2020年11月26日 15:26:00
 */
public class ImageRotateTest {

    @Test
    public void iamgeTest(){

        try {
            BufferedImage image = ImageIO.read(ImageRotateTest.class.getClassLoader().getResourceAsStream("images/1.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
