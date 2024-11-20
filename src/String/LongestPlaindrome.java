package String;
//LeetCode     409题     最长回文串
public class LongestPlaindrome {
    public int longestPalindrome(String s) {
        int[] array=new int[128];
        for(int i=0;i<s.length();i++){
            array[s.charAt(i)]++;
        }
        int count=0;
        for(int num:array){
            count+=num%2;
        }
        return count>=1?s.length()-count+1:s.length();
    }
}
