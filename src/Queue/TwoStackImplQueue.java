package Queue;
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

//LeetCode 232题 用栈实现队列
public class TwoStackImplQueue {
    Stack<Integer> stackin;
    Stack<Integer> stackout;

    public MyQueue() {
        stackin=new Stack<>();
        stackout=new Stack<>();
    }

    public void push(int x) {
        stackin.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stackout.pop();
    }

    public int peek() {
        dumpstackIn();
        return stackout.peek();
    }

    public boolean empty() {
        return stackin.isEmpty() && stackout.isEmpty();
    }
    public void dumpstackIn(){
        if(!stackout.isEmpty()){
            return;
        }
        while(!stackin.isEmpty()){
            stackout.push(stackin.pop());
        }
    }
}
