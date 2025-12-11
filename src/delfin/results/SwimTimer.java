package delfin.results;

import delfin.exceptions.SwimTimeException;

public class SwimTimer implements Comparable<SwimTimer> {
    private final int min;
    private final int sec;
    private final int milSec;

    public SwimTimer(int min, int sec, int milSec) {
        if (min < 0) {
            throw new SwimTimeException("Invalid value for minute of SwimTime (valid values > -1):" + min);
        }
        if (sec < 0 || sec > 59) {
            throw new SwimTimeException("Invalid value for minute of SwimTime (valid values  0 - 59):" + sec);
        }
        if (milSec < 0 || milSec > 999) {
            throw new SwimTimeException("Invalid value for millisecond of SwimTime (valid values  0 - 999):" + milSec);
        }

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

    public static SwimTimer parse(String swimTime) {
        String[] fields = swimTime.split(":");
        return new SwimTimer(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
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
        return this.milSec - o.getMilSec();
    }
}
