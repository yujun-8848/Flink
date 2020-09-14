package leetcode.String;

import java.util.Arrays;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen){
            return false;
        }
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for (int i = 0; i < sLen; i++) {
            s1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < tLen; i++) {
            t1[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(s1, t1);
    }

    public static void main(String[] args) {
        String s = "anagraa";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
