package Model.factory.factoryMethod;


public class BroomFactory extends VehicleFactory{
    @Override
    Moveable create() {
        return new Broom();
    }
}
