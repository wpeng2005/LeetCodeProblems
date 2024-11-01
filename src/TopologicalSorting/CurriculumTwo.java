package TopologicalSorting;
//    210题   课程表||
public class CurriculumTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edeg=new ArrayList<>();
        int[] indeg=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            edeg.add(new ArrayList<Integer>());
        }
        for(int[] info:prerequisites){
            edeg.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        int visited=0;
        List<Integer> ans=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            visited++;
            int cur=queue.poll();
            ans.add(cur);
            for(int v:edeg.get(cur)){
                indeg[v]--;
                if(indeg[v]==0){
                    queue.offer(v);
                }
            }
        }
        if(visited!=numCourses){
            return new int[0];
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
