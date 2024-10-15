package HashMap.easy;
//LeetCode  349题    两个数组的交集
public class TwoArraysInterSection {


    public int[] intersectionByHashSet(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<Integer>();
        Set<Integer> ans=new HashSet<Integer>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }



    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<Integer>();
        Set<Integer> countnums=new HashSet<Integer>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                countnums.add(num);
            }
        }
        return countnums.stream().mapToInt(Integer::valueOf).toArray();

    }
}
