package Cupidity.medium;
//      134题      加油站
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int left = 0, right = 0;
        int rest = 0;

        while (right - left < n) {
            rest += gas[right % n] - cost[right % n];
            ++right;

            while (rest < 0 && left < n - 1) {
                rest -= gas[left] - cost[left];
                ++left;
            }

            if (rest < 0) return -1;
        }

        return left;
    }
}
