package Model.decorator;

/**
 * 装饰者设计模式
 * 对已有的业务逻辑进一步包装，使其增加额外的功能，例如java中的IO流就是使用的装饰者模式
 * 这里已食物为例
 */
public class Food {

    private String food_name;

    public Food(String food_name){
        this.food_name = food_name;
    }

    public Food() {

    }

    public String make(){
        return food_name;
    }
}
