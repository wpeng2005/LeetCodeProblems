package CarlCode;

import java.util.Scanner;
public class Main6{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            for(int i=0;i<num;i++){
                int total=sc.nextInt();
                int sum=0;
                for(int j=0;j<total;j++){
                    int a=sc.nextInt();
                    sum+=a;

                }
                if(i==num-1){
                    System.out.println(sum);
                    continue;
                }
                System.out.println(sum+"\n");
            }
        }
    }
}