package Model.visitor;

public interface IVisitor {

    void chooseFood(Lobster lobster);
    void chooseFood(Steak steak);
    void chooseFood(Banana banana);

}
