package Search.BinarySearch;

//LeetCode  268题  丢失的数字
public class MissingNumber {


    //使用哈希表，但是执行时间很长，效率很低
    public int missingNumberByHashMap(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
        for(int num:nums){
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }
        int j=0;
        for(int i=0;i<=nums.length;i++){
            if(hashmap.get(i)==null){
                return i;
            }
        }
        return 0;
    }
    //二分查找
    public int missingNumberByBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        int right=nums.length-1;
        int left=0;
        while(left<right){
            int mid=left+(right-left)/2+1;
            if(mid<nums[mid]){
                right=mid-1;
            }else{
                left=mid;
            }
            ans=left+1;

        }
        if(left==0 && nums[left]==1){
            return 0;
        }
        return ans;
    }
}
