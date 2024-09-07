package Question_queue_Stack;

import java.util.Stack;

//this is delete Efficient
public class _1QueueUsingStack2 {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public _1QueueUsingStack2(){
        first=new Stack<>();
        second=new Stack<>();
    }
    public void add(int item)throws Exception{
        while(!first.isEmpty()){
    second.push(first.pop());
}
    first.push(item);
     while(!second.isEmpty()){
    first.push(second.pop());
}
    }
    public int delete(){
        return first.pop();
    }
    public int peek(){
        return first.peek();
    }
}
