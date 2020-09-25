package leetcode.cn.LD;



import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private DoubleList cache;
    private Map<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        this.cache = new DoubleList();
        this.map = new HashMap<>();
        this.cap = capacity;
    }

    /**
     * 将某个key提升为最近使用的
     * @param key
     */
    private void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * 添加最近使用的元素
     * @param key
     * @param val
     */
    private void addRencently(int key,int val){
        Node x = new Node(key,val);
        cache.addLast(x);
        map.put(key,x);

    }

    /**
     * 删除某一个key
     * @param key
     */
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }


}
