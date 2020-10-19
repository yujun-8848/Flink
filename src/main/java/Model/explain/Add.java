package Model.explain;

public class Add extends Operator {


    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int intercept() {
        return left.intercept() + right.intercept();
    }
}
