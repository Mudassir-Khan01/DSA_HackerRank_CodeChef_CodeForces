package Linked_List.Questions;

public class _4_5LLCycle_Length {

    public boolean hasCycle(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //finding length  of the cycle
    public int lengthCycle(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&slow!=null){
            fast=fast.next.next;//2 step
            slow=slow.next;//one step
            if(fast==slow){
                //calculate the length
                Node temp=slow;//we have to run the slow again till it becomes equals to fast and thereby claculating length
                int length=0;
                do{
                    temp=temp.next;
                    length++;

                }while (temp!=slow);//ortemp!=false
                return length;
            }
        }
        return 0;
    }
    private class Node{
        int val;
        Node next;
        Node(int x){
           this.val=x;
            this.next=null;
        }
    }

    public static void main(String[] args) {
        _4_5LLCycle_Length list=new _4_5LLCycle_Length();

    }
}
