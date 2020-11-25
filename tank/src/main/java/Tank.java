import java.awt.*;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName Tank.java
 * @Description TODO
 * @createTime 2020年11月24日 09:15:00
 */
public class Tank {

    private int x;
    private int y;
    private Dir dir;
    private TankFrame tf;
    public static final int SPEED = 5;
    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
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
    }

    /**
     * 坦克发子弹，获取坦克的位置和方向
     */
    public void fire() {
        tf.bullets.add(new Bullet(x, y, dir, tf));
    }
}
