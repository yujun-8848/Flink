package leetcode.cn.linked;

public class ReverseList {

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }
}
