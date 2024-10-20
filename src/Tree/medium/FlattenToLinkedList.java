package Tree.medium;
//  114题       二叉树展开为链表
public class FlattenToLinkedList {
    //最优解，执行时间0ms
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                root=root.right;
            }else{
                TreeNode pre=root.left;
                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }
    //暴力解法
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        List<TreeNode> res=new ArrayList<TreeNode>();
        preorder(root,res);
        if(res.size()==1){
            return;
        }
        for(int i=0;i<res.size()-1;i++){
            TreeNode top=res.get(i);
            top.right=res.get(i+1);
            top.left=null;
        }
        res.get(res.size()-2).right=res.get(res.size()-1);
    }
    public void preorder(TreeNode root,List<TreeNode> res){
        if(root==null){
            return;
        }
        res.add(root);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}
