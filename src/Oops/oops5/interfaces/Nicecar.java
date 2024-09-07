package Oops.oops5.interfaces;

public class Nicecar {
    private engine engine;//seperate for engine
    private media player=new CDplayer();//for media player

    public Nicecar() {//power engine
        engine=new powerEngine();

    }
    public Nicecar(engine engine){//electric engine
        this.engine=engine;
    }
    public void start(){
        engine.start();
    }
    public void stop(){
        engine.stop();
    }
    public void startmusic(){
        player.start();
    }
    public void stopmusic(){
        player.stop();
    }
    public void upgradingEngine(){
        this.engine=new electricengine();
    }

}
