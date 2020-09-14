package leetcode.String;

public class FirstUniqChar {

    public static int firstUniqChar(String s) {

        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
