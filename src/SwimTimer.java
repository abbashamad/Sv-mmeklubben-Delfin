public class SwimTimer {
    int min;
    int sec;
    int milSec;

    public SwimTimer(int min, int sec, int milSec) {
        this.min = min;
        this.sec = sec;
        this.milSec = milSec;
    }


    @Override
    public String toString() {
        return String.format("%02d, %02d, %04d",min,sec,milSec);
    }
}
