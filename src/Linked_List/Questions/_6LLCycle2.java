package Linked_List.Questions;

public class _6LLCycle2 {
    public Node detectCycle(Node head){
        int length=0;

      Node fast=head;
       Node slow=head;
        while(fast!=null&&slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length=lengthCycle(slow);
                break;
            }
        }
        if(length==0){
            return  null;
        }
        //now find the start node
        Node f=head;
        Node s=head;
        while(length>0){//placimg second after length
            s=s.next;
            length--;
        }
        //keep moving both first and second and they will meet at start node
        while(f!=s){
            f=f.next;
            s=s.next;
        }
        return s;
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

        public static void main(String[] args) {

        }
    }
}
