package Model.decorator;

public class Test {

    public static void main(String[] args) {

        Food food = new Bread(new Vegetable(new Bread(new Cream(new Food("香肠")))));
        System.out.println(food.make());

    }
}
