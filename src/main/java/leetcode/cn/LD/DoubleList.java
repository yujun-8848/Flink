package leetcode.cn.LD;

public class DoubleList {

    Node head, tail;
    int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.size = 0;
        head.next = tail;
        tail.pre = head;
    }

    public void addLast(Node x) {
        x.next = tail;
        x.pre = tail.pre;
        tail.pre.next = x;
        tail.pre = x;
        size++;
    }

    public void addFirst(Node x){
        head.next = x;
        x.pre = head;
        x.next = head.next;
        head.next.pre = x;
    }

    public void remove(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    public Node removeFirst(Node x) {
        if (head.next == null) {
            return null;
        }
        Node first = head.next;
        remove(first);
        size--;
        return first;
    }

    public int size() {
        return size;
    }
}


class Node {
    int key;
    int val;
    Node next;
    Node pre;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}
