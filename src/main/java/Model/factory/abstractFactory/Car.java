package Model.factory.abstractFactory;

public class Car extends Vehicle {
    @Override
    void run() {
        System.out.println("车在跑");
    }
}
