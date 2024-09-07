package Linked_List.Singly_Linked_List;

public class Ins_Del {
    private Node head;
    private Node tail;
    private int size;
    public Ins_Del(){
        this.size=0;
    }
    public void insertionFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;

        }
        size+=1;
    }
    public void insertlast(int value){
        if(tail==null){
            insertionFirst(value);//if nothing is there so first create it
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    public void insertparticular(int value,int index){
        if(index==0){
            insertionFirst(value);
            return;
        }
        if(index==size){
            insertlast(value);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){//for traversing till index se ek phele
            temp=temp.next;
        }
        Node node=new Node(value,temp.next);//2nd const in Node
        // node.next=temp.next; this is done already above in constructor
        temp.next=node;
        size++;
    }
    public int deleteFirst(){
        int value=head.value;//to store the deleted value
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }
    public Node get(int index){//gives the reference pointer at that node
        Node node = head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();//just one item to delete
        }
        Node secondLast=get(size-2);
        int value= tail.value;
        tail=secondLast;
        tail.next=null;
        return value;
    }
    public int deleteparticular(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);//index se phele wale node pe jao
        int value= prev.next.value;
        prev.next=prev.next.next;
        return value;
    }
    public Node find(int value){//find the value in the node
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;//if not found return null
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("End");
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
        public Node(int value ,Node next){
            this.value=value;
            this.next=next;
        }

    }
}
