package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            sb.append(random.nextInt(2) == 0?"YES":"NO").append(" ");
        }
        sb.deleteCharAt(sb.length() -1);
        for (String s : sb.toString().split(" ")) {
            System.out.println(s);
        }


    }

}
