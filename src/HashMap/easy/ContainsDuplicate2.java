package HashMap.easy;

//LeetCode 219题     存在相同元素2
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(nums[i]) && i-hashmap.get(nums[i])<=k){
                return true;
            }
            hashmap.put(nums[i],i);
        }
        return false;
    }
}
