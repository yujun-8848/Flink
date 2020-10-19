package Model.factory.abstractFactory;

/**
 * 抽象工厂模式:与工厂方法模式不同的是，工厂方法模式中的工厂只生产单一的产品
 * 而抽象工厂模式中的工厂生产多个产品
 */

/**
 * 抽象工厂类
 */
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();

    public abstract Weapon createWeapon();

    public abstract Food createFood();
}
