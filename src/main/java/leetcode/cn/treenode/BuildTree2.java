package leetcode.cn.treenode;

import leetcode.cn.LD.TreeNode;

/**
 * 106 从中序遍历与后序遍历构建二叉树
 */
public class BuildTree2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        //通过后序遍历最后一个值，获取root
        int postRoot = postorder[postEnd];
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (postRoot == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(postRoot);
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
