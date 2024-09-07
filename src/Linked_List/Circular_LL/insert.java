package Linked_List.Circular_LL;

public class insert {
    private Node head;
    private Node tail;
    public insert(){
        this.head=null;
        this.tail=null;
    }
    public void insertt(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            tail=node;
            return;
        }
        node.next=head;
        tail.next=node;
        tail=node;
    }
    public void delete(int val){
Node node=head;
if(node==null){
    return;
}
if(node.value==val){//if head wala he hatana hua
   head=head.next;
   tail.next=head;
   return;
}
do{
    Node n=node.next;
    if(n.value==val){
       node.next=n.next;
       break;
    }
    node=node.next;
}while(node!=head);
    }
    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + "->");
                temp = temp.next;
            } while (temp!= head);
            System.out.println("End");
        }
    }

    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
}
