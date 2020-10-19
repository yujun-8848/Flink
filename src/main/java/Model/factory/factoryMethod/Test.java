package Model.factory.factoryMethod;

public class Test {

    public static void main(String[] args) {
        VehicleFactory factory = new BroomFactory();
        Moveable moveable = factory.create();
        moveable.run();
    }
}
