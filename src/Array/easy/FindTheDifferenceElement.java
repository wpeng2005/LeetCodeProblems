package Array.easy;
//LeetCode  389题        找不同
public class FindTheDifferenceElement {

    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        char[] sarray = s.toCharArray();
        Arrays.sort(sarray);
        char[] tarray = t.toCharArray();
        Arrays.sort(tarray);
        for (int i = 0; i < s.length(); i++) {
            if (sarray[i] != tarray[i]) {
                return tarray[i];
            }
            if (i == s.length() - 1) {
                return tarray[t.length() - 1];
            }
        }
        return 'a';
    }

    }
