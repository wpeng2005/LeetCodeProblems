package Stack.monotnoicStacks;
//   42题   接雨水
public class catchRainWater {
    //单调栈
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int ans=0;
        Deque<Integer> stack=new ArrayDeque<Integer>();
        stack.push(0);
        for(int i=1;i<height.length;i++){
            if(height[i]<height[stack.peek()]){
                stack.push(i);
            }else if(height[i]==height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                int heightAti=height[i];
                while(!stack.isEmpty() && (height[i]>height[stack.peek()])){
                    int mid=stack.pop();
                    if(!stack.isEmpty()){
                        int h=Math.min(heightAti,height[stack.peek()])-height[mid];
                        int weight=i-stack.peek()-1;
                        int hold=h*weight;
                        if(hold>0){
                            ans+=hold;
                        }
                    }

                }
                stack.push(i);
            }
        }
        return ans;
    }

        //双指针+前缀和
        public int trapByDoublePointer(int[] height) {
            int left=0;
            int right=height.length-1;
            int preMax=0;
            int sufMax=0;
            int ans=0;
            while(left<right){
                preMax=Math.max(preMax,height[left]);
                sufMax=Math.max(sufMax,height[right]);
                ans+=preMax<sufMax?preMax-height[left++]:sufMax-height[right--];
            }
            return ans;
        }

}
