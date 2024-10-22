package Search.BinarySearch;
//   74题   搜索二维矩阵
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int x=matrix[mid/n][mid%n];
            if(x<target){
                low=mid+1;
            }else if(x>target){
                high=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
