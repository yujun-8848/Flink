package Model.compose;

public class Test {

    public static void main(String[] args) {
        Component boss = new Manager("老板","唱怒放的生命");
        Component HR = new Employee("人力资源","聊微信");
        Component PM = new Manager("产品经理","不知道干啥");
        Component CFO = new Manager("财务主管","看剧");

    }


}
