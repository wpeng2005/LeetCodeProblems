package BackTracking.medium;
//  39题   组合总和
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> path=new ArrayList<Integer>();
        backtrack(candidates,target,ans,path,0);
        return ans;
    }
    public void backtrack(int[] candidates,int target,List<List<Integer>> ans,List<Integer> path,int index){
        if(target<0 || index>=candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            backtrack(candidates,target-candidates[i],ans,path,i);
            path.remove(path.size()-1);
        }

    }
}
