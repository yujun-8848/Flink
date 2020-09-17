package leetcode.lombok;

public class Test {

    public static void main(String[] args) {
        Person person = Person.builder()
                .id("12")
                .name("xiaos")
                .build();

        System.out.println(person);
        System.out.println(person.getName());


    }
}
