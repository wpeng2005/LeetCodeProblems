package Tree.medium;
//     230题     二叉搜索树中第k小的元素
public class KthSmallest {


    //层序遍历+大顶堆
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans=new ArrayList<Integer>();
        bfs(root,ans);
        int[] array=ans.stream().mapToInt(Integer::intValue).toArray();
        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            queue.offer(array[i]);
        }
        for(int i=k;i<array.length;i++){
            if(array[i]<queue.peek()){
                queue.poll();
                queue.offer(array[i]);
            }
        }
        return queue.peek();
    }
    public void bfs(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode top=queue.poll();
                ans.add(top.val);
                if(top.left!=null){
                    queue.offer(top.left);
                }
                if(top.right!=null){
                    queue.offer(top.right);
                }
                size--;
            }
        }
    }
}
