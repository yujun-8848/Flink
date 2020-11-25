import java.awt.*;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName Bullet.java
 * @Description TODO
 * @createTime 2020年11月24日 10:01:00
 */
public class Bullet {
    private static final int SPEED = 10;
    public static final int WIDTH = 5, HEIGHT = 5;
    private int x, y;
    private Dir dir;
    private TankFrame tf;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

}
