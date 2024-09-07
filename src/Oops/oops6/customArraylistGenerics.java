package Oops.oops6;

import java.util.Arrays;

public class customArraylistGenerics<T> {
    private Object []data;
    private static int default_size=10;
    private int size=0;//also working as index value

    public customArraylistGenerics(){
        this.data=new Object[default_size];
    }
    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }
    private boolean isFull(){
        return size==data.length;
    }
    private void resize(){
        Object[] temp=new Object[data.length*2];//double the size
        //now copy the current items in the new array
        for (int i=0;i< data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }
    public T remove(){
        T removed=(T)data[--size];//smaller to bigger so casting
        return removed;
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index,T value){
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
        customArraylistGenerics<Integer> list=new customArraylistGenerics<>();
for(int i=0;i<14;i++){
list.add(2*i);
        }
        System.out.println(list);
    }
}

