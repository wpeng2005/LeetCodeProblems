package BackTracking.medium;
//  377题   组合总和4
public class CombinationSumFour {
    //回溯+记忆化
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Map<Integer,Integer> memo = new HashMap<Integer,Integer>();

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] > target) {
            return 0;
        }
        return backtrack(nums, target);
    }

    public int backtrack(int[] nums, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return 1;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int count=0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            path.add(nums[i]);
            count+=backtrack(nums, target - nums[i]);
            path.remove(path.size() - 1);
        }
        memo.put(target,count);
        return count;
    }
    //动态规划
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }

    //从记忆化搜索到递推
    public int combinationSum4(int[] nums, int target) {
        int[] memo=new int[target+1];
        Arrays.fill(memo,-1);
        Arrays.sort(nums);
        return search(target,nums,memo);

    }
    public int search(int target,int[] nums,int[] memo){
        if(target==0){
            return 1;
        }
        if(memo[target]!=-1){
            return memo[target];
        }
        int res=0;
        for(int i=0;i<nums.length && target>=nums[i];i++){
            res+=search(target-nums[i],nums,memo);
        }
        return memo[target]=res;
    }

}
