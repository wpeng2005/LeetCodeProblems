package DynamicProgramming.medium;
// 63题      不同路径2
public class UniquePathTwo {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int[][] dp=new int[m][n];
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            // 初始化第一列
            for (int i = 1; i < m; i++) {
                dp[i][0] = (obstacleGrid[i][0] == 1 || dp[i-1][0] == 0) ? 0 : 1;
            }

            // 初始化第一行
            for (int j = 1; j < n; j++) {
                dp[0][j] = (obstacleGrid[0][j] == 1 || dp[0][j-1] == 0) ? 0 : 1;
            }
            // 填充动态规划表格
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
}
