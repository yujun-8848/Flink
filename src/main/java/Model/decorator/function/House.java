package Model.decorator.function;

public class House implements IHouse {
    @Override
    public void live() {
        System.out.println("房屋原有的功能：居住功能");
    }
}
