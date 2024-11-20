package HashMap.medium;
// 128题     最长连续序列
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            int current = num;
            if (!set.contains(num - 1)) {
                while (set.contains(current + 1)) {
                    current += 1;
                }
            }
            ans = Math.max(current - num + 1, ans);
        }
        return ans;
    }
}
