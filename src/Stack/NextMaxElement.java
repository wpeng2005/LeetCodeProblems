package Stack;
//LeetCode 496题  下一个最大元素
public class NextMaxElement {
    //暴力求解，时间复杂度为O(n2)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int j=0;
            while(j<n && nums1[i]!=nums2[j]){
                j++;
            }
            int k=j+1;
            while(k<n && nums1[i]>nums2[k]){
                k++;
            }
            res[i]=k<n?nums2[k]:-1;
        }
        return res;
    }

}

