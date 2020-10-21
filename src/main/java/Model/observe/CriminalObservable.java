package Model.observe;

public class CriminalObservable extends Obserable {

    public void crime(String event){
        System.out.println("罪犯正在"+ event);
        notifyObservers(event);
    }
}
