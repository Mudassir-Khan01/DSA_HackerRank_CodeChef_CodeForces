package Linked_List.Singly_Linked_List;

public class main {
    public static void main(String[] args) {
        Ins_Del list=new Ins_Del();//size initalized , head and tail will be there
        list.insertionFirst(3);
        list.insertionFirst(4);
        list.insertionFirst(5);
        list.insertlast(99);
        list.insertparticular(55,2);
        int value=list.deleteFirst();
        System.out.println(value);

        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.deleteparticular(1));
        list.display();



    }
}
