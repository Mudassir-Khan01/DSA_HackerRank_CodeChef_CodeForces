package Oops.oops6;

public class objectlone_main   {
    public static void main(String[] args) throws CloneNotSupportedException {
        Objectclonen kunal=new Objectclonen(32,"Kunal Khuswaha");
        Objectclonen twin=(Objectclonen) kunal.clone();
        System.out.println(twin.name+""+twin.age);
    }
}
