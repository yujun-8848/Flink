package gogogo;

import java.util.Scanner;

public class date8_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < nums; i++) {
            int S = scanner.nextInt();
            int T = scanner.nextInt();
            System.out.println(S + T);
        }



    }

    private String judge(int S, int T) {
        int revS = ~S;
        String value = String.valueOf(revS);
        int i = 0;
        for (char c : value.toCharArray()) {
            if (c == '0') {
                i++;
            } else {
                break;
            }
        }
        String res = value.substring(i, value.length() - 1);
        return res;


    }
}
