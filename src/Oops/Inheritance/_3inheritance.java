package Oops.Inheritance;

public class _3inheritance {
    double l;
    double h;
    double w;

    _3inheritance(){
        this.h=-1;
        this.l=-1;
        this.w=-1;
    }
    //cube
    _3inheritance(double side){
        this.h=side;
        this.w=side;
        this.l=side;
    }
    _3inheritance(double l,double h,double w){
        this.h=h;
        this.w=w;
        this.l=l;
    }
    _3inheritance(_3inheritance old){
        this.h=old.h;
        this.l=old.l;
        this.w=old.w;
    }
    public  void information(){
        System.out.println("Running the box");
    }




    public static void main(String[] args) {
        //_3inheritance box=new _3inheritance();//no arg wala run hoga
        _3inheritance box1=new _3inheritance(4,5,6);
        _3inheritance box2=new _3inheritance(box1);//object created
        box2.information();
        System.out.println(box2.l+" "+box2.h+""+box2.w);
        //_3inheritance box=new _3inheritance(4);//one argument wala run hoga
        //_3inheritance box=new _3inheritance(4.6,5.6,1.2);3 arg wala run hogha
    }

}
