package Math.factor;
//   1362题   最接近的因数
public class closestFactor {
    //不断更新两个因数
    public int[] closestDivisorsByIterate(int num) {
        int[] arr1=process(num+1);
        int[] arr2=process(num+2);
        return arr1[1]-arr1[0]<arr2[1]-arr2[0]?arr1:arr2;
    }
    int[] process(int num){
        int i=1;
        int p=0,q=0;
        while(i*i<=num){
            if(num%i==0){
                p=i;
                q=num/i;
            }
            i++;
        }
        return new int[]{p,q};
    }


    //复杂的方法
    public int[] closestDivisors(int num) {
        int[] arr1=getFactor(num+1,new ArrayList<Integer>());
        int[] arr2=getFactor(num+2,new ArrayList<Integer>());
        int ans1=Math.abs(arr1[0]-arr1[1]);
        int ans2=Math.abs(arr2[0]-arr2[1]);
        return ans1<=ans2?arr1:arr2;
    }
    public int[] getFactor(int num,List<Integer> ans){
        for(int i=;i<=Math.sqrt(num);i++){
            if(num%i==0){
                ans.add(i);
                if(i<=Math.sqrt(num)){
                    ans.add(num/i);
                }
            }
        }
        return ans.subList(ans.size()-2,ans.size()).stream().mapToInt(Integer::intValue).toArray();
    }
}
