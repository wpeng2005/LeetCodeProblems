package Math;
//   7题   翻转整数
public class ReverseInt {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        int ans=0;
        while(x!=0){
            int last=x%10;
            x=x/10;
            if(ans>Integer.MAX_VALUE/10 || ans<Integer.MIN_VALUE/10){
                return 0;
            }
            ans=ans*10+last;
        }

        return ans;
    }
}
