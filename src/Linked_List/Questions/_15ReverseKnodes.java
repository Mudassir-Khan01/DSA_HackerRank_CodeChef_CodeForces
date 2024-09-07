package Linked_List.Questions;

public class _15ReverseKnodes {
    Node head;

    public Node reverseK(Node head,int k){
        if(k<=1||head==null){
            return head;
        }
      Node current=head;
        Node prev=null;
        while(current!=null) {

            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {

                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;
            //skip the k nodes
            for (int i=0;current!=null&&i<k;i++){
                prev=current;
                current=current.next;
            }
            prev=newEnd;
        }
        return head;
    }

    public Node reverseAlternateK(Node head,int k){
        if(k<=1||head==null){
            return head;
        }
        Node current=head;
        Node prev=null;
        while(true) {

            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {

                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;
            if(current==null){
                break;
            }
            prev=newEnd;
        }
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


