package HashMap;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词


//LeetCode 242题
public class AlphabeticHeterogeneous {
    //本题是使用哈希表的方法，通过比较字符的数量大小来进行比较判断
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> table=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //table.getOrDefault(ch,0)代表从table中获取ch的数量，如果ch不存在则默认赋值1
            table.put(ch,table.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            table.put(ch,table.getOrDefault(ch,0)-1);
            if(table.get(ch)<0){
                return false;
            }
        }
        return true;
    }

    //通过将字符串转换成字符串数组，然后通过原生的sort函数进行排序，再通过原生的比较函数比较
    public boolean isAnagramByArraySort(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sarray=s.toCharArray();
        char[] tarray=t.toCharArray();
        Arrays.sort(sarray);
        Arrays.sort(tarray);
        return Arrays.equals(sarray,tarray);
    }
}
