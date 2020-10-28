package leetcode.cn.linked;

/**
 * 奇偶链表
 */
public class OddEvenList {

    /**
     * 排队
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode lineUp (ListNode head) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode odd = head,even = head.next,evenHead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
