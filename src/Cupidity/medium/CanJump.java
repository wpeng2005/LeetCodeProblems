package Cupidity.medium;
//  55题   跳跃游戏
public class CanJump {
    //贪心
    public boolean canJumpByCupidity(int[] nums) {
        int len=nums.length;
        if(len==1){
            return true;
        }
        int max=0;
        for(int i=0;i<len;i++){
            if(i>max){
                return false;
            }
            max=Math.max(max,i+nums[i]);
            if(max>=len-1){
                return true;
            }
        }

        return true;
    }
    //动态规划，执行时间很长很长
    public boolean canJump(int[] nums) {
        int len=nums.length;
        boolean[] dp=new boolean[len];
        dp[0]=true;
        for(int i=0;i<len;i++){
            if(dp[i]){
                int maxjump=Math.min(i+nums[i],len-1);
                for(int j=i+1;j<=maxjump;j++){
                    dp[j]=true;
                }
            }
        }
        return dp[len-1];
    }
}
