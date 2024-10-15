package DynamicProgramming.easy;
//LeetCode  119题       杨辉三角||
public class YanghuiTrianglePLus {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> source=new ArrayList<List<Integer>>();
        if(rowIndex==0){
            List<Integer> ans=new ArrayList<Integer>();
            ans.add(1);
            return ans;
        }
        if(rowIndex==1){
            List<Integer> ans=new ArrayList<Integer>();
            ans.add(1);
            ans.add(1);
            return ans;
        }
        List<Integer> temprow=new ArrayList<Integer>();
        temprow.add(1);
        source.add(new ArrayList<>(temprow));
        temprow.clear();
        temprow.add(1);
        temprow.add(1);
        source.add(new ArrayList<>(temprow));
        for(int i=2;i<=rowIndex;i++){
            temprow.clear();
            temprow.add(1);
            List<Integer> prevrow=source.get(i-1);
            for(int j=1;j<i;j++){
                temprow.add(prevrow.get(j-1)+prevrow.get(j));
            }
            temprow.add(1);
            source.add(new ArrayList<>(temprow));
        }
        return source.get(rowIndex);
    }
}
