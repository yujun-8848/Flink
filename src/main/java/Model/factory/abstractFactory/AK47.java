package Model.factory.abstractFactory;

public class AK47 extends Weapon {
    @Override
    void shoot() {
        System.out.println("在射击");
    }
}
