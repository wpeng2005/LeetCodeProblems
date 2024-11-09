package Math.commonMultiple;
//  2413题   最小偶倍数
public class smallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        int thegcd=gcd(2,n);
        return Math.abs(2*n)/thegcd;
    }
    public int gcd(int a,int b){
        return a==0?b:gcd(b%a,a);
    }

}
