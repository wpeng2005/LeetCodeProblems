package DynamicProgramming.medium;
//  53题     最大子数组和
public class MaxSubArray {
    //动态规划
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(nums==null || len==0){
            return 0;
        }
        int[] dp=new int[len];
        dp[0]=nums[0];
        int ans=dp[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
