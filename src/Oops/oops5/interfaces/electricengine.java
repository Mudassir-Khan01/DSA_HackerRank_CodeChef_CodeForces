package Oops.oops5.interfaces;

public class electricengine implements engine {
    @Override
    public void start() {
        System.out.println("Electric engine start");
    }

    @Override
    public void stop() {
        System.out.println("electric enhine stops");
    }

    @Override
    public void acc() {
        System.out.println("electric engine Accelerate");
    }
}
