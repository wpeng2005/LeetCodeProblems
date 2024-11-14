package Math.factor;
//   1492题     n的第k个因子
public class KthFactor {
    public int kthFactor(int n, int k) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
                if(count==k){
                    return i;
                }
            }
        }
        return -1;
    }
}
