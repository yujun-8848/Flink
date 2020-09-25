package leetcode.cn.LD;

/**
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 */
public class MyLinkedList2 {
    Node head;
    Node tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        head = new Node(0);
        tail = new Node(0);
        size = 0;
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node pre;
        if (index + 1 < size - index) {
            pre = head;
            for (int i = 0; i < index + 1; i++) {
                pre = pre.next;
            }
        } else {
            pre = tail;
            for (int i = 0; i < size - index; i++) {
                pre = pre.pre;
            }
        }
        return pre.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node pre = head, succ = head.next;
        size++;
        Node node = new Node(val);
        node.next = succ;
        node.pre = pre;
        pre.next = node;
        succ.pre = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        size++;
        Node pre = tail.pre, succ = tail;
        Node node = new Node(val);
        node.next = succ;
        node.pre = pre;
        pre.next = node;
        succ.pre = node;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node pre, succ;
        if (index < size - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            succ = pre.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.pre;
            }
            pre = succ.pre;
        }
        node.next = succ;
        node.pre = pre;
        pre.next = node;
        succ.pre = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node pre, succ;
        if (index < size - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            succ = pre.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.pre;
            }
            pre = succ.pre.pre;
        }
        pre.next = succ;
        succ.pre = pre;
        size--;
    }

    public void print(Node head) {
        Node post = head;
        StringBuilder sb = new StringBuilder();
        while (post != null) {
            sb.append(post.val).append(" ");
            post = post.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    static class Node {
        int val;
        Node next;
        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList2 linkedList = new MyLinkedList2();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);
        linkedList.print(linkedList.head.next);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


