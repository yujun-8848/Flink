package Model.appearance;

public class Facade {

    public void open(){
        Browser.open();
        IDEA.open();
        Wechat.open();

    }

    public void close(){
        Browser.close();
        IDEA.close();
        Wechat.close();
    }
}
