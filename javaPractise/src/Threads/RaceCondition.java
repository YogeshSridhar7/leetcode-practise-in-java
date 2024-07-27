package Threads;

import java.util.HashSet;
import java.util.Set;

public class RaceCondition {
    public static void main(String[] args) {
        RaceCondition testThread = new RaceCondition();
        testThread.go();
    }
    public void go(){
        Thread getSeats1 = new Thread(() -> {
            ticketAgentBooks("1A");
            ticketAgentBooks("1B");
        });
        Thread getSeats2 = new Thread(() -> {
            ticketAgentBooks("1A");
            ticketAgentBooks("1B");
        });
        getSeats1.start();
        getSeats2.start();
    }
    public void ticketAgentBooks(String seat){
        Show show = Show.getInstance();
        System.out.println(Thread.currentThread().getName()
                + ": "
                + show.bookSeat(seat));
    }
}

class Show{
    private static volatile Show INSTANCE;
    private final Set<String> availableSeats;
    public static  synchronized Show getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Show();
        }
        return INSTANCE;
    }
    private Show(){
        availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }
    public synchronized Boolean bookSeat( String seat){
        return availableSeats.remove(seat);
    }
}
