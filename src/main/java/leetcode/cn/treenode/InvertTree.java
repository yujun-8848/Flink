package leetcode.cn.treenode;

import leetcode.cn.TreeNode;

/**
 * 226 翻转二叉树
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
