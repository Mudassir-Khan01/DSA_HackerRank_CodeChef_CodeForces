package Oops.oops5.interfaces;

public class CDplayer implements media{

    @Override
    public void start() {
        System.out.println("STart CD palyer");

    }

    @Override
    public void stop() {
        System.out.println("Stop CD player");
    }
}
