package Model.visitor;

public class Lobster extends Food2 {
    @Override
    public String name() {
        return "lobster";
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.chooseFood(this);
    }
}
