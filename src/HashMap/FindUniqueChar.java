package HashMap;
//LeetCode 387题        寻找字符串中第一个唯一字符
public class FindUniqueChar {
    //这是使用哈希表统计频率
    public int firstUniqChar(String s) {
        Map<Character,Integer> frequency= new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            frequency.put(ch,frequency.getOrDefault(ch,0)+1);
        }
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            if(frequency.get(ch)==1){
                return j;
            }
        }
        return -1;
    }
    //使用数组，时间复杂度更小

    public int firstUniqCharByArray(String s) {
        int[] ans=new int[26];
        for(int i=0;i<s.length();i++){
            ans[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(ans[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;

    }
}
