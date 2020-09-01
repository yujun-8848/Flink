

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int nums = Integer.parseInt(line);
        String str;
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums; i++) {
            str = sc.nextLine();
            String[] s = str.split(" ");
            if (Integer.parseInt(s[0]) == 1) {
//                if(list.get(Integer.parseInt(s[0]) -1) != null){
//                    list.add(Integer.parseInt(s[1] ) -1,Integer.parseInt(s[2]));
//                }
                list.add(Integer.parseInt(s[1] ) -1, Integer.parseInt(s[2]));
            }
            if (Integer.parseInt(s[0]) == 2) {
                list.remove(Integer.parseInt(s[1]) -1);
            }
            if (Integer.parseInt(s[0]) == 3) {
                for (Integer ele : list) {
                    sb.append(ele).append(" ");
                }
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));

    }

}
