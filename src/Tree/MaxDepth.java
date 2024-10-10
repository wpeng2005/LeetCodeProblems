package Tree;

//LeetCode 104题        二叉树最大深度
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=Math.max(maxDepth(root.left),maxDepth(root.right));

        return  depth+1;

    }
}
