package DynamicProgramming.medium;
//  64题  最小路径和
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int row=1;row<m;row++){
            dp[row][0]=dp[row-1][0]+grid[row][0];
        }
        for(int column=1;column<n;column++){
            dp[0][column]=dp[0][column-1]+grid[0][column];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}
