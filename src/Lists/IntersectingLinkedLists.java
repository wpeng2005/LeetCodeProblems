package Lists;

//LeetCode 160题 相交链表
public class IntersectingLinkedLists {
    public ListNode getIntersectionNodeByHashSet(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA=headA;
        ListNode currentB=headB;
        int lenA=0;
        int lenB=0;
        while(currentA!=null){
            lenA++;
            currentA=currentA.next;
        }
        while(currentB!=null){
            lenB++;
            currentB=currentB.next;
        }
        currentA=headA;
        currentB=headB;
        if(lenB>lenA){
            int temp=lenA;
            lenA=lenB;
            lenB=temp;
            ListNode tempNode=currentA;
            currentA=currentB;
            currentB=tempNode;
        }
        int gap=lenA-lenB;
        while(gap-- > 0){
            currentA=currentA.next;
        }
        while(currentA!=null && currentB!=null){
            if(currentA==currentB){
                return currentA;
            }
            currentA=currentA.next;
            currentB=currentB.next;
        }
        return null;

    }
}
