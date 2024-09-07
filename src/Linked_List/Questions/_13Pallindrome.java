package Linked_List.Questions;

public class _13Pallindrome {
    Node head;
    Node tail;
    int size;
    public _13Pallindrome(){
        this.size=0;
    }
    public boolean isPallindrome(Node head){
        Node mid=middle(head);
        Node headsecond=reverse(mid);
        Node rereverse=headsecond;//store it as we need to re-reverse it
        //compare both the halfs
        while(head!=null&&headsecond!=null){
            if(head.val!=headsecond.val){
                break;
            }
            head=head.next;
            headsecond=headsecond.next;
        }
        reverse(rereverse);//rereversing the list
        if(head==null||headsecond==null){//if we are able to go through it means true
           return true;
        }
        return false;
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
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }
}
