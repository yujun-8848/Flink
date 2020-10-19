package Model.factory.factoryMethod;

/**
 * 工厂方法模式：有四个角色，抽象工厂模式，具体工厂模式，抽象产品模式，
 * 具体产品模式。不再是一个工厂类去实例化具体的产品，而是由抽象工厂的子类去实例化产品
 */

/**
 * 抽象产品角色
 */
public interface Moveable {
    void run();
}
