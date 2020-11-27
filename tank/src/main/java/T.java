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
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i*80,200,Dir.DOWN,Group.BAD,tf));
        }
        while (true){
            Thread.sleep(50);
            tf.repaint();

        }

    }
}
