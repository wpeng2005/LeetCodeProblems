package Sort;

//LeetCode    88题         合并两个有序数组
public class MergeTwoSortedArray {
    //快速排序
    public void mergeByquicksort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i <= n - 1; i++) {
            nums1[i + m] = nums2[i];
        }
        quicksort(nums1,0,m+n-1);
    }
    public void quicksort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int pivot=partition(nums,left,right);
        quicksort(nums,left,pivot-1);
        quicksort(nums,pivot+1,right);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums,int left,int right){
        int i=left;
        int j=right;
        while(i<j){
            while(i<j && nums[j]>=nums[left]){
                j--;
            }
            while(i<j && nums[i]<=nums[left]){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,i,left);
        return i;
    }

    //归并排序
    public void mergeByMergeSort(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[i+m]=nums2[i];
        }
        mergersort(nums1,0,m+n-1);
    }
    public void mergersort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        mergersort(nums,left,mid);
        mergersort(nums,mid+1,right);
        mergerLeftAndRight(nums,left,mid,right);
    }
    public void mergerLeftAndRight(int[] nums,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right){
            if(nums[i]>=nums[j]){
                temp[k++]=nums[j++];
            }else{
                temp[k++]=nums[i++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=right){
            temp[k++]=nums[j++];
        }
        for(int z=0;z<temp.length;z++){
            nums[left+z]=temp[z];
        }

    }
}
