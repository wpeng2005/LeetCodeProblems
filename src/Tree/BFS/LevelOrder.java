package Tree.BFS;
//LeetCode   102题    二叉树的层序遍历
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                temp.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }

                if (top.right != null) {
                    queue.offer(top.right);

                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
