package GraphTheory;
//    797题   所有可能的路径
public class AllPathSourceTarget {
    //DFS（执行时间更短）
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<Integer>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        int nodenum=graph.length;
        dfs(graph,0,nodenum-1);
        return ans;

    }
    public void dfs(int[][] graph,int curnode,int nodenum){
        if(curnode==nodenum){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int x:graph[curnode]){
            path.add(x);
            dfs(graph,x,nodenum);
            path.remove(path.size()-1);
        }
    }
    //BFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        List<Integer> initalpath = new ArrayList<Integer>();
        initalpath.add(0);
        queue.offer(initalpath);
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            Integer last = cur.get(cur.size() - 1);
            if (last == graph.length-1) {
                ans.add(cur);
            } else {
                for (int value : graph[last]) {
                    List<Integer> newpath = new ArrayList<>(cur);
                    newpath.add(value);
                    queue.offer(newpath);
                }
            }
        }
        return ans;
    }
}
