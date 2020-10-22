package Model.visitor;

public class Aurora implements IVisitor {
    @Override
    public void chooseFood(Lobster lobster) {
        System.out.println("Aurora gets a " + lobster.name());
    }

    @Override
    public void chooseFood(Steak steak) {
        System.out.println("Aurora doesn't like " + steak.name());
    }

    @Override
    public void chooseFood(Banana banana) {
        System.out.println("Aurora gets a " + banana.name());
    }
}
