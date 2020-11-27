import java.awt.*;
import java.util.Random;

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
    public static final int WIDTH = ResourceMgr.tankU.getWidth();
    public static final int HEIGHT = ResourceMgr.tankU.getHeight();
    public static final int SPEED = 2;
    private boolean moving = true;
    private boolean living = true;
    private Random random = new Random();
    private Group group = Group.GOOD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
        }
        switch (dir) {
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;

            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }
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
        if (random.nextInt(10) > 8) {
            this.fire();
        }
    }

    /**
     * 坦克发子弹，获取坦克的位置和方向
     */
    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bx, by, dir, this.group, tf));
    }

    public void die() {
        this.living = false;
        tf.explodes.add(new Explode(this.x, this.y, tf));
    }
}
