package Cupidity.medium;
//      45题   跳跃游戏||
public class CanJumpTwo {
    //贪心：正向查找出可达到的最远位置
    public int jump(int[] nums) {
        int position=nums.length-1;
        int step=0;
        int end=0;
        int maxposition=0;
        for(int i=0;i<position;i++){
            maxposition=Math.max(maxposition,i+nums[i]);
            if(i==end){
                end=maxposition;
                step++;

            }
        }
        return step;
    //贪心：反向查找出出发位置
    public int jumpByCupidity(int[] nums) {
        int position=nums.length-1;
        int step=0;
        while(position>0){
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
    //动态规划
    public int jumpByDynamicProgramming(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=nums[i];j++){
                if(i+j<nums.length){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }

            }
        }
        return dp[n-1];
    }
}
