package Model.factory.abstractFactory;

public class Test {

    public static void main(String[] args) {
        AbstractFactory factory = new DefaultFactory();
        Food food = factory.createFood();
        food.eat();
        Vehicle vehicle = factory.createVehicle();
        vehicle.run();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();

    }
}
