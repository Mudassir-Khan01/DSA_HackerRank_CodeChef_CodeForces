package Linked_List.Questions;

public class _10_11_12reverse {
    Node head;
    Node tail;
    int size;

    public _10_11_12reverse() {
        this.size = 0;
    }
//program 1
    private void reverse(Node node){//RECURSION
        if(node==tail){//base condition
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    //Program 2
   public void reverse(){//ITERATIVE
        if(size<2){
            return;
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
    }

    //Program 3
    public Node reversebetween(Node head,int left,int right){
        if(left==right){
            return head ;
        }
        //skip the first left-1 nodes
        Node current=head;
        Node prev=null;
        for(int i =0;current!=null&&i<left-1;i++){
            prev=current;
            current=current.next;
        }
        Node last=prev;//its the node just behing left
        Node newEnd=current;//its the node to which left is pointing
        //reverse betweem left and right
        Node next =current.next;
        for (int i=0;current!=null&&i<right-left+1;i++) {

                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = prev;//after reversing here node behind prev is last
            } else {
                head = prev;//no node behind prev so make it head
            }
            newEnd.next=current;//new end became last after reversing and after that node is current so point it to it
            return head;
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

    public static void main(String[] args) {
_10_11_12reverse list=new _10_11_12reverse();
    }
    }

