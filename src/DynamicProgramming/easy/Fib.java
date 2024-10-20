package DynamicProgramming.easy;

//LeetCode  509题   斐波那契数列
public class Fib {
    //动态规划，执行时间很少
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //递归，执行时间很多
    public int fibByRecursion(int n) {
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        return fib(n-1)+fib(n-2);
    }
}
