package Cupidity.medium;
//   17题  电话号码的字母组合
public class LetterCombination {
    //回溯
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<String>();
        if(digits.length()==0){
            return ans;
        }
        Map<Character,String> map=new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuffer sb=new StringBuffer();
        backtrack(ans,map,digits,0,sb);
        return ans;

    }
    public void backtrack( List<String> ans,Map<Character,String> map,String digits,int index,StringBuffer sb){
        if(index==digits.length()){
            ans.add(sb.toString());
        }else{
            char digit=digits.charAt(index);
            String digitValue=map.get(digit);
            for(int i=0;i<digitValue.length();i++){
                sb.append(digitValue.charAt(i));
                backtrack(ans,map,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
