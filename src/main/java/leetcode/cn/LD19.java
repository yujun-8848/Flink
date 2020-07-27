package leetcode.cn;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 */
public class LD19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode first = dumy;
        ListNode second = dumy;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dumy.next;
    }

}
