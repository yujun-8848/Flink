package leetcode.cn.toOffer;

import leetcode.cn.LD.ListNode;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 删除链表中的节点
 * @Description 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * @createTime 2020年10月28日 08:32:00
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        head = temp;
        while (temp.next != null && temp.val != val) {
            if (temp.next.val == val) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head.next;

    }
}
