package Linked_List.Questions;

public class _8MiddleLL {
    public Node middle(Node head){
    Node s=head;
    Node f=head;
    while(f!=null&&f.next!=null){
        s=s.next;
        f=f.next.next;
    }
    return s;
    }
    private class Node{
        int val;
        Node next;
        Node(){}
        Node(int val){
            this.val=val;
        }
        Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
}
