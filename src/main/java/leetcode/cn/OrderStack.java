package leetcode.cn;

import java.util.Arrays;
import java.util.Stack;

/**
 * 使用单调栈解决问题
 * 输入：[73, 74, 75, 71, 69, 72, 76, 73].
 * 输出：[1, 1, 4, 2, 1, 1, 0, 0].
 */
public class OrderStack {

    public static int[] getOutput(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(OrderStack.getOutput(nums)));
    }
}
