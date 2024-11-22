package CarlCode;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int num= sc.nextInt();
            if(num==0){
                break;
            }
            int[] array=new int[num];
            int sum=0;
            for(int i=0;i<array.length;i++){
                array[i]=sc.nextInt();
                sum+=array[i];
            }
            int average=sum/num;
            int step=0;
            for(int test:array){
                step+=Math.abs(test-average);
            }
            System.out.println(step/2);
            System.out.println();
        }
    }
}
