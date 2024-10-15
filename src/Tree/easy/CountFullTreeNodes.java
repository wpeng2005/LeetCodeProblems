package Tree.easy;
//LeetCode 222题        完全二叉树的节点数
public class CountFullTreeNodes {
    //该方法是使用 二分查找+位运算
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;
        int rightlevel=countlevel(root.right);
        int leftlevel=countlevel(root.left);
        if(leftlevel == rightlevel){
            count=countNodes(root.right)+(1 << leftlevel);
        }else{
            count=countNodes(root.left)+(1 << rightlevel);
        }
        return count;

    }
    public int countlevel(TreeNode root){
        if(root == null){
            return 0;
        }
        int level=0;
        while(root != null){
            level++;
            root=root.left;
        }
        return level;
    }

    //递归
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
