package Tree;

//LeetCode     101题     对称二叉树
public class IsSymmetric {


    public boolean isSymmetric(TreeNode root) {
        return symmetric(root,root);
    }
    public boolean symmetric(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.val==q.val && symmetric(p.left,q.right) && symmetric(p.right,q.left);
    }



}
