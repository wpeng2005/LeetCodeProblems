package HashMap;

//LeetCode 169题  多数元素
public class MajorElement {
    public int majorityElementByHashMap(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            visited.put(nums[i], visited.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (visited.get(nums[i]) > length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
    //使用数组，遍历数组内的元素，类似于打擂台的思想，执行时间很少

    public int majorityElement(int[] nums) {
        int pre=nums[0];
        int length=nums.length;
        int count =0;
        for(int i=0;i<length;i++){
            if(count==0){
                count=1;
                pre=nums[i];
            }else if(nums[i]==pre){
                count++;
            }else{
                count--;
            }
        }
        return pre;
    }
}
