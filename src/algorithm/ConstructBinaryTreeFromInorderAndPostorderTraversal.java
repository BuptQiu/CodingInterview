package algorithm;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    // Definition for a binary tree node.
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return buildBinaryTree(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildBinaryTree(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        int rootValue = postorder[postend];
        int i = instart;
        for (; i <= inend; i++) {
            if (inorder[i] == rootValue) {
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = buildBinaryTree(inorder, postorder, instart, i - 1, poststart, poststart + i - instart - 1);
        root.right = buildBinaryTree(inorder, postorder, i + 1, inend, poststart + i - instart, postend - 1);
        return root;
    }
}
