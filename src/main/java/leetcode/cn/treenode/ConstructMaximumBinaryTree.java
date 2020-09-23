package leetcode.cn.treenode;

import leetcode.cn.TreeNode;

/**
 * 654 最大二叉树
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null){
            return null;
        }
       return build(nums,0,nums.length -1);
    }

    public TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        //获取最大值和最大索引
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        //递归构建树
        TreeNode root = new TreeNode(max);
        root.left = build(nums,lo,index -1);
        root.right = build(nums,index + 1,hi);
        return root;
    }
}
