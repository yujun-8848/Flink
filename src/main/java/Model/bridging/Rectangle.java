package Model.bridging;

/**
 * 定义每个形状，使用组合的方式，将颜色嵌入其中
 */
public class Rectangle implements IShape {

    private IColor color;

    public void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "矩形");
    }
}
