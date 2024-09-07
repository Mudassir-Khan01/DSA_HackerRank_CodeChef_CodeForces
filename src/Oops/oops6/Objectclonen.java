package Oops.oops6;

public class Objectclonen implements Cloneable  {
    int age;
    String name;
    public Objectclonen(int age,String name){
        this.age=age;
        this.name=name;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();

    }
}
