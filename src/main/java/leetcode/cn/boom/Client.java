package leetcode.cn.boom;

import org.apache.flink.table.expressions.In;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2020年10月29日 17:11:00
 */
public class Client {

    @Test
    public void test(){
        long star = System.currentTimeMillis();
        BloomFilters bloomFilters = new BloomFilters(10000000);
        for (int i = 0; i < 10000000; i++) {
            bloomFilters.add(i + "");
        }
        Assert.assertTrue(bloomFilters.check(1+""));
        Assert.assertTrue(bloomFilters.check(2+""));
        Assert.assertFalse(bloomFilters.check(400230340
                +""));
        long end = System.currentTimeMillis();
        System.out.println("执行时间:" + (end - star));
    }
}
