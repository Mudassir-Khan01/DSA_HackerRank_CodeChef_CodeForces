class base{
    base(){
        System.out.println("I am a constructor");
    }
    base(int x){
        System.out.println("I am an overloaded constructor with value"+x);

    }

}
class derived extends base{
    derived(){
        System.out.println("I am a derived class constructor");

    }
    derived(int x,int y){
        super(x);
        System.out.println("I am a overloaded constructor of derived with value of y as: "+y);

    }
}
class childofderived extends derived{
    childofderived(){
        System.out.println("I am a child of derived constructor");
    }
    childofderived(int x,int y,int z){
        super(x,y);
        System.out.println("I am an overloaded contructor of derived with value of z as :"+z);

    }
}
public class inheritance_super {
    public static void main(String[]args){
        childofderived cd=new childofderived(12,13,15);
    }
}
