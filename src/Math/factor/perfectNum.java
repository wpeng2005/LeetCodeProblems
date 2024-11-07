package Math.factor;
//   507题  完美数
public class perfectNum {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
                ans.add(i);
                if(i<Math.sqrt(num)){
                    ans.add(num/i);
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).sum()+1==num?true:false;
    }
}
