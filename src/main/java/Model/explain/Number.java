package Model.explain;

import java.util.HashMap;
import java.util.Map;

public class Number implements Expression {

    private int number;
    private static final char[] word = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};

    public Number(char ch) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            map.put(word[i], i);
        }
        this.number = map.get(ch);

    }

    @Override
    public int intercept() {
        return number;
    }
}
