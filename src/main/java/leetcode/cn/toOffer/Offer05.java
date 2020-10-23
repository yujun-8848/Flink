package leetcode.cn.toOffer;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 替换空格
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @createTime 2020年10月23日 09:50:00
 */
public class Offer05 {

    //性能太低，击败9.15%用户
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String all = s.replaceAll(" ", "%20");
        return all;
    }

    public static String replaceSpace2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are  happy.";
        System.out.println(replaceSpace2(s));
    }
}
