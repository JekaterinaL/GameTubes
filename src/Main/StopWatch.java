package Main;

import java.util.concurrent.TimeUnit;

//Kood võetud kodulehelt http://stackoverflow.com/questions/8255738/is-there-a-stopwatch-in-java
//natuke modifitseeritud
public class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public void start(){
        startTime = System.currentTimeMillis(); //meetod tagastab aega, millal "taimer" oli käivitatud (01.01.1970)
        running = true;
    }

    public void stop(){
        stopTime = System.currentTimeMillis(); //meetod tagastab aega, millal "taimer" oli peatatud (01.01.1970)
        running = false;
    }

    //Tagastab ajavahemikku formaadis hh:mm:ss
    public String getElapsedTime(){
        long elapsedTime;
        if (running) {
            elapsedTime = (System.currentTimeMillis() - startTime);
        }
        else {
            elapsedTime = (stopTime - startTime);
        }
        long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
        elapsedTime -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime);
        elapsedTime -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
