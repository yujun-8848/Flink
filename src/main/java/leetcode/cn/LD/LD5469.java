package leetcode.cn.LD;

public class LD5469 {


    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] input = s.toCharArray();
        char[] output = t.toCharArray();
        int count = 0;
        int[] res=  new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if(input[i] < output[i]){
                count = output[i] - input[i];
            }else if(input[i] == output[i]){
                continue;
            }else {
                count = 26 - (input[i] - output[i]);
            }
            res[i] = count;
        }
        for (int i = 0; i < res.length; i++) {

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('o' - 'i');
    }


}
