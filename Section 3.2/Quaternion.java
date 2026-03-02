public class Quaternion {
    
    private double a, b, c, d;

    public Quaternion(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double mag() {
        return Math.sqrt(a*a + b*b + c*c + d*d);
    }

    public Quaternion conj() {
        return new Quaternion(a, -b, -c, -d);
    }

    public Quaternion add(Quaternion q) {
        return new Quaternion(a + q.a, b + q.b, c + q.c, d + q.d);
    }

    public Quaternion sub(Quaternion q) {
        return new Quaternion(a - q.a, b - q.b, c - q.c, d - q.d);
    }

    public Quaternion scalarProd(double x) {
        return new Quaternion(x*a, x*b, x*c, x*d);
    }

    public Quaternion prod(Quaternion q) {
        double newA = a*q.a - b*q.b - c*q.c - d*q.d;
        double newB = a*q.b + b*q.a + c*q.d - d*q.c;
        double newC = a*q.c - b*q.d + c*q.a + d*q.b;
        double newD = a*q.d + b*q.c - c*q.b + d*q.a;
        return new Quaternion(newA, newB, newC, newD);
    }

    public Quaternion inv() {
        double magSq = a*a + b*b + c*c + d*d;
        return new Quaternion(a/magSq, -b/magSq, -c/magSq, -d/magSq);
    }

    public Quaternion div(Quaternion q) {
        return this.prod(q.inv());
    }   

    private double round(double x, int n) {
        double factor = Math.pow(10, n);
        return Math.round(x * factor) / factor;
    }

    @Override
    public String toString() {
        String string = "";
        if (a != 0) string += round(a, 4);
        if (b != 0) string += (a != 0 ? " + " : "") + round(b, 4) + "i";
        if (c != 0) string += ((a != 0 || b != 0) ? " + " : "") + round(c, 4) + "j";
        if (d != 0) string += ((a != 0 || b != 0 || c != 0) ? " + " : "") + round(d, 4) + "k";
        return string;
    }

    public static void main(String[] args) {
        Quaternion A = new Quaternion(1, 2, 3, 4);
        Quaternion B = new Quaternion(-7, 12, -3, 5);
        Quaternion C = new Quaternion(0.5, 1.0/3, -Math.PI, Math.E);
        Quaternion R = new Quaternion(1, 0, 0, 0);
        Quaternion I = new Quaternion(0, 1, 0, 0);
        Quaternion J = new Quaternion(0, 0, 1, 0);
        Quaternion K = new Quaternion(0, 0, 0, 1);
        StdOut.println(A);
        StdOut.println(B);
        StdOut.println(C);
        StdOut.println(R);
        StdOut.println(I);
        StdOut.println(J);
        StdOut.println(K);
        StdOut.println(A.mag());
        StdOut.println(B.conj());
        StdOut.println(A.add(B));
        StdOut.println(B.scalarProd(3));
        StdOut.println(A.prod(B));
        StdOut.println(B.prod(A));
        StdOut.println(A.inv());
        StdOut.println(A.div(B));
        StdOut.println(B.div(A));
    }

}
