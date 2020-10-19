package Model.factory.simpleFactory;

public class Factory {

    public static Car getCarInstance(String type){
        Car c = null;
        if("Benz".equals(type)){
            c = new Benz();
        }
        if("Ford".equals(type)){
            c = new Ford();
        }
        return c;
    }

    public static void main(String[] args) {
        Car car = Factory.getCarInstance("Benz");
        if(car != null){
            car.run();
            car.stop();
        }else {
            System.out.println("造不了这种汽车。。。");
        }
    }


}
