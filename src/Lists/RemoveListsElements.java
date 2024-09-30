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
class RemoveListsElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummynode=new ListNode(0);
        dummynode.next=head;
        ListNode temp=dummynode;
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return dummynode.next;

    }
}