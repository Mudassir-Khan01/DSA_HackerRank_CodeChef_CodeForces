package Oops.Inheritance;

public class _3boxprice extends _3boxweight {
    double cost;
    _3boxprice(){
        super();
        this.cost=-1;
    }
    _3boxprice(_3boxprice other){
        super(other);
        this.cost=other.cost;
    }
    public _3boxprice(double l,double h, double w,double weight,double cost){
        super(l, h, w, weight);
        this.cost=cost;
    }
    _3boxprice(double side,double weight,double cost){
        super(side,weight);
        this.cost=cost;
    }

    public static void main(String[] args) {
        _3boxprice box=new _3boxprice(3,4,200);
        System.out.println(box.cost);
    }

}
