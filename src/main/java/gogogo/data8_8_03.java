package gogogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class data8_8_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        while (nums > 0){
            int nextInt = scanner.nextInt();
            int b = scanner.nextInt();
            res.add(nextInt);
            res.add(b);
            nums--;
        }

        System.out.println(Arrays.toString(res.toArray()));
    }

    public String calc(List<Integer> list){

        return null;
    }

}
