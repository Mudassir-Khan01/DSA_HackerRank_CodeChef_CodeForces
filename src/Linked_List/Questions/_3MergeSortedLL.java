package Linked_List.Questions;

import Linked_List.Singly_Linked_List.Ins_Del;

public class _3MergeSortedLL {
    Node head;
    Node tail;
    int size;

    public _3MergeSortedLL() {
        this.size = 0;
    }

    public static _3MergeSortedLL merge(_3MergeSortedLL first, _3MergeSortedLL second){//have to return LL so we are taking return type as LL
        Node f=first.head;//head1
        Node s=second.head;//head2

        _3MergeSortedLL ans=new _3MergeSortedLL();
        while(f!=null&&s!=null){
            if(f.value<s.value){
                ans.insertlast(f.value);
                f=f.next;
            }else{
                ans.insertlast(s.value);
                s=s.next;
            }
        }
        while(f!=null){
            ans.insertlast(f.value);
            f=f.next;
        }
while(s!=null){
    ans.insertlast(s.value);
    s=s.next;
}
return ans;
    }
    public void insertionFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;

        }
        size+=1;
    }
    public void insertlast(int value){
        if(tail==null){
            insertionFirst(value);//if nothing is there so first create it
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        _3MergeSortedLL first=new _3MergeSortedLL();
        _3MergeSortedLL second=new _3MergeSortedLL();
        first.insertlast(1);
        first.insertlast(2);
        first.insertlast(3);
        second.insertlast(4);
        second.insertlast(5);
        _3MergeSortedLL list=_3MergeSortedLL.merge(first,second);
list.display();
    }
}
