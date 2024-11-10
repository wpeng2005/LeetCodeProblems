package Math;
//   633题   平方数之和
public class JudgeSquareSum {
    //双指针
    public boolean judgeSquareSumByDoublePointer(int c) {
        long left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            long sum=left*left+right*right;
            if(sum==c){
                return true;
            }else if(sum>c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
    //数论
    public boolean judgeSquareSum(int c) {
        for (int base = 2; base <= Math.sqrt(c); base++) {
            if (c % base != 0) {
                continue;
            }
            int exp = 0;
            while (c % base == 0) {
                c = c / base;
                exp++;
            }
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }
        return c % 4 != 3;
    }
}
