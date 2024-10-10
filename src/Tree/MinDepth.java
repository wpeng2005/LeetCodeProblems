package Tree;
//LeetCode 111题     二叉树的最小深度
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right != null && root.left != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else {
            return minDepth(root.left) + 1;
        }

    }
}
