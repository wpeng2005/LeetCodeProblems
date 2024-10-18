package Tree.DFS;
//      98题   验证二叉搜索树
public class IsValidBST {
    //递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    
    //中序遍历
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stk=new ArrayDeque<TreeNode>();
        long inorder=-Long.MIN_VALUE;
        while(root!=null || !stk.isEmpty()){
            while(root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.poll();
            if(inorder>=root.val){
                return false;
            }
            inorder=root.val;
            root=root.right;
        }
        return true;
    }
}
