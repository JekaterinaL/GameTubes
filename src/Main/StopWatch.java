package Main;

/**
 * Created by Jekaterina on 03.01.2017.
 */
//Kood võetud kodulehelt http://stackoverflow.com/questions/8255738/is-there-a-stopwatch-in-java
//natuke modifitseeritud
public class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public void start(){
        this.startTime = System.currentTimeMillis(); //meetod tagastab väätrust, millal "taimer" oli käivitatud
        this.running = true;
    }

    public void stop(){
        this.stopTime = System.currentTimeMillis(); //meetod tagastab väätrust, millal "taimer" oli peatatud
        this.running = false;
    }

    //Tagastab ajavahemikku sekundites
    public double getElapsedTimeSecs(){
        if (running){
            return ((double)(System.currentTimeMillis() - startTime) / 1000);   //vastuseks on "0"?
        } else {
            return ((double)(stopTime - startTime) / 1000);
        }
    }
}
