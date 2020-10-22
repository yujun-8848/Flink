package Model.visitor;

import org.junit.Test;

/**
 * 在面向对象的编程语言中，我们将方法调用称之为分派，这段测试代码运行时，
 * 经过了两次分派：
 * 调用重载方法：选择调用eat(Food food)还是eat(Watermelon watermelon)。虽然这里传入的
 * 这个参数实际类型是watermelon，但这里会调用eat(Food food)，这是由于调用哪个重载方法在
 * 编译期就确定了的，也称为静态分派。
 * 调用重写方法：选择调用Food的name方法还是watermelon的name方法。这里会根据参数运行时的
 * 实际类型，调用watermelon的name方法，称之为动态分派。
 *
 * 单分派、双分派的定义如下：
 * 方法的接受者和方法的参数统称为方法的宗量。根据分派基于多少个宗量，可以将分派分为单分派和多
 * 分派。单分派是指根据一个宗量就可以知道应该调用哪个方法，多分派是指需要根据多个宗量才能确定调用目标
 *
 * 单分派和双重分派的区别是：程序在选择重载方法和重写方法时，如果两种情况动态分派的，则称之为
 * 双重分派；如果其中一种情况是动态分派，另一种是静态分派，则称之为单分派。
 */
public class Client {

    @Test
    public void test(){
        Food food = new Watermelon();
        eat(food);
    }
    @Test
    public void test2(){
        Restaurant restaurant = new Restaurant();
        Aurora aurora = new Aurora();
        restaurant.welcome(aurora);
    }

    public void eat(Food food){
        System.out.println("eat food: " +food.name());
    }

    public void eat(Watermelon watermelon){
        System.out.println("eat watermelon" + watermelon.name());
    }
}
