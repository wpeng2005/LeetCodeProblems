package DynamicProgramming;

//LeetCode      118题
public class YanghuiTriangle {
        //空间优化后的动态规划
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();

            // 处理特殊情况：如果只有一行或两行
            if (numRows == 1) {
                List<Integer> firstRow = new ArrayList<>();
                firstRow.add(1);
                ans.add(firstRow);
                return ans;
            } else if (numRows == 2) {
                List<Integer> firstRow = new ArrayList<>();
                firstRow.add(1);
                ans.add(firstRow);

                List<Integer> secondRow = new ArrayList<>();
                secondRow.add(1);
                secondRow.add(1);
                ans.add(secondRow);
                return ans;
            }

            // 添加第一行
            List<Integer> min = new ArrayList<>();
            min.add(1);
            ans.add(new ArrayList<>(min));

            // 添加第二行
            min.clear();
            min.add(1);
            min.add(1);
            ans.add(new ArrayList<>(min));

            // 从第三行开始计算
            for (int i = 2; i < numRows; i++) {
                min.clear();  // 清空min
                min.add(1);   // 每行开头是1
                List<Integer> prevRow = ans.get(i - 1);  // 获取上一行
                for (int j = 1; j < i; j++) {
                    min.add(prevRow.get(j - 1) + prevRow.get(j));  // 当前元素是上一行的两个元素之和
                }
                min.add(1);   // 每行末尾是1
                ans.add(new ArrayList<>(min));  // 添加该行的副本
            }

            return ans;
        }

    //普通动态规划
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(numRows==1){
            List<Integer> firstrow=new ArrayList<Integer>();
            firstrow.add(1);
            ans.add(firstrow);
            return ans;
        }
        if(numRows==2){
            List<Integer> firstrow=new ArrayList<Integer>();
            firstrow.add(1);
            ans.add(firstrow);
            List<Integer> secondrow=new ArrayList<Integer>();
            secondrow.add(1);
            secondrow.add(1);
            ans.add(secondrow);
            return ans;
        }
        int[][] dp=new int[numRows+1][numRows+1];
        for(int i=1;i<=numRows;i++){
            int j=i;
            dp[i][j]=1;
        }
        for(int i=1;i<=numRows;i++){
            dp[i][1]=1;
        }
        List<Integer> firstrow=new ArrayList<Integer>();
        firstrow.add(1);
        ans.add(firstrow);
        List<Integer> secondrow=new ArrayList<Integer>();
        secondrow.add(1);
        secondrow.add(1);
        ans.add(secondrow);
        for(int i=3;i<=numRows;i++){
            List<Integer> currentrow=new ArrayList<Integer>();
            currentrow.add(1);
            for(int j=2;j<=i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                currentrow.add(dp[i][j]);
            }
            ans.add(currentrow);
        }
        return ans;
    }

}
