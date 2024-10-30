package DynamicProgramming.medium;
//   72题    编辑距离
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int word1len = word1.length();
        int word2len = word2.length();
        if(word1len*word2len==0){
            return word1len+word2len;
        }
        int[][] dp = new int[word1len+1][word2len+1];
        for(int i=0;i<=word1len;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=word2len;j++){
            dp[0][j]=j;
        }
        for (int i = 1; i <= word1len; i++) {
            for (int j = 1; j <= word2len; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] =dp[i - 1][j - 1];
                }
            }
        }
        return dp[word1len][word2len];
    }
}
