package STack;

public class customImple {
    protected int[]data;
    private static final int Default_Size=10;
    int ptr=-1;
    public customImple(){//if nothing is passed
        this(Default_Size);//calling constructor ...call below const with size as default size
    }
    public customImple(int size){
        this.data=new int [size];//if size has been passed use this size
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int pop()throws Exception{
        if(isEmpty()){
            throw new Exception("cannot pop from empty stack");
        }
        int remove=data[ptr];
        ptr--;
        return remove;//ot just return data[ptr--]
    }
    public int peek()throws Exception{//what is at the top doesnt remove it
        if(isEmpty()){
            throw new Exception("cannot peek from empty stack");
        }
        int val=data[ptr];
        return val;//or just return data[ptr]
    }
    public boolean isFull() {
        if (ptr == data.length - 1) {//if it is at last index
            return true;
        } else {
            return false;
        }
    }
    public boolean isEmpty() {
        if (ptr ==  - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        customImple stack=new customImple(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
