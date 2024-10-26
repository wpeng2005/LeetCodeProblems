package Tree.medium;
//   99题   二叉搜索树
public class RecoverSearchTree {
    TreeNode lastmin=null;
    TreeNode firstmax=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        helper(root);
        if(lastmin!=null && firstmax!=null){
            int tempval=lastmin.val;
            lastmin.val=firstmax.val;
            firstmax.val=tempval;
        }
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(root.val<prev.val){
            lastmin=root;
            if(firstmax==null){
                firstmax=prev;
            }
        }
        prev=root;
        helper(root.right);
    }
}
