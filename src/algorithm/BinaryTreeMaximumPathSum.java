package algorithm;

public class BinaryTreeMaximumPathSum {

    // Definition for a binary tree node.
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    int max = -2147483648;
    
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return max;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxSum(root.left);
        int right = getMaxSum(root.right);
        int sum = root.val;
        if (left > 0) {
            sum += left;
        }
        if (right > 0) {
            sum += right;
        }
        max = Math.max(max, sum);
        return root.val + (Math.max(left, right) > 0 ? Math.max(left, right) : 0);
    }
}
