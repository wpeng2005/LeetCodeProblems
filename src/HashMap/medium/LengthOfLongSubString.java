package HashMap.medium;

//LeetCode 3题      无重复字符的最长子串
public class LengthOfLongSubString {
   public int lengthOfLongestSubstringBySildeWindow(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Set<Character> occ=new HashSet<Character>();
        int ans=0;

        for(int right=0,left=0;right<s.length();right++){
            while(occ.contains(s.charAt(right))){
                occ.remove(s.charAt(left));
                left++;

            }
            occ.add(s.charAt(right));

            ans=Math.max(ans,right-left+1);
        }
        return ans;

    }

    public int lengthOfLongestSubstring(String s) {
        // 首先检查s是否为null，防止s.length()抛出异常

        if(s.length()==0){
            return 0;
        }

        Set<Character> res = new HashSet<Character>();
        int ans = 0;
        int temp = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.length() - 1 - i < ans) {
                return ans;
            }
            int j = i;
            while(j < s.length() && res.add(s.charAt(j))) {
                temp++;
                j++;
            }
            ans = Math.max(ans, temp);
            temp = 0;
            res.clear();
        }
        return ans;
    }
}
