package Oops.oops5.interfaces;

public class nestedInterface {
    public interface Intterf{
        boolean isOdd(int num);
    }
}
class B implements nestedInterface.Intterf{
    @Override
    public boolean isOdd(int num){
        return (num&1)==1;
    }
}
class mains{
    public static void main(String[] args) {
        B obj=new B();
        System.out.println(obj.isOdd(4));
    }
}
