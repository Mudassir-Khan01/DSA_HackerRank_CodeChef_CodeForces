class phone{
    public void on(){
        System.out.println("Turning on phone...");
    }
    public void time(){
        System.out.println("bura time chal rha :)");
    }
}
class smartphone extends phone {
    public void on() {
        System.out.println("turning on Smartphone...");
    }
}
    public class method_dispatch {
    public static void main(String[]args){
        phone obj=new smartphone();
        obj.on();
        obj.time();
    }

}
