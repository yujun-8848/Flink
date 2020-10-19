package Model.bridging;

/**
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 抽象部分指的是父类，对应本例中的形状类，实现部分指的是不同子类的区别之处。
 * 将子类的区别方式--也就是本例中的颜色--分离成接口，通过组合的方式桥接颜色和形状，
 * 这就是桥接模式，它主要用于两个或多个同等级的接口。
 */
public class Test {
    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        triangle.setColor(new Red());
        triangle.draw();
    }
}
