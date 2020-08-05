package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        Integer c = map.put("b", 3);
        System.out.println(c);
    }
}
