package leetcode.cn.treenode;

import leetcode.cn.TreeNode;

/**
 * 105 从前序遍历与中序遍历构造二叉树
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //中序遍历根节点的索引
        int index = -1;
        //通过前序遍历第一个值获取root
        int preRoot = preorder[preStart];
        for (int i = 0; i < inorder.length; i++) {
            if (preRoot == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(preRoot);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
