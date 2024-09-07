package Question_queue_Stack;

import java.util.Stack;
//THIS IS ADD EFFICIENT
public class _1QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public _1QueueUsingStack(){
        first=new Stack<>();
        second=new Stack<>();
    }

    public void add(int item){
        first.push(item);
    }
    public int remove()throws Exception{
        while(!first.isEmpty()){
            int popped= first.pop();
            second.push(popped);
        }
        int removed= second.pop();
        while(!second.isEmpty()){//pushing elements back to first stack
            first.push(second.pop());
        }
        return removed;
    }
//in question it has asked to create for add delete  isempty and peek
    public boolean isEmpty(){
        return first.isEmpty();//since first is considered as the main one
    }
    public int peek()throws Exception{
        while(!first.isEmpty()){
            int popped= first.pop();
            second.push(popped);
        }
        int peeked= second.peek();
        while(!second.isEmpty()){//pushing elements back to first stack
            first.push(second.pop());
        }
        return peeked;
    }

    public static void main(String[] args)throws Exception {
        _1QueueUsingStack queue=new _1QueueUsingStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.remove());

    }

}
