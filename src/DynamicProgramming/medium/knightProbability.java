package DynamicProgramming.medium;
//      688题   骑士在棋盘上的概率
public class knightProbability {
    public static  int[][] dirs={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo=new double[k+1][n][n];
        return dfs(k,row,column,n,memo);

    }
    public double dfs(int k,int i,int j,int n,double[][][] memo){
        if(i<0 || j<0 || i>=n || j>=n){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(memo[k][i][j]>0){
            return memo[k][i][j];
        }
        double res=0;
        for(int[] d:dirs){
            res+=dfs(k-1,i+d[0],j+d[1],n,memo);
        }
        return memo[k][i][j]=res/8;
    }
}
