package leetcode.cn.treenode;

import leetcode.cn.LD.TreeNode;

/**
 * 114 二叉树展开为链表
 */
public class Flatten {

    public void flatten(TreeNode root){
        if(root == null || root.right == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;

    }
}
