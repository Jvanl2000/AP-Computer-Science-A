public class Interval {
    
    private final double min;
    private final double max;

    public Interval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(double value) {
        if (isEmpty()) return false;
        return value >= min && value <= max;
    }

    public boolean intersects(Interval other) {
        if (this.isEmpty() || other.isEmpty()) return false;
        return this.max >= other.min && this.min <= other.max;
    }

    public boolean isEmpty() {
        return min > max;
    }

    @Override
    public String toString() {
        return "[" + min + ", " + max + "]";
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty()) {
            double min = StdIn.readDouble();
            double max = StdIn.readDouble();
            Interval interval = new Interval(min, max);
            if (interval.contains(x)) System.out.println(interval);
        }
    }
}