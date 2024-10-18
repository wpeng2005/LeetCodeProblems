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



    //定义BFS函数
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }

    public void bfs(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);

        while (!temp.isEmpty()) {
            int size = temp.size();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) { // 改为从0到size的循环
                TreeNode top = temp.poll();
                arr.add(top.val);

                // 注意这里要使用 top 而不是 root
                if (top.left != null) {
                    temp.offer(top.left);
                }
                if (top.right != null) {
                    temp.offer(top.right);
                }
            }
            ans.add(new ArrayList<>(arr)); // 将当前层的结果添加到答案中
        }
    }
}
