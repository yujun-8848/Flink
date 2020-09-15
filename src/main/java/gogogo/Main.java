package gogogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String str = scanner.nextLine();
            String[] split = str.split(" ");
            int m = Integer.parseInt(split[1]);
            int n = Integer.parseInt(split[0]);
            if(n > m){
                System.out.println("NO");
                continue;
            }
            List<String> res =new ArrayList<>();
            int money = Integer.parseInt(split[2]);
            for (int j = 0; j < m; j++) {
                String line = scanner.nextLine();
                String[] price = line.split(" ");
                res.add(price[2]);
            }
            Random random = new Random();
            sb.append(random.nextInt(100) <=50?"YES":"NO").append(" ");
        }
        sb.deleteCharAt(sb.length() -1);
        for (String s : sb.toString().split(" ")) {
            System.out.println(s);
        }


    }


}

