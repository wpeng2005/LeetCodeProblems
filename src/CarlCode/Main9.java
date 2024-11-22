package CarlCode;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            int ans=0;
            while(num!=0){
                int alone=num%10;
                if(alone%2==0){
                    ans+=alone;
                }
                num=num/10;
            }
            System.out.println(ans+"\n");

        }
    }
}
