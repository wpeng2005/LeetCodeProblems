package StackAndQueue;
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

    //使用哈希表+单调栈
    public int[] nextGreaterElementByHashMapAndStack(int[] nums1, int[] nums2) {
        Stack<Integer> aloneStack = new Stack<>();
        Map<Integer, Integer> seenmap = new HashMap<Integer, Integer>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!aloneStack.isEmpty() && num >= aloneStack.peek()) {
                aloneStack.pop();
            }
            seenmap.put(num, aloneStack.isEmpty() ? -1 : aloneStack.peek());
            aloneStack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = seenmap.get(nums1[i]);
        }
        return res;
    }

}

