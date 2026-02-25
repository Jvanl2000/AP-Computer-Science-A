public class Rational {

    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        int gcd = gcd(numerator, denominator);
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
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(6, 8);

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r1 + r2: " + r1.plus(r2));
        System.out.println("r1 - r2: " + r1.minus(r2));
        System.out.println("r1 * r2: " + r1.times(r2));
        System.out.println("r1 / r2: " + r1.divides(r2));
        System.out.println("-r1: " + r1.neg());
        System.out.println("1/r1: " + r1.recip());
    }
}