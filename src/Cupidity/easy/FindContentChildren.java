package Cupidity.easy;

//LeetCode  455题       分发饼干
public class FindContentChildren {
    //排序+双指针+贪心
    public int findContentChildrenByDoublePointer(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        }
        int slen=s.length;
        int glen=g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        for(int i=0,j=0;i<glen && j<slen;i++,j++){
            while(j<slen && g[i]>s[j]){
                j++;
            }
            if(j<slen){
                ans++;
            }

        }

        return ans;
    }


    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int flag = 0;
        for (int i = 0; i < g.length; i++) {
            if (g[i] <= s[flag]) {
                ans++;
                if (flag == s.length - 1) {
                    return ans;
                }
                flag++;
            } else {
                if (flag == s.length - 1) {
                    return ans;
                }
                while (g[i] > s[flag]) {
                    flag++;
                    if (flag == s.length - 1) {
                        return ans;
                    }
                }
                ans++;
                if (flag == s.length - 1) {
                    return ans;
                }
                flag++;
            }

        }

        return ans;
    }

}
