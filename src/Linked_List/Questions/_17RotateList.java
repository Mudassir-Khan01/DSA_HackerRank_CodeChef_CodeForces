package Linked_List.Questions;

public class _17RotateList {
    Node head;
    public Node roatte(Node head,int k){
        if(k<=0||head==null||head.next==null){
            return head;
        }
        Node last=head;
        int length=1;
        while(last.next!=null){//to get the last node
            last=last.next;
            length++;
        }
        last.next=head;
        //now roattaion
        int rotation =k%length;
        Node newLast= head;
        int skip=length-rotation;
        for(int i=0;i<skip-1;i++){
          newLast=newLast.next;
        }
        head=newLast.next;
        newLast.next=null;
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
}
