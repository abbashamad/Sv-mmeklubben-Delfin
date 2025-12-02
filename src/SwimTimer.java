public class SwimTimer implements Comparable<SwimTimer> {
    private final int min;
    private final int sec;
    private final int milSec;

    public SwimTimer(int min, int sec, int milSec) {
        this.min = min;
        this.sec = sec;
        this.milSec = milSec;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public int getMilSec() {
        return milSec;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%03d", min, sec, milSec);
    }

    @Override
    public int compareTo(SwimTimer o) {
        if (this.min - o.getMin() != 0) {
            return this.min - o.getMin();
        }
        if (this.sec - o.getSec() != 0) {
            return this.sec - o.getSec();
        }
        return this.milSec-o.getMilSec();
    }
}
