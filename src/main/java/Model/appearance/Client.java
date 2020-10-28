package Model.appearance;


import org.junit.Test;

/**
 * 外观模式就是这么简单，它使得两种不同的类不用直接交互，而是通过一个中间件
 * 也就是外观类--间接交互。外观类中只需要暴露简洁的接口，隐藏内部的细节，即封装
 */
public class Client {

    @Test
    public void test() {
        Facade facade = new Facade();
        facade.open();
        System.out.println("===========");
        facade.close();
    }
}
