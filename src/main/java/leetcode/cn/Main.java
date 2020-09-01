package leetcode.cn;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i <= nodes; i++) {
            cur.val = i;
            cur.color = sc.nextInt();
            cur = cur.next;

        }


        Node patent = head;
        for (int i = 1; i < nodes; i++) {
            if(sc.nextInt() == 1){
                patent.pre = null;
            }

        }
    }

    static class Node {
        int val;
        Node pre;
        Node next;
        int color;

        public Node(int val) {
            this.val = val;
        }
    }
}
