package Tree.DFS;
//      113题       路径总和||
public class PathSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, ans, path, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;

        path.add(root.val);
        if (targetSum == 0 && root.right == null && root.left == null) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, ans, path, targetSum);
        dfs(root.right, ans, path, targetSum);
        path.remove(path.size() - 1);

    }
}
