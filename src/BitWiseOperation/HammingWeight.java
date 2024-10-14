package BitWiseOperation;

//LeeCode      191题      位1的个数
public class HammingWeight {
    //二进制按位与
    public int hammingWeight(int n) {
        int ans=0;
        for(int i=0;i<32;i++){
            //只要有一位是0，结果就是0。
            if((n & (1 << i))!=0){
                ans++;
            }
        }
        return ans;
    }
}
