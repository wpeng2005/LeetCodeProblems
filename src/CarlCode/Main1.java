package CarlCode;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int ans=a+b;
            System.out.println(ans);
        }
    }
}
