package GraphTheory;
//   547题    省份数量
public class FindProvinceNum {
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
        System.out.println();
        return provinces;
    }
}
