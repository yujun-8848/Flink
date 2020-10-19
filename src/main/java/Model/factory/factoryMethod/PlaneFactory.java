package Model.factory.factoryMethod;

/**
 * 具体工厂
 */
public class PlaneFactory  extends VehicleFactory{

    @Override
    Moveable create() {
        return new Plane();
    }

}
