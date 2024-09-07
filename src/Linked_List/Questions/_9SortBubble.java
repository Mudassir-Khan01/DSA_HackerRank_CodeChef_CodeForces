package Linked_List.Questions;

import Linked_List.Singly_Linked_List.Ins_Del;

public class _9SortBubble {
    int size;
    Node head;
    Node tail;
    _9SortBubble(){
        this.size=0;
    }
    public void bubbleSort(){
       bubbleSort(size-1,0);//row and column
    }
    private void bubbleSort(int row , int col ){
        if(row==0){
            return ;
        }
        if(col<row){
            Node first=get(col);
            Node second=get(col+1);
            if(first.val>second.val){
                //swap and 3 cases are there
               if(first==head){
                  head=second;
                  first.next=second.next;
                  second.next=first;
               }else if (second==tail){
                 Node prev=get(col-1);//f se phele wale pe point kar denge
                   prev.next=second;
                   tail=first;
                   first.next=null;
                   second.next=tail;
               }else{
                   Node prev=get(col-1);
                   prev.next=second;
                   first.next=second.next;
                   second.next=first;
               }
            }
            bubbleSort(row, col+1);//next number ie next column
        }else {
bubbleSort(row-1,0 );//move to next one next iteration
        }
    }
    public Node get(int index){//gives the reference pointer at that node
        Node node = head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
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
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("End");
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
        _9SortBubble list=new _9SortBubble();
        for(int i=7;i>0;i--){
            list.insertlast(i);
        }
        list.display();
        list.bubbleSort();
        list.display();
    }
}
