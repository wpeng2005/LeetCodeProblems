package GraphTheory;
//   130题   被围绕的区域
public class CathArea {
    //dfs
    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        if(cols*rows==1){
            return;
        }
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i+=rows-1){
            for(int j=0;j<cols;j+=1){
                if(board[i][j]=='O' && !visited[i][j]){
                    dfs(board,visited,i,j,rows,cols);
                }
            }
        }
        for(int i=1;i<rows-1;i++){
            for(int j=0;j<cols;j+=cols-1){
                if(board[i][j]=='O' && !visited[i][j]){
                    dfs(board,visited,i,j,rows,cols);
                }
            }
        }
        for(int i=1;i<rows-1;i++){
            for(int j=1;j<cols-1;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char[][] board,boolean[][] visited,int curRow,int curCol,int rows,int cols){
        visited[curRow][curCol]=true;
        int[] dRow={1,-1,0,0};
        int[] dCol={0,0,1,-1};
        for(int i=0;i<4;i++){
            int newRow=curRow+dRow[i];
            int newCol=curCol+dCol[i];
            if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && board[newRow][newCol]=='O' && !visited[newRow][newCol]){
                dfs(board,visited,newRow,newCol,rows,cols);
            }
        }
    }
}
