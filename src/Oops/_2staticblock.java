package Oops;

public class _2staticblock {
    static int a=4;
    static int b;
    static {//will only run once when the first obj is created i.e when the class is loaded for the fiorst time
        System.out.println("I am in static block");
        b=a*5;
    }

    public static void main(String[] args) {
        _2staticblock obj=new _2staticblock();
        System.out.println(obj.a+"  "+ _2staticblock.b);//can also be called as Oops2_staticblock.a

        obj.b+=3;
        System.out.println(obj.a+" "+obj.b);
        _2staticblock obj2=new _2staticblock();
        System.out.println(obj2.a+" "+obj2.b);
    }
}
