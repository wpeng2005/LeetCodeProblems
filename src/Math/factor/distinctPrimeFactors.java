package Math.factor;
//  2521题       数组乘积中的不同质因数数目
public class distinctPrimeFactors {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    set.add(i);
                    while (x % i == 0)
                        x /= i;
                }
            }

            if (x > 1)
                set.add(x);
        }
        return set.size();
    }
}
