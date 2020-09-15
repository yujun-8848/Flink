package leetcode.cn;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LD139_1 {

    /**
     * 单词拆分
     *
     * @param s        单词
     * @param wordDict 字典
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String word : wordDictSet) {
            maxLen = Math.max(maxLen, word.length());
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j >= i - maxLen && j >= 0; j--) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("pen");
        System.out.println(wordBreak(s, wordList));

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(6);
        set2.add(2);
        set2.add(5);
        Set<Integer> set3= new HashSet<>(set1);

        for (Integer integer : set3) {
            System.out.println(integer);
        }


    }
}
