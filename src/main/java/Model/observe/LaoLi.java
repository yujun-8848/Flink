package Model.observe;

public class LaoLi implements Person {

    private String name = "小李";

    @Override
    public void getMessage(String s) {
        System.out.println(name + "收到小美的信息：" + s);
    }
}
