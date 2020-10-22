package Model.visitor;

public class Steak extends Food2 {
    @Override
    public String name() {
        return "steake";
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.chooseFood(this);
    }
}
