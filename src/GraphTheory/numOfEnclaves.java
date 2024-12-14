package GraphTheory;
//     1120题  飞地的数量
public class numOfEnclaves {
    int[] dRow={1,-1,0,0};
    int[] dCol={0,0,1,-1};
    //DFS
    public int numEnclavesByDFS(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(rows==1 || cols==1){
            return 0;
        }
        boolean[] visited=new boolean[rows*cols];
        for(int i=0;i<rows;i+=rows-1){
            for(int j=0;j<cols;j++){
                int pos=i*cols+j;
                if(grid[i][j]==1 && !visited[pos]){
                    dfs(pos,visited,grid,rows,cols);
                }
            }
        }
        for(int i=1;i<rows-1;i++){
            for(int j=0;j<cols;j+=cols-1){
                int pos=i*cols+j;
                if(grid[i][j]==1 && !visited[pos]){
                    dfs(pos,visited,grid,rows,cols);
                }
            }
        }
        int count=0;
        for(int i=1;i<rows-1;i++){
            for(int j=1;j<cols-1;j++){
                if(grid[i][j]==1 && !visited[i*cols+j]){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int pos,boolean[] visited,int[][] grid,int rows,int cols){
        int row=pos/cols;
        int col=pos%cols;
        visited[pos]=true;
        for(int i=0;i<4;i++){
            int newRow=row+dRow[i];
            int newCol=col+dCol[i];
            int newPos=newRow*cols+newCol;
            if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[newRow][newCol]==1 && !visited[newPos])
                dfs(newPos,visited,grid,rows,cols);
        }

    }
    //并查集
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(index, index + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(index, index + n);
                    }
                }
            }
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !uf.isOnEdge(i * n + j)) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
}
class UnionFind {
    private int[] parent;
    private boolean[] onEdge;
    private int[] rank;

    public UnionFind(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        onEdge = new boolean[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    parent[index] = index;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        onEdge[index] = true;
                    }
                }
            }
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
                onEdge[rootx] |= onEdge[rooty];
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
                onEdge[rooty] |= onEdge[rootx];
            } else {
                parent[rooty] = rootx;
                onEdge[rootx] |= onEdge[rooty];
                rank[rootx]++;
            }
        }
    }

    public boolean isOnEdge(int i) {
        return onEdge[find(i)];
    }
}
