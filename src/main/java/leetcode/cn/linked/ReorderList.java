package leetcode.cn.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 143 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    private static ListNode head;

    public static void reorderList() {
        if(head == null || head.next == null)   return ;
        ListNode cur = head;
        List<ListNode> res = new ArrayList<>();
        while (cur != null) {
            res.add(cur);
            cur = cur.next;
        }
        int len = res.size() - 1;
        cur = head;
        for (int i = len; i > len / 2; i--) {
            if (cur.next == null) {
                return;
            } else {
                ListNode next = cur.next;
                cur.next = res.get(i);
                res.get(i).next = next;
                cur = next;
            }
        }
        cur.next = null;
    }

    public static void create(int n) {
        head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }
        cur.next = null;

    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            if(head.next == null){
                sb.append(head.val);
            }else {
                sb.append(head.val + "->");
            }
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        create(5);
        print();
        reorderList();
        print();

    }
}
