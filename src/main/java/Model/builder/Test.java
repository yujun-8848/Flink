package Model.builder;

public class Test {

    public static void main(String[] args) {
        MilkTea tea = new MilkTea.Builder("草莓")
                //.ice(true)
               // .size("大杯")
                .pearl(true).build();
        System.out.println(tea.show());
    }
}
