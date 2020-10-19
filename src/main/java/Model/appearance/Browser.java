package Model.appearance;

/**
 * 外观模式：外部与一个子系统的通信必须通过一个统一的外观对象进行，为了系统中的一组接口提供一个一致的界面，
 * 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 *
 * 例如，每天打开电脑，都需要做三件事：
 * 打开浏览器
 * 打开IDEA
 * 打开微信
 *
 * 每天下班，关机前需要做三件事：
 * 关闭浏览器
 * 关闭IDEA
 * 关闭微信
 */
public class Browser {

    public static void open(){
        System.out.println("打开浏览器");
    }

    public static void close(){
        System.out.println("关闭浏览器");
    }
}
