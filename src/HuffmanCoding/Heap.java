package HuffmanCoding;
import java.util.ArrayList;
 public class Heap<T extends Comparable<T>> {
     private ArrayList<T> list;

     public Heap() {
         list = new ArrayList<>();
     }

     private void swap(int first, int second) {
         T temp = list.get(first);
         list.set(first, list.get(second));
         list.set(second, temp);
     }

     private int parent(int index) {
         return (index - 1) / 2;//here taking from index 0
     }

     private int left(int index) {
         return (index * 2) + 1;
     }

     private int right(int index) {
         return (index * 2) + 2;
     }

     public void insert(T value) {
         list.add(value);//first add it in last
         upheap(list.size() - 1);//now compare it with above value
     }
     public int size(){
         return list.size();
     }

     private void upheap(int index) {
         if (index == 0) {
             return;
         }
         int p = parent(index);
         if (list.get(index).compareTo(list.get(p)) < 0) {//if this item is smaller then parent
             swap(index, p);
             upheap(p);
         }
     }

     public T remove() throws Exception {
         if (list.isEmpty()) {
             throw new Exception("Removing from an empty heap!");
         }
         T temp = list.get(0);//remove from the zero index
         T last = list.remove(list.size() - 1);//remove the last index and store it
         if (!list.isEmpty()) {
             list.set(0, last);

             downheap(0);//now compare it with below value
         }
         return temp;
     }

     private void downheap(int index) {
         int min = index;//current index
         int left = left(index);//get its  left child
         int right = right(index);//get its right child
         if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
             min = left;
         }
         if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
             min = right;//these 2 are so that min points to the smaller child
         }
         if (min != index) {
             swap(min, index);
             downheap(min);
         }
     }


     //Heap Sort
     public ArrayList<T>heapSort() throws Exception {
         ArrayList<T> data=new ArrayList<>();
         while(!list.isEmpty()){
             data.add(this.remove());//keep removing the data and add it in list data
         }
         return data;
     }

     public static void main(String[] args) throws Exception  {
         Heap<Integer> heap = new Heap<Integer>();
         heap.insert(34);
         heap.insert(45);
         heap.insert(22);
         heap.insert(89);
         heap.insert(76);
         ArrayList list1=heap.heapSort();
         System.out.println(list1);
         //System.out.println(heap.remove());

     }
 }
