package DoublePointer;
//    14题      最长公共前缀
public class LongestCommonPrefix {
    //分治（执行时间更少）
    public String longestCommonPrefixByParaition(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }else{
            return longestCommonPrefix(strs,0,strs.length-1);
        }
    }
    public String longestCommonPrefix(String[] strs,int start,int end){
        if(start==end){
            return strs[start];
        }else{
            int mid=start+(end-start)/2;
            String leftcommon=longestCommonPrefix(strs,start,mid);
            String rightcommon=longestCommonPrefix(strs,mid+1,end);
            return commonPrefix(leftcommon,rightcommon);
        }
    }
    public String commonPrefix(String leftcommon,String rightcommon){
        int minLength=Math.min(leftcommon.length(),rightcommon.length());
        for(int i=0;i<minLength;i++){
            if(leftcommon.charAt(i)!=rightcommon.charAt(i)){
                return leftcommon.substring(0,i);
            }
        }
        return leftcommon.substring(0,minLength);
    }
    //双指针
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 检查是否有空字符串
        for (String str : strs) {
            if (str.isEmpty()) {
                return "";
            }
        }
        int len=strs.length;
        int ans=strs[0].length();
        for(int i=1;i<len;i++){
            int left=0;
            int right=0;
            if(strs[0].charAt(left)!=strs[i].charAt(right)){
                return "";
            }
            while(left<strs[0].length()&&right<strs[i].length()&&strs[0].charAt(left)==strs[i].charAt(right)){
                left++;
                right++;

            }
            ans=Math.min(ans,left);
        }
        return strs[0].substring(0,ans);
    }
}
