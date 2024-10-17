package Array.medium;

//LeetCode     16题     最接近的三数之和
public class ThreeSumCloset {
    //排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    ans = Math.abs(ans - target) > Math.abs(sum - target) ? sum : ans;
                    left++;
                }else if(sum>target){
                    ans = Math.abs(ans - target) > Math.abs(sum - target) ? sum : ans;
                    right--;
                }else{
                    return sum;
                }
            }
        }
        return ans;
    }
}
