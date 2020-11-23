import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName T.java
 * @Description TODO
 * @createTime 2020年11月23日 16:30:00
 */
public class T {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        while (true){
            Thread.sleep(50);
            tf.repaint();

        }

    }
}
