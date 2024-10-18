package Tree.BFS;
//      107题        二叉树的层序遍历||
public class LevelOrderTwo {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<List<Integer>> newans = new ArrayList<List<Integer>>();
        levelOrder(root,ans);
        Collections.reverse(ans);
        return ans;

    }

    public void levelOrder(TreeNode root, List<List<Integer>> ans) {
        if(root == null){
            return;
        }
        Queue<TreeNode> stk = new LinkedList<TreeNode>();
        stk.offer(root);
        while (!stk.isEmpty()) {
            int size = stk.size();
            List<Integer> res = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode top = stk.poll();
                res.add(top.val);
                if (top.left != null) {
                    stk.offer(top.left);
                }
                if (top.right != null) {
                    stk.offer(top.right);
                }

                size--;
            }
            ans.add(res);
        }
    }
}
