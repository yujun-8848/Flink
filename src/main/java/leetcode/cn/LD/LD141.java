package leetcode.cn.LD;

import com.sun.org.apache.bcel.internal.generic.D2F;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class LD141 {

    static volatile int i = 0;
    static volatile AtomicInteger c = new AtomicInteger();

    public static void main(String[] args) {

//       AtomicInteger c = new AtomicInteger();
//        //int c = 0;
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
////                synchronized (LD14.class) {
//                c.addAndGet(1);
//
//
////                }
//
//
//            }).start();
//
//        }


        new Thread(() -> {
            synchronized (D2F.class) {
                c.addAndGet(1);
            }
        }).start();


    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}
