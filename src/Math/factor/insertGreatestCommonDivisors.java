package Math.factor;
//      2807题    在链表中插入最大公约数
public class insertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode temp=head;
        while(temp.next!=null){
            int insertValue=gcd(temp.val,temp.next.val);
            ListNode gcdnode=new ListNode(insertValue);
            gcdnode.next=temp.next;
            temp.next=gcdnode;
            temp=temp.next.next;
        }
        return head;
    }
    public int gcd(int a,int b){
        while(a!=0){
            int temp=a;
            a=b%a;
            b=temp;
        }
        return b;
    }
}
