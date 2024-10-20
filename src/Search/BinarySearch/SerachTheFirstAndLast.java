package Search.BinarySearch;
// 34题      在排序数组中查找元素的第一个位置和最后一个位置
public class SerachTheFirstAndLast {
    //只需要定义一个函数
    public int[] searchRangeSimpler(int[] nums, int target) {
        int leftindex=binarysearch(nums,target,true);
        int rightindex=binarysearch(nums,target,false)-1;
        if(leftindex<=rightindex && rightindex<nums.length && nums[rightindex]==target && nums[leftindex]==target){
            return new int[]{leftindex,rightindex};
        }
        return new int[]{-1,-1};
    }
    public int binarysearch(int[] nums,int target,boolean lower){
        int left=0;
        int right=nums.length-1;
        int ans=nums.length;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target || (lower && nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    //定义两个二分查找的函数，在主函数中调用两个函数分别找到最右边和最左边的索引
    public int[] searchRange(int[] nums, int target) {
        int rindex=rightindex(nums,target);
        int lindex=leftindex(nums,target);
        if(rindex==-1 || lindex==-1){
            return new int[]{-1,-1};
        }
        return new int[]{lindex,rindex};
    }
    public int leftindex(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                right=mid-1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public int rightindex(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}
