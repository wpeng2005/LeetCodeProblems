package BitWiseOperation;
//   231题   2的幂
public class isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        for (int i = 0; i < 32; i++) {

            if (1 << i == n) {
                return true;
            }
        }
        return false;
    }
}
