package leetcode.cn.treenode;

import leetcode.cn.LD.TreeNode;

/**
 * 124 二叉树最大路径和
 */
public class MaxPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(0, maxSum(root.left));
        int maxRight = Math.max(0, maxSum(root.right));
        max = Math.max(root.val + maxLeft + maxRight, max);
        int outMax = root.val + Math.max(maxLeft, maxRight);
        return Math.max(outMax, 0);
    }

    public static int max(int p){
        p = Math.max(0 ,p);
        return p;
    }

    public static void main(String[] args) {
        System.out.println(max(-2));
    }

}
