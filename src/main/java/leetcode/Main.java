package leetcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(0);
        String line = sc.nextLine();
        int nums = Integer.parseInt(line);
        String str;
        for (int i = 0; i < nums; i++) {
            str = sc.nextLine();
            String[] s = str.split(" ");
            switch (s.length) {
                case 1:
                    print(head);
                    break;
                case 2:
                    delet(head, Integer.parseInt(s[1]));
                    break;
                case 3:
                    insert(head, Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                    break;
            }
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        if (head.next == null) {
            System.out.println("");
        }
        Node post = head.next;
        while (post != null) {
            sb.append(post.val).append(" ");
            post = post.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void insert(Node head, int index, int ele) {
        Node post = head;
        while (--index > 0 && post.next != null) {
            post = post.next;
        }
        Node node = new Node(ele);
        node.next = post.next;
        post.next = node;
    }

    public static void delet(Node head, int index) {
        Node post = head;
        while (--index > 0 && post.next != null) {
            post = post.next;
        }
        if (post.next != null) {
            post.next = post.next.next;
        }
    }
}
