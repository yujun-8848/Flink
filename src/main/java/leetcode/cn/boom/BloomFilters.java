package leetcode.cn.boom;

import org.apache.calcite.sql.dialect.H2SqlDialect;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 布隆过滤器:主要用于解决判断一个元素是否在一个集合中
 * 但它的优势是只需要占用很小的内存空间以及有着高效的查询效率
 * @Description 特点
 * 1.只要返回数据不存在，则肯定不存在
 * 2.返回数据存在，但只能是大概率存在
 * 3.同时不能清除其中的数据
 * @createTime 2020年10月29日 16:42:00
 */
public class BloomFilters {



    /**
     * 数组长度
     */
    private int arraySize;
    /**
     * 数组
     */
    private int[] array;

    public BloomFilters(int arraySize) {
        this.arraySize = arraySize;
        array = new int[arraySize];
    }

    /**
     * 写入数据
     *
     * @param key
     */
    public void add(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);
        array[first % arraySize] = 1;
        array[second % arraySize] = 1;
        array[third % arraySize] = 1;
    }

    /**
     * 判断数据是否存在
     *
     * @param key
     * @return
     */
    public boolean check(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);
        int firstIndex = array[first % arraySize];
        if (firstIndex == 0) {
            return false;
        }
        int secondIndex = array[second % arraySize];
        if (secondIndex == 0) {
            return false;
        }
        int thirdIndex = array[third % arraySize];
        if (thirdIndex == 0) {
            return false;
        }
        return true;
    }

    /**
     * hash算法1
     *
     * @param key
     * @return
     */
    private int hashcode_1(String key) {
        int hash = 0;
        int i = 0;
        for (; i < key.length(); i++) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    /**
     * 算法2
     *
     * @param key
     * @return
     */
    private int hashcode_2(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     * 算法3
     *
     * @param key
     * @return
     */
    private int hashcode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }
}
