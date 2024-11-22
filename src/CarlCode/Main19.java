package CarlCode;

import java.util.Scanner;

public class Main19 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int nodenums=sc.nextInt();
            if(nodenums==0){
                System.out.println("list is empty");
                continue;
            }
            ListNode head=new ListNode(sc.nextInt());
            ListNode currenthead=head;
            ListNode printNode=head;
            for(int i=1;i<nodenums;i++){
                int currentval=sc.nextInt();
                currenthead.next=new ListNode(currentval);
               currenthead=currenthead.next;
            }
            while(printNode!=null){
                System.out.print(printNode.val+" ");
                printNode=printNode.next;
            }
            System.out.println("");
            ListNode pre=null;
            ListNode current=head;
            while(current!=null){
                ListNode temp=current.next;
                current.next=pre;
                pre=current;
                current=temp;
            }
            while(pre!=null){
                System.out.print(pre.val+" ");
                pre=pre.next;
            }
            System.out.println("");
        }
    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}
