package Linked_List.Questions;

import Linked_List.Singly_Linked_List.Ins_Del;

public class _1Recursive_Insertion {//SINGLY LL
    private int size;
    private Node head;
    public _1Recursive_Insertion(){
        this.size=0;
    }
    public void insertRec(int value, int index){
        head=insertRec(value,index,head);
    }
    public Node insertRec(int value,int index,Node node){//inside argument is the next node
        if(index==0){
            Node temp=new Node(value,node);//nxt node is the cuurect node which is node
            size++;
            return temp;
        }
        //if not zero keep moving forward
        node.next=insertRec(value,index=index-1,node.next);//current.next=whatever u have returned
        return node;
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
        private  int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        _1Recursive_Insertion list=new _1Recursive_Insertion();
        list.insertRec(55,0);
        list.insertRec(56,1);
        list.insertRec(57,2);
        list.insertRec(58,3);
        list.insertRec(59,4);
        list.insertRec(44,3);
        list.display();
    }
}
