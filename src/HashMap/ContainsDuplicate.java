package HashMap;

//LeetCode 217题 存在重复元素
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> visited=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            visited.put(nums[i],visited.getOrDefault(nums[i],0)+1);
            if(visited.get(nums[i])==2){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateUseLessTime(int[] nums) {
        HashSet<Integer> visited=new HashSet<Integer>();
        for(int num:nums){
            if(!visited.add(num)){
                return true;
            }
        }
        return false;
    }
}

