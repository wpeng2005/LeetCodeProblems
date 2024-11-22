package CarlCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main26 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int strnum=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<strnum;i++){
            String str=sc.nextLine();
            int keyCount=0;
            Map<Character,Integer> map=new HashMap<Character,Integer>();
            for(char ch:str.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==1){
                    keyCount++;
                }
            }
            System.out.println(operationCount(map,keyCount));
        }
    }
    public  static int operationCount(Map<Character,Integer> map,Integer keyCount){
        int ans=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int count=entry.getValue();
            while(count>1){
                if(keyCount<26){
                    count-=2;
                    if(count>0){
                        keyCount++;
                    }
                }else{
                    count--;
                }
                ans++;
            }
        }
        return ans;
    }
}
