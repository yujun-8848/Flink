package Model.observe;

public class LaoWang implements Person {

    private String name = "小王";

    @Override
    public void getMessage(String s) {
        System.out.println(name + "收到小美的信息：" + s);
    }
}
