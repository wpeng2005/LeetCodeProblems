package Math.reminder;
//   2453题   摧毁一系列目标
public class destroyTarget {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        for(int num:nums){
            int reminder=num%space;
            map.putIfAbsent(reminder,new ArrayList<Integer>());
            map.get(reminder).add(num);
        }
        int nummin=-1;
        int max=-1;
        for(int i=0;i<nums.length;i++){
            int index=nums[i]%space;
            List<Integer> curr=map.get(index);
            if(curr.size()==max){
                nummin=Math.min(nummin,nums[i]);
            }
            if(curr.size()>max){
                max=curr.size();
                nummin=nums[i];
            }
        }
        return nummin;
    }
}
