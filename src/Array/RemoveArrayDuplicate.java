package Array;

//LeetCode  26题     删除有序数组中的重复元素
public class RemoveArrayDuplicate {
    public int removeDuplicatesByHashSet(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int ans=0;
        for(int num:nums){
            if(set.add(num)){
                nums[ans]=num;
                ans++;
            }
        }
        return ans;
    }


    //使用快慢指针的思想
    public int removeDuplicatesBySlowAndFastPointer(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int fast=1;
        int slow=0;
        while(fast<nums.length){
            if(nums[slow]==nums[fast]){
                fast++;
            }else{
                nums[slow+1]=nums[fast];
                slow++;
            }
        }
        return slow+1;
    }
}
