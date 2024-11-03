package Lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int nodenum=scan.nextInt();
        List<List<Integer>> queue=new ArrayList<List<Integer>>();

        int times=0;
        for(int i=0;i<nodenum;i++){
            queue.add(new ArrayList<>());
        }
        while(scan.hasNext()){
            String command=scan.next();
            if(command.equals("add")){
                int num=scan.nextInt();
                queue.get(0).add(num);
            } else if (command.equals("sync")) {
                int syncnum=scan.nextInt();
                int addindex=queue.get(syncnum).size()+1;
                queue.get(syncnum).add(queue.get(0).get(addindex));
            }else{
                int min_count=Integer.MAX_VALUE;
                for(int i=0;i<nodenum;i++){
                    if(queue.get(i).size()<min_count){
                        min_count=queue.get(i).size();
                    }
                }
                System.out.println(min_count);
            }
        }

        scan.close();
    }
}
