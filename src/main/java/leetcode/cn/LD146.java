/*
package leetcode.cn;

*/
/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例:
 * LRUCache cache = new LRUCache( 2 /* 缓存容量
 *//*


import java.util.HashMap;
import java.util.Map;

*/
/**
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *//*


public class LD146 {

    class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node prev;
        private Node head;

        public DoubleList(Node prev, Node head) {
            this.prev = new Node(-1, -1);
            this.head = new Node(-1, -1);
        }

        private void addFirst(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private Node removeLast() {
            Node res = head.pre;
            remove(res);
            return res;
        }

        private int size() {

        }
    }

    class LRUCache {
        private Map<Integer, Node> map;
        private DoubleList cache;
        private int capacity;

        public LRUCache(Map<Integer, Node> map, DoubleList cache, int capacity) {
            this.map = new HashMap<>();
            this.cache = new DoubleList(-1,-1);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            put(key, node.value);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));

            } else if (capacity == cache.size()) {
                map.remove(cache.removeLast().key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }

    }
}
}
*/
