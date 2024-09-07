package Linked_List.Circular_LL;

public class main {
    public static void main(String[] args) {
        insert list=new insert();
        list.insertt(1);
        list.insertt(2);
        list.insertt(3);
        list.insertt(4);
        list.insertt(5);
        list.display();
        list.delete(3);
        list.display();
    }
}
