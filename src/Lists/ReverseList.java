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
//LeetCode第206题
class ReverseList {
    //使用迭代进行列表的翻转
    public ListNode reverseList(ListNode head) {
        //保存前驱节点，如果列表head为空，则前驱节点为null，返回prev等于返回null
        ListNode prev=null;
        //代表当前节点
        ListNode current=head;
        while(current!=null){
            //保存节点，防止反转指针时丢掉后续的节点
            ListNode next=current.next;
            //下面都是进行反转操作，将引用进行反转
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;

    }
}