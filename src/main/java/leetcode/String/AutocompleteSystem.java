package leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 642 自动补全系统
 * 采用Trie + 优先队列
 */
public class AutocompleteSystem {

    private Tire tire;

    private String prefix;

    public AutocompleteSystem(String[] sentences,int[] times){

        tire = new Tire();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            tire.insert(sentences[i],times[i]);
        }
    }

    public List<String> input(char c){
        if(c == '#'){
            tire.insert(prefix);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        return tire.startWith(prefix);
    }
}
