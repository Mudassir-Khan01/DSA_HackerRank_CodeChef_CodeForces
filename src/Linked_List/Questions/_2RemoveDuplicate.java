package Linked_List.Questions;

import Linked_List.Singly_Linked_List.Ins_Del;

public class _2RemoveDuplicate {//SINGLY LL
    private Node head;
    private Node tail;
    int size;
    public _2RemoveDuplicate() {
        this.size =0;
    }

    public void duplicate(){
        Node node=head;
        while(node.next!=null){
            if(node.value==node.next.value){
                node.next=node.next.next;//skip it
                size--;
            }else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
    }
    //below funtion are just for insertion
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
        _2RemoveDuplicate list=new _2RemoveDuplicate();
        list.insertlast(1);
        list.insertlast(1);
        list.insertlast(1);
        list.insertlast(2);
        list.insertlast(3);
        list.insertlast(3);
        list.display();
        list.duplicate();
        list.display();

    }
}
