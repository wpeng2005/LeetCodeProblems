package CarlCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int line=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<line;i++){
            String str=sc.nextLine();
            System.out.println(getMaxLength(str));
        }

    }
    public  static  int getMaxLength(String str){
        str=str.substring(1,str.length()-1);
        String[] strArray=str.split(",");
        int[] nums=new int[strArray.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(strArray[i].trim());
        }
        List<Integer> tails=new ArrayList<>();
        for(int num:nums){
            int left=0;
            int right=tails.size()-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(tails.get(mid)>=num){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            if(left<tails.size()-1){
                tails.set(left,num);
            }else{
                tails.add(num);
            }
        }
        return tails.size();
    }

}
