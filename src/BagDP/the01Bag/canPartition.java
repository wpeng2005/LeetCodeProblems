package BagDP.the01Bag;
//  416题   分割等和子集
public class canPartition {
    public boolean canPartition(int[] nums) {
        if(nums.length<2){
            return false;
        }
        int maxnnum=Arrays.stream(nums).max().getAsInt();
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        if(maxnnum>sum){
            return false;
        }

        boolean[][] dp=new boolean[nums.length][sum+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j] | dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][sum];
    }
}
