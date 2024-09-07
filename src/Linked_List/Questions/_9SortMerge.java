package Linked_List.Questions;

public class _9SortMerge {
    Node head;
    Node tail;
    public Node sort(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node mid=getmid(head);
        Node left=sort(head);//left starts from head
        Node right=sort(mid);//it starts from mid
        return merge(left,right);
    }

    public Node merge(Node list1,Node list2){
        Node dummyhead=new Node();
        Node tail=dummyhead;
        while(list1!=null&&list2!=null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list1.next;
                tail = tail.next;
            }
        }
            tail.next=(list1!=null)?list1:list2;
            return dummyhead.next;
        }
        Node getmid(Node head){
        Node midprev=null;
        while(head!=null&&head.next!=null){
            midprev=(midprev==null)?head:midprev.next;//1 step
            head=head.next.next;//2step
        }
        Node mid=midprev.next;
        midprev.next=null;
        return mid;
        }

    class Node{
        int val;
        Node next;
public Node(){}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {

            this.val = val;
            this.next = next;
        }
    }
}
