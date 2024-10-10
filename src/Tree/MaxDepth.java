package Tree;

//LeetCode 104题        二叉树最大深度
public class MaxDepth {
    //深度优先搜索，时间复杂度为O(n),空间复杂度为O(height)
    public int maxDepthByDFS(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=Math.max(maxDepth(root.left),maxDepth(root.right));

        return  depth+1;

    }
    //广度优先搜索，时间复杂度为O(n),最坏情况下空间复杂度为O(n)
    public int maxDepthByBFS(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int ans=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode popnode=queue.poll();
                if(popnode.left!=null){
                    queue.offer(popnode.left);
                }
                if(popnode.right!=null){
                    queue.offer(popnode.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
