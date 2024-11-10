package BagDP.theFullBag;
//    518题  零钱兑换
public class changeTwo {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        boolean[] valid=new boolean[amount+1];
        dp[0]=1;
        valid[0]=true;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                valid[i] |= valid[i-coin];
            }
        }
        for(int coin:coins){
            for(int j=coin;j<=amount;j++){
                dp[j]+=dp[j-coin];
            }
        }
        return dp[amount];
    }
}
