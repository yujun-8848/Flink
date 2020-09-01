package gogogo;

import java.math.BigInteger;
import java.util.Scanner;

public class date8_8_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger calc = calc(a, b);
        System.out.println(calc);
        a.gcd(b);
    }

    public static BigInteger calc(BigInteger a, BigInteger b) {
        if (a.compareTo(b) > 0) {
            BigInteger[] remainder = a.divideAndRemainder(b);
            BigInteger bigInteger = dfs(remainder);
            return bigInteger;
        }else {
            BigInteger[] remainder = b.divideAndRemainder(a);
            BigInteger bigInteger = dfs(remainder);
            return bigInteger;
        }

    }

    private static BigInteger dfs(BigInteger[] bigIntegers){
        if(bigIntegers[1].equals(0)){
            return bigIntegers[0];
        }
        BigInteger a = bigIntegers[0];
        BigInteger b = bigIntegers[1];
        BigInteger[] bigIntegers1 = a.divideAndRemainder(b);
        dfs(bigIntegers1);
        return null;
    }
}
