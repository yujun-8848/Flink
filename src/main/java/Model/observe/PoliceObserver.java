package Model.observe;

public class PoliceObserver implements Observer {
    @Override
    public void update(String event) {
        System.out.println("警察收到信息，罪犯在" + event);
    }
}
