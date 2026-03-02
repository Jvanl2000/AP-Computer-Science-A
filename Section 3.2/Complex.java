public class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real; this.imaginary = imaginary; 
    }

    public Complex plus(Complex b) {
        double real = this.real + b.real;
        double imag = this.imaginary + b.imaginary;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        double real = this.real - b.real;
        double imag = this.imaginary - b.imaginary;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) {
        double real = this.real * b.real - this.imaginary * b.imaginary;
        double imag = this.real * b.imaginary + this.imaginary * b.real;
        return new Complex(real, imag);
    }

    public Complex divides(Complex b) {
        double denominator = b.real * b.real + b.imaginary * b.imaginary;
        double real = (this.real * b.real + this.imaginary * b.imaginary) / denominator;
        double imag = (this.imaginary * b.real - this.real * b.imaginary) / denominator;
        return new Complex(real, imag);
    }

    public Complex power(int n) {
        Complex result = new Complex(1, 0);
        for (int i = 0; i < n; i++) {
            result = result.times(this);
        }

        return result;
    }

    public Complex theta() {
        return new Complex(Math.atan2(this.imaginary, this.real), 0);
    }

    public double abs() { 
        return Math.sqrt(this.real*this.real + this.imaginary*this.imaginary); 
    }

    public Complex conjugate() { 
        return new Complex(this.real, -this.imaginary); 
    }

    public double real() { 
        return this.real; 
    }
        
    public double imaginary() {
         return this.imaginary; 
    }

    public String toString() { 
        if (this.imaginary == 0) return this.real + "";
        if (this.real == 0) return this.imaginary + "i";
        return this.real + " + " + this.imaginary + "i"; 
    }
        
    public static void main(String[] args) {
        double a = 3.0;
        double b = -4.0;
        double c = 12.0;

        Complex root1;
        Complex root2;

        double discriminant = b*b - 4*a*c;
        if (discriminant < 0) {
            root1 = new Complex(-b/(2*a), Math.sqrt(-discriminant)/(2*a));
            root2 = new Complex(-b/(2*a), -Math.sqrt(-discriminant)/(2*a));
        } else if (discriminant == 0) {
            root1 = new Complex(-b/(2*a), 0);
            root2 = null;
        } else {
            root1 = new Complex((-b + Math.sqrt(discriminant)) / (2*a), 0);
            root2 = new Complex((-b - Math.sqrt(discriminant)) / (2*a), 0);
        }

        System.out.println("root1 = " + root1);
        System.out.println("root2 = " + root2);

        // Complex z1 = new Complex(1, 2);
        // Complex z2 = new Complex(3, 4);
        // System.out.println("z1 + z2 = " + z1.plus(z2));
        // System.out.println("z1 - z2 = " + z1.minus(z2));
        // System.out.println("z1 * z2 = " + z1.times(z2));
        // System.out.println("z1 / z2 = " + z1.divides(z2));
        // System.out.println("z1^3 = " + z1.power(3));
        // System.out.println("theta(z1) = " + z1.theta());
        // System.out.println("|z1| = " + z1.abs());
        // System.out.println("conjugate(z1) = " + z1.conjugate());
    }
}