package Oops.oops5.interfaces;

public class main {
    public static void main(String[] args) {
        car car=new car();
        //Engine car=new car(); int a=36 in car
        //car.a;//wont be able to access it

        car.acc();
        car.start();
        car.stop();
        //by adding media in interface and calling stop ,engine will be stoped so we have to sepearte classes

        Nicecar carr=new Nicecar();
        carr.start();
        carr.startmusic();
        carr.upgradingEngine();
        carr.start();
    }
}
