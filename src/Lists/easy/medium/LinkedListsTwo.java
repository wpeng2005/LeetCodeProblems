package Lists.easy.medium;
//    142题    环形链表
public class LinkedListsTwo {
    //快慢指针
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode pre=head;
                while(pre!=slow){
                    pre=pre.next;
                    slow=slow.next;
                }
                return pre;
            }
        }
        return null;
    }
    //使用HashSet去重
    public ListNode detectCycleByHashSet(ListNode head) {
        if(head==null || head.next == null){
            return null;
        }
        Set<ListNode> set=new HashSet<ListNode>();
        ListNode pos=head;
        while(pos!=null){
            if(set.contains(pos)){
                return pos;
            }else{
                set.add(pos);
            }
            pos=pos.next;
        }
        return pos;
    }
}
