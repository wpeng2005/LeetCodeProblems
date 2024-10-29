package BitWiseOperation;
//   371题       两整数之和
public class GetSum {
    public int getSum(int a, int b) {
        while(b!=0){
            int carray=(a&b)<<1;
            a=a^b;
            b=carray;
        }
        return a;
    }
}
