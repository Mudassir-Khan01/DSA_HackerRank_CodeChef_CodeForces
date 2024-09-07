package Oops.Inheritance;

public class _3boxweight extends _3inheritance {
    double weight;
    public _3boxweight(){
        this.weight=-1;

    }
    public _3boxweight(double l,double h,double w,double weight){
        super(l,h,w);//calling the parent class const
        //it is used to initialize values present in parent class
        this.weight=weight;

    }
    public _3boxweight(_3boxweight other){
        super(other);//same as parent box5= new child();
        weight=other.weight;
    }
    public _3boxweight(double side,double weight){
        super(side);
        this.weight=weight;
    }


    public static void main(String[] args) {
        //_3boxweight box3=new _3boxweight();
        _3boxweight box3=new _3boxweight(1,2,3,4);
        System.out.println(box3.h+""+ box3.weight);

        }


    }


