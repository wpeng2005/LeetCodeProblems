package Array.medium;
//LeetCode  11题     盛水最多的容器
public class MaxArea {
    //双指针
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,area);
            if(height[left]>=height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
