package DynamicProgramming.medium;
//  152题   乘积最大的子数组
public class maxProduct {

    public int maxProductByDP(int[] nums) {
        int len=nums.length;
        long[] maxF=new long[len];
        long[] minF=new long[len];
        for(int i=0;i<len;i++){
            maxF[i]=nums[i];
            minF[i]=nums[i];
        }
        for(int i=1;i<len;i++){
            maxF[i]=Math.max(maxF[i-1]*nums[i],Math.max(minF[i-1]*nums[i],nums[i]));
            minF[i]=Math.min(minF[i-1]*nums[i],Math.min(maxF[i-1]*nums[i],nums[i]));
            if(minF[i]<(-1<<31)){
                minF[i]=nums[i];
            }
        }
        int ans=(int)maxF[0];
        for(int i=0;i<len;i++){
            ans=Math.max(ans,(int)maxF[i]);
        }
        return ans;
    }
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            left *= nums[i];
            max = Math.max(max, left);
            left = left == 0 ? 1 : left;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right *= nums[i];
            max = Math.max(max, right);
            right = right == 0 ? 1 : right;
        }
        return max;
    }
}
