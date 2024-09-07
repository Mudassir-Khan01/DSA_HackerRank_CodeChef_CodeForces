package QUEUE;

public class circularQueue {
    protected int []data;
    private static final int Default_Size=10;
   protected int end=0;
    protected int front=0;
    private int size=0;
    public circularQueue(){
        this(Default_Size);
    }
    public circularQueue(int size){
        this.data=new int[size];
    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end]=item;
        end++;
        end=end%data.length;
        size++;
        return true;
    }
    public int delete()throws Exception{
        if(isEmpty()){
            throw new Exception("Queeue is Empty");
        }
        int removed=data[front];
        front++;
        front=front%data.length;
        size--;
        return removed;
    }
    public int fronnt()throws Exception{
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];
        }

        public void display(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
            int i=front;
            do{//initially both front and end both are zero
                System.out.print(data[i]+"->");
                i++;
                i=i%data.length;
            }while (i!=end);
            System.out.println("End");
        }


    public static void main(String[] args)throws Exception {
        circularQueue queue=new circularQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.display();
        queue.delete();
        queue.display();
        queue.insert(6);
        queue.display();
    }
}
