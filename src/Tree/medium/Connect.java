package Tree.medium;
//      116题    填充每个节点的下一个右侧节点指针
public class Connect {
    //使用已经建立的next指针
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node leftmost=root;
        while(leftmost.left!=null){
            Node head=leftmost;
            while(head!=null){
                head.left.next=head.right;
                if(head.next!=null){
                    head.right.next=head.next.left;
                }
                head=head.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }
    //层序遍历
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> stk=new LinkedList<Node>();
        stk.add(root);
        while(!stk.isEmpty()){
            int size=stk.size();
            for(int i=0;i<size;i++){
                Node top=stk.poll();
                if(i<size-1){
                    top.next=stk.peek();
                }
                if(top.left!=null){
                    stk.add(top.left);
                }
                if(top.right!=null){
                    stk.add(top.right);
                }
            }
        }
        return root;
    }
}
