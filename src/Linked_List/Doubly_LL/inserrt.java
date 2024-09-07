package Linked_List.Doubly_LL;

import Linked_List.Singly_Linked_List.Ins_Del;

public class inserrt {
    Node head;

    public void insertfirst(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        head=node;
    }
    public void insertlast(int value){
    Node node=new Node(value);
    Node last=head;
    if(head==null){
       node.prev=null;
       head=node;
       return;
    }
    while(last.next!=null){
        last=last.next;
    }
    last.next=node;
    node.prev=last;
    node.next=null;
    }
    public Node find(int value){//finding  the node
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;//if not found return null
    }
    public void insertParticular(int after,int value){//insert after a particular value
       Node p=find(after);//placing p just before that value
       if(p==null){
           System.out.println("doesn't exist");
           return;
       }
       Node node=new Node(value);
       node.next=p.next;
       p.next=node;
       node.prev=p;
       if(node.next!=null) {
           node.next.prev = node;
       }
    }
    public void display(){
        Node temp=head;
        Node last=null;//for storing last node
        while(temp!=null){
            System.out.print(temp.value+"->");
            last=temp;
            temp=temp.next;
        }
        System.out.println("END");
        System.out.println("Now printing in reverse");
        while(last!=null){//reverse display
            System.out.print(last.value+"->");
            last=last.prev;
        }
        System.out.println("START");
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next, Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }
}
