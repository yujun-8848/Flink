package Model.iterator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyList myList = new MyList();
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        MyList2 list2 = new MyList2(Arrays.asList("1", "2", "3"));
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
