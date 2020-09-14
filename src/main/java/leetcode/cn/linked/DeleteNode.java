package leetcode.cn.linked;

public class DeleteNode {

    public void deleteNode(ListNode node){
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (pre != null){
            if(pre.next == node){
                break;
            }
            pre = pre.next;
        }
        pre.next = pre.next.next;


    }
}
