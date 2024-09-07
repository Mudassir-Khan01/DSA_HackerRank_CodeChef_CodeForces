package Oops.oops6;

import java.util.ArrayList;
import java.util.Arrays;

public class customArraylist {
    private int []data;
    private static int default_size=10;
    private int size=0;//also working as index value

    public customArraylist(){
        this.data=new int[default_size];
    }
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }
    private boolean isFull(){
        return size==data.length;
    }
    private void resize(){
        int []temp=new int[data.length*2];//double the size
        //now copy the current items in the new array
        for (int i=0;i< data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }
    public int remove(){
        int removed=data[--size];
        return removed;
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index,int value){
        data[index]=value;

    }

    @Override
    public String toString() {
        return "customArraylist{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        customArraylist list=new customArraylist();
        list.add(3);
        list.add(9);
        System.out.println(list);
    }
}
