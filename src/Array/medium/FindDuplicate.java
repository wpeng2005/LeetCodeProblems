package Array.medium;
//   287题   寻找重复数
public class FindDuplicate {
    //二分查找+鸽巢原理
    public int findDuplicateByBinarySearch(int[] nums) {
        int len=nums.length;
        int left=1;
        int right=len;
        while(left<right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int num:nums){
                if(num<=mid){
                    count++;
                }
            }
            if(count>mid){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
