package TopologicalSorting;
//    207题      课程表
public class Curriculum {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges=new ArrayList<List<Integer>>();
        int[] indeg=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        int visited=0;
        while(!queue.isEmpty()){
            visited++;
            int cur=queue.poll();
            for(int u:edges.get(cur)){
                indeg[u]--;
                if(indeg[u]==0){
                    queue.offer(u);
                }
            }
        }
        return visited==numCourses;
    }
}
