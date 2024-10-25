package DynamicProgramming.medium;

//  5题      最长回文子串
public class LongestPlaindrome {
    //中心扩散思想
    public String longestPalindromeByPointer(String s) {
        int n = s.length();
        int len = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > len) {
                len = r - l - 1;
                res = s.substring(l + 1, r);
            }
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                l = i;
                r = i + 1;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                if (r - l - 1 > len) {
                    len = r - l - 1;
                    res = s.substring(l + 1, r);
                }
            }
        }
        return res;
    }
    public String longestPalindromeMoreSimple(String s) {
        int len = s.length();
        int left = 0, right = 0, res = 0;// 记录左右边界和右-左的长度
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {// j=i这步就将每个单个字符dp赋为了true
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {// 如果j - i <= 1，必是回文串
                    dp[i][j] = true;
                    if (j - i > res) {
                        res = j - i;// res记得也得更新！
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);// 左闭右开
    }
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxlen = 1;
            int beign = 0;
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            char[] chararay = s.toCharArray();
            for (int L = 2; L <= len; L++) {
                for (int i = 0; i < len; i++) {
                    int j = i + L - 1;
                    if (j >= len) {
                        break;
                    }
                    if (chararay[i] != chararay[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if(dp[i][j] && j-i+1>maxlen){
                        maxlen=j-i+1;
                        beign=i;
                    }
                }
            }
            return s.substring(beign,beign+maxlen);
        }
    }
}
