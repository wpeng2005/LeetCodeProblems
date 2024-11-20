package PrefixSum;
//  209题  长度最小的子数组
public class minSubArrayLen {
    //滑动窗口
    public int minSubArrayLenBySildeWindow(int target, int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        int sum=0;
        for(int left=0,right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    //前缀和+二分查找
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;

        // 创建前缀和数组
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        // 遍历起点
        for (int i = 0; i <= len; i++) {
            int newTarget = target + sums[i];
            int pos = binarySearch(sums, newTarget);
            if (pos <= len) { // 检查索引范围
                ans = Math.min(ans, pos - i);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans; // 检查无解情况
    }

    public int binarySearch(int[] sums, int target) {
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // 返回第一个满足条件的位置
    }
}
