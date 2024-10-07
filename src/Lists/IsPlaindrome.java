package Lists;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//LeetCode  234题 回文链表
public class IsPlaindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode secondNode=halfNode(head);
        ListNode reverNode=reverseList(secondNode.next);

        ListNode p1=head;
        ListNode p2=reverNode;
        boolean result=true;
        while(result && p2!=null){
            if(p1.val!=p2.val){
                result=false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        secondNode.next=reverseList(reverNode);
        return result;


    }
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        return prev;
    }
    public ListNode halfNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
