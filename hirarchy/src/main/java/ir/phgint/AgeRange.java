package ir.phgint;

/**
 * Created by pouya on 08/01/2017.
 */
public enum AgeRange {
    child       (0 , 10),
    middle      (11, 20),
    gonde       (21, 50),
    oldman      (51, 80);

    int min , max;

    AgeRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
