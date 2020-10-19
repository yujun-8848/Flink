package Model.decorator.function;

public class Test {
    public static void main(String[] args) {
        House house = new House();
        house.live();
        IStickyHookHouse stickyHookHouse = new StickyHookDecorator(house);
        stickyHookHouse.hangThings();
        stickyHookHouse.live();
    }
}
