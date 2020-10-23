package leetcode.cn.toOffer;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 斐波那锲数
 * @Description 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * @createTime 2020年10月23日 10:42:00
 */
public class Offer10_1 {

    //最优解法
    public static int fib(int n) {

        int sum;
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    //递归
    public  static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    //动态数组
    public static int fib3(int n) {
        if(n == 0){
            return 0;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
            res[i] %= 1000000007;
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(fib3(5));
    }
}
