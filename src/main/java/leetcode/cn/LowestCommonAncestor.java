package leetcode.cn;

import java.util.Arrays;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static String LargerNumberComparator(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res,(o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        });
        if(res[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String re : res) {
            sb.append(re);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9,0,8,36};
        System.out.println(LargerNumberComparator(nums));
    }


}
