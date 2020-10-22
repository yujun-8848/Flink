package Model.visitor;

/**
 * 访问者模式：表示一个作用某对象结构中的各元素的操作，它使你可以在不改变各元素的类的前提下，
 * 定义作用于这些元素的新操作
 */
//单分派和双重分派
public class Food {
    public String name(){
        return "food";
    }
}
