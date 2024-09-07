package QUEUE;

public class customQueue {
    private int []data;
    private static final int Default_Size=10;
    int end=0;
    public customQueue(){
        this(Default_Size);
    }
    public customQueue(int size){
        this.data=new int[size];
    }
    public boolean isFull(){
        return end==data.length;
    }
    public boolean isEmpty(){
        return end==0;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end]=item;
        end++;
        return true;
    }
    public int delete()throws Exception{
        if(isEmpty()){
            throw new Exception("Queeue is Empty");
        }
        int removed=data[0];
        //now shift the element leftward
        for(int i=1;i<end;i++){
            data[i-1]=data[i]; //data of prev one is equal to next one
        }
        end--;
        return removed;
    }
    public int fronnt()throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");

        }
        return data[0];
    }
    public void display(){
        for(int i=0;i<end;i++){
            System.out.print(data[i]+"<-");
        }
        System.out.println("End");
    }

    public static void main(String[] args) throws Exception{
        customQueue queue=new customQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.display();
        queue.delete();
        queue.delete();
        queue.display();
    }
}
