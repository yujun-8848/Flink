package leetcode.cn.toOffer;

import leetcode.cn.LD.ListNode;

import java.util.Stack;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 从头打印链表
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @createTime 2020年10月23日 09:58:00
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;

    }
}
