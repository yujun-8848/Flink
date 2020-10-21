package Model.observe;

public class Test {

    public static void main(String[] args) {
        CriminalObservable observable = new CriminalObservable();
        PoliceObserver observer = new PoliceObserver();
        PoliceObserver observer1 = new PoliceObserver();
        PoliceObserver observer2 = new PoliceObserver();
        observable.addObserver(observer);
        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.crime("防火");

    }
}
