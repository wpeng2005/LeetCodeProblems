package Lists;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//LeetCode 第141题
public class LinkedLists {
    //该方法是使用快慢指针求解该问题，是龟兔赛跑的思想。使用快指针和慢指针，
    // 慢指针往前前进一步，快指针往前前进两步，如果存在环形链表，那必然会有快指针套了慢指针一圈从而相遇
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;

    }

    //该方法是使用hashSet
    public boolean hashSet(ListNode head) {
        Set<ListNode> seen=new HashSet<ListNode>();
        while(head!=null){
            if(!seen.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}