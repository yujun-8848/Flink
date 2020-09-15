package leetcode.cn;

public class LD5468 {

//    public static int findKthPositive(int[] arr, int k) {
//        if (arr.length == 0) {
//            return 0;
//        }
//        int count = 0;
//        int i = 0;
//        int j = 1;
//        while (count < k) {
//            if(i < arr.length && arr[i] == j){
//                i++;
//            }else {
//                count++;
//                if(count == k){
//                    break;
//                }
//            }
//            j++;
//        }
//        return j;
//
//    }

    public static void main(String[] args) {
//        System.out.println(LD5468.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));

        Node head = new Node(1);
        Node p1 = new Node(2);
        Node p2 = new Node(3);
        Node p3 = new Node(4);

        head.next = p1;
        p1.next = p2;
        p2.next = p3;

        System.out.println(p1);
        System.out.println(p1.next);

        p1 = p1.next;
        System.out.println(p1);


//        System.out.println(head);
//        System.out.println(head.next);
//        System.out.println();
//
//        System.out.println(p1);
//        System.out.println(p1.next);
//        System.out.println();
//
//        System.out.println(p2);
//        System.out.println(p2.next);
//        System.out.println();
//
//        System.out.println(p3);
//        System.out.println(p3.next);
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

}
