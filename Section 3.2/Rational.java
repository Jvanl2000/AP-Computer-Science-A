public class Rational {

    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        int gcd = gcd(numerator, denominator);
        if (denominator < 0) {
            gcd = -gcd;
        }

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    public Rational plus(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational minus(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational times(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational divides(Rational other) {
        if (other.numerator == 0) throw new IllegalArgumentException("Cannot divide by zero.");
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational neg() {
        return new Rational(-this.numerator, this.denominator);
    }

    public Rational recip() {
        if (this.numerator == 0) throw new IllegalArgumentException("Cannot take reciprocal of zero.");
        return new Rational(this.denominator, this.numerator);
    }

    @Override
    public String toString() {
        if (denominator == 1) return Integer.toString(numerator);
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(2, 3);
        Rational c = new Rational(-2, 5);
        Rational d = new Rational(3, -7);
        StdOut.println(a + " + " + b + " = " + a.plus(b));
        StdOut.println(a + " + " + c + " = " + a.plus(c));
        StdOut.println(c + " + " + d + " = " + c.plus(d));
        StdOut.println("-(" + a + ") = " + a.neg());
        StdOut.println(a + " - " + b + " = " + a.minus(b));
        StdOut.println(a + " - " + c + " = " + a.minus(c));
        StdOut.println(c + " - " + d + " = " + c.minus(d));
        StdOut.println(a + " * " + b + " = " + a.times(b));
        StdOut.println(a + " * " + c + " = " + a.times(c));
        StdOut.println(c + " * " + d + " = " + c.times(d));
        StdOut.println("reciprocal of " + d + " = " + d.recip());
        StdOut.println(a + " / " + b + " = " + a.divides(b));
        StdOut.println(a + " / " + c + " = " + a.divides(c));
        StdOut.println(c + " / " + d + " = " + c.divides(d));
    }
}