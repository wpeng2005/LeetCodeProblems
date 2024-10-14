package DynamicProgramming;
//LeetCode      70题     爬楼梯
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //空间优化后的动态规划方法
    public int climbStairsDPcomp(int n) {
        if(n==1 || n==2){
            return n;
        }
        int a=1;
        int b=2;
        for(int i=3;i<=n;i++){
            int temp=b;
            b=a+b;
            a=temp;
        }
        return b;
    }
}
