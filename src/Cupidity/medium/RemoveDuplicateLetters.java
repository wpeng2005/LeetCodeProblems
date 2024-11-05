package Cupidity.medium;
//   316题   去除重复字母
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] lastindex=new int[26];
        boolean[] visited=new boolean[26];
        for(int i=0;i<s.length();i++){
            lastindex[s.charAt(i)-'a']=i;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(visited[s.charAt(i)-'a']){
                continue;
            }
            while(sb.length()>0 && s.charAt(i)<sb.charAt(sb.length()-1) && lastindex[sb.charAt(sb.length()-1)-'a']>i ){
                visited[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(s.charAt(i));
            visited[s.charAt(i)-'a']=true;
        }
        return sb.toString();
    }
}
