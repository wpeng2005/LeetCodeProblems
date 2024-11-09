package Math.factor;

import java.util.Arrays;

//    1390题   四因数
public class fourFactor {
    //更加简洁的代码
    public int sumFourDivisorsByireate(int[] nums) {
        int sum=0,count=0,arr=0;
        for(int num:nums){
            sum=0;
            count=0;
            for(int i=1;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    sum+=i;
                    count++;
                    if(i<Math.sqrt(num)){
                        sum+=(num/i);
                        count++;
                    }
                }
            }
            if(count==4){
                arr+=sum;
            }
        }
        return arr;
    }
    //用列表进行存储
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public int sumFourDivisors(int[] nums) {
        for(int num:nums){
            getFactor(num,new ArrayList<Integer>());
        }
        int sum=0;
        for(List<Integer> onelist:ans){
            sum+=onelist.stream().mapToInt(Integer::intValue).sum();
        }
        return sum;
    }
    public void getFactor(int num,List<Integer> list){
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                list.add(i);
                if(i<Math.sqrt(num)){
                    list.add(num/i);
                }
            }
        }
        if(list.size()==4){
            ans.add(list);
        }
    }
}
