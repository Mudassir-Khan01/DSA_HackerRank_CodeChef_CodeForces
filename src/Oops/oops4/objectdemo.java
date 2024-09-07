package Oops.oops4;

public class objectdemo {
    int num;
    public objectdemo(int num){
        this.num=num;
    }
    @Override
    public String toString(){
        return super.toString();
    }
   // @Override
    //protected void finalize() throws Throwable{
      //  super.finalize();
    //}
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) {
        objectdemo obj=new objectdemo(34);
        System.out.println(obj.hashCode());
    }

}
