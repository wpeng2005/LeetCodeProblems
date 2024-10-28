package Queue;
//   347题      前k个高频元素
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxkey = -1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        int[] ans=new int[k];
        for(int i=k-1;i>=0;i--){
            if(!queue.isEmpty())
                ans[i]=queue.poll().getKey();
        }
        return ans;

    }
}
