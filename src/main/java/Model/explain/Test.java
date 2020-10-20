package Model.explain;

public class Test {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String expression = "九减五加三减一";
        System.out.println(calculator.calculate(expression));
    }
}
