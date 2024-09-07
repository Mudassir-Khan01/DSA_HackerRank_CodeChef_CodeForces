package Linked_List.Questions;

public class _14RedorderLL {
    Node head;
    Node tail;
    int size;
    _14RedorderLL (){
        this.size=0;
    }
    public void reorder(Node head){
        if(head==null||head.next==null){
            return;
        }
        Node mid=middle(head);
        Node headFirst=head;
        Node headsecond=reverse(mid);
        while(headFirst!=null&&headsecond!=null){
            Node temp=headFirst.next;
            headFirst.next=headsecond;
            headFirst=temp;
            temp=headsecond.next;
            headsecond.next=headFirst;
            headsecond=temp;
        }
        //next of tail to null
        if(headFirst!=null){
            headFirst.next=null;
        }
    }
    public Node reverse(Node head){//ITERATIVE
        if(head==null){
            return head;
        }
        Node prev=null;
       Node present=head;
        Node next=present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        head=prev;
        return head;
    }
    public Node middle(Node head){
      Node s=head;
       Node f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }

    class Node{
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
