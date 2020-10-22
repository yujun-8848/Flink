package Model.visitor;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    //准备当天的食物
    public List<Food2> prepareFoods(){
        List<Food2> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Lobster());
            foods.add(new Steak());
            foods.add(new Banana());
        }
        return foods;
    }

    //欢迎顾客来访
    public void welcome(IVisitor iVisitor){

        List<Food2> foods = prepareFoods();
        for (Food2 food : foods) {
            //由于重写方法时动态分派的，所以这里会调用具体子类的accept方法
            food.accept(iVisitor);
        }
    }
}
