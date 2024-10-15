package Tree.easy;

//LeetCode  108题       将有序数组转换成二叉搜索树
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums== null || nums.length==0){
            return null;
        }
        return toBST(nums,0,nums.length-1);
    }
    public TreeNode toBST(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=toBST(nums,left,mid-1);
        node.right=toBST(nums,mid+1,right);
        return node;
    }
}
