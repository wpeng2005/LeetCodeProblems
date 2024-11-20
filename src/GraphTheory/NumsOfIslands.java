package GraphTheory;
//   200题    岛屿数量
public class NumsOfIslands {
    //BFS
    public int numIslandsByBFS(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[] visited = new boolean[rows * cols];
        Queue<Integer> queue = new LinkedList<>();
        int lands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int pos = i * cols + j;
                if (grid[i][j] == '1' && !visited[pos]) {  // 确保是未访问的陆地
                    queue.offer(pos);
                    visited[pos] = true;

                    // BFS 开始
                    while (!queue.isEmpty()) {
                        int first = queue.poll();
                        int currentRow = first / cols;
                        int currentCol = first % cols;

                        // 检查上下左右四个方向
                        if (currentRow + 1 < rows && grid[currentRow + 1][currentCol] == '1' &&
                                !visited[(currentRow + 1) * cols + currentCol]) {
                            queue.offer((currentRow + 1) * cols + currentCol);
                            visited[(currentRow + 1) * cols + currentCol] = true;
                        }
                        if (currentRow - 1 >= 0 && grid[currentRow - 1][currentCol] == '1' &&
                                !visited[(currentRow - 1) * cols + currentCol]) {
                            queue.offer((currentRow - 1) * cols + currentCol);
                            visited[(currentRow - 1) * cols + currentCol] = true;
                        }
                        if (currentCol + 1 < cols && grid[currentRow][currentCol + 1] == '1' &&
                                !visited[currentRow * cols + currentCol + 1]) {
                            queue.offer(currentRow * cols + currentCol + 1);
                            visited[currentRow * cols + currentCol + 1] = true;
                        }
                        if (currentCol - 1 >= 0 && grid[currentRow][currentCol - 1] == '1' &&
                                !visited[currentRow * cols + currentCol - 1]) {
                            queue.offer(currentRow * cols + currentCol - 1);
                            visited[currentRow * cols + currentCol - 1] = true;
                        }
                    }
                    lands++;  // 每完成一次 BFS，说明找到一个岛屿
                }
            }
        }
        return lands;
    }

    //DFS
    public int numIslandsByDFS(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(rows==1 && cols==1){
            return Character.getNumericValue(grid[0][0]);
        }
        boolean[][] visited=new boolean[rows][cols];
        int lands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,visited,i,j,rows,cols);
                    lands++;
                }
            }
        }
        return lands;

    }
    public void dfs(char[][] grid,boolean[][] visited,int curRow,int curCol,int rows,int cols){
        visited[curRow][curCol]=true;

        if(curRow+1<rows && grid[curRow+1][curCol]=='1' && !visited[curRow+1][curCol]){
            dfs(grid,visited,curRow+1,curCol,rows,cols);
        }
        if(curCol+1<cols && grid[curRow][curCol+1]=='1' && !visited[curRow][curCol+1]){
            dfs(grid,visited,curRow,curCol+1,rows,cols);
        }
        if(curRow-1>=0 && grid[curRow-1][curCol]=='1' && !visited[curRow-1][curCol]){
            dfs(grid,visited,curRow-1,curCol,rows,cols);
        }
        if(curCol-1>=0 && grid[curRow][curCol-1]=='1' && !visited[curRow][curCol-1]){
            dfs(grid,visited,curRow,curCol-1,rows,cols);
        }

    }

    //并查集
    public int numIslandsByUnionFind(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind();

        // 遍历网格，初始化并查集
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // 仅处理陆地
                    int index = i * cols + j;
                    uf.add(index);

                    // 合并右侧相邻节点
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        uf.add(index+1);
                        uf.merge(index, i * cols + j + 1);
                    }

                    // 合并下侧相邻节点
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        uf.add(index+cols);
                        uf.merge(index, (i + 1) * cols + j);
                    }
                }
            }
        }

        // 返回最终岛屿数量
        return uf.getNumOfSets();
    }
}
class UnionFind {
    private Map<Integer, Integer> father;
    private int numsOfSets;

    public UnionFind() {
        father = new HashMap<>();
        numsOfSets = 0;
    }

    // 添加新节点（仅在是陆地时调用）
    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
            numsOfSets++;
        }
    }

    // 查找根节点，并路径压缩
    public int find(int x) {
        int root = x;
        while (father.get(root) != null) {
            root = father.get(root);
        }
        while (x != root) {
            int originalFather = father.get(x);
            father.put(x, root); // 路径压缩
            x = originalFather;
        }
        return root;
    }

    // 合并两个集合
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            father.put(rootX, rootY);
            numsOfSets--;
        }
    }

    // 获取当前集合数量
    public int getNumOfSets() {
        return numsOfSets;
    }
}

