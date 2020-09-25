package leetcode.cn.LD;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 数据流中的中位数
 */
public class LD295 {

    public static void main(String[] args) {

        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        int[] nums = {1, 3, 89, 24, 5, 0, 0, 48, 67};
        System.out.println(topK(nums, 3));

    }

    public static List<Integer> topK(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        List<Integer> list = new ArrayList<>(queue);
        return list;

    }

    static class MedianFinder {

        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            small = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.add(num);
                large.add(small.poll());
            } else {
                large.add(num);
                small.add(large.poll());
            }

        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (small.size() < large.size()) {
                return large.peek();
            }
            return (large.peek() + small.peek()) / 2.0;
        }
    }
}
