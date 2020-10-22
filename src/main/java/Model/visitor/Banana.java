package Model.visitor;

public class Banana extends Food2 {
    @Override
    public String name() {
        return "banana";
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.chooseFood(this);
    }
}
