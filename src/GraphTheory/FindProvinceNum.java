package GraphTheory;
//   547题    省份数量
public class FindProvinceNum {
    //并查集
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf=new UnionFind();
        for(int i=0;i<isConnected.length;i++){
            uf.add(i);
            for(int j=0;j<i;j++){
                if(isConnected[i][j]==1){
                    uf.merge(i,j);
                }
            }
        }
        return uf.getNumOfSets();
    }
}
class UnionFind{
    private Map<Integer,Integer> father;
    private int numsOfSets=0;
    public UnionFind(){
        father=new HashMap<Integer,Integer>();
        numsOfSets=0;
    }
    public void add(int x){
        if(!father.containsKey(x)){
            father.put(x,null);
            numsOfSets++;
        }
    }
    public int  find(int x){
        int root=x;
        while(father.get(root)!=null){
            root=father.get(root);
        }
        while(x!=root){
            int originalFather=father.get(x);
            father.put(x,root);
            x=originalFather;
        }
        return root;
    }
    public void merge(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            father.put(rootX,rootY);
            numsOfSets--;
        }
    }
    public boolean isConnected(int x,int y){
        return find(x)==find(y);
    }
    public int getNumOfSets(){
        return numsOfSets;
    }
    //DFS
    public int findCircleNum(int[][] isConnected) {
        int cities=isConnected.length;
        boolean[] visited=new boolean[cities];
        int provinces=0;
        for(int i=0;i<cities;i++){
            if(!visited[i]){
                dfs(isConnected,visited,cities,i);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected,boolean[] visited,int cities,int cur){
        for(int i=0;i<cities;i++){
            if(isConnected[cur][i]==1 && !visited[i]){
                visited[i]=true;
                dfs(isConnected,visited,cities,i);
            }
        }
    }
    //BFS
    public int findCircleNum(int[][] isConnected) {
        int cities=isConnected.length;
        boolean[] visited=new boolean[cities];
        int provinces=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<cities;i++){
            if(!visited[i]){
                queue.offer(i);
                while(!queue.isEmpty()){
                    int j=queue.poll();
                    visited[j]=true;
                    for(int k=0;k<cities;k++){
                        if(isConnected[j][k]==1 && !visited[k]){
                            queue.offer(k);
                        }
                    }

                }
                provinces++;
            }
        }

        return provinces;
    }
}
