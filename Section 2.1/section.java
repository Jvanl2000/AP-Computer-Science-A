import java.util.Arrays;

public class section {
  public static void main(String[] args) {
    // StdOut.println(max3(3, 2, 5)); // 5
    // StdOut.println(max3(3.0, 2.0, 5.0)); // 5.0
    // StdOut.println(odd(true, true, true)); // true
    // StdOut.println(majority(true, true, false)); // true
    // StdOut.println(eq(new int[] {1, 23, 3, 4}, new int[] {1, 3, 3})); // false
    // StdOut.println(areTriangular(3, 4, 5)); // true
    // StdOut.println(sqrt(2)); // 1.41421356237
    // StdOut.println(lg(5));
    // StdOut.println(signum(-23)); // -1
    // StdOut.println(f(9));
  }

  //2.1.1
  public static int max3(int a, int b, int c) {
    int max = a;
    if (b > max)
      max = b;
    if (c > max)
      max = c;
    return max;
  }

  public static double max3(double a, double b, double c) {
    double max = a;
    if (b > max)
      max = b;
    if (c > max)
      max = c;
    return max;
  }

  //2.1.2
  public static boolean odd(boolean a, boolean b, boolean c) {
    boolean[] trueCount = new boolean[] {a, b, c};
    int sum = 0;
    for (boolean truer : trueCount)
      if (truer)
        sum++;
    if (sum % 2 == 0)
      return false;
    return true;
  }

  //2.1.3
  public static boolean majority(boolean a, boolean b, boolean c) {
    return (a && b) || (a && c) || (b && c);
  }

  //2.1.4
  public static boolean eq(int[] a, int[] b) {
    return Arrays.equals(a, b);
  }

  //2.1.5
  public static boolean areTriangular(double a, double b, double c) {
    return !((a >= b + c) || (b >= a + c) || (c >= b + a));
  }

  //2.1.7 
  public static double sqrt(double c) { 
    double EPSILON = 1e-15;
    double t = c;
    while (Math.abs(t - c/t) > EPSILON * t) { // Replace t by the average of t and c/t.
      t = (c/t + t) / 2.0;
    }
    return t;
  }

  //2.1.10
  public static int lg(int n) {
    int closestLogVal = 0;
    while (Math.pow(2, closestLogVal) <= n) {closestLogVal++;}
    return closestLogVal-1; 
  }

  //2.1.11
  public static int signum(int n) {
    return (n == 0 ? 0 : n / Math.abs(n));  
  }

  //2.1.14
  public static int f(int d) {
    int d2 = d * 2;
    int sum = d2 % 10;
    while (d2 > 10) {
      d2 = d2 / 10;
      sum += d2 % 10;
    }
    return sum;
  }

  public static long checksum(int d) {
    if (d%1000000000 > 9) {
      StdOut.println("D must be a 10 Digit Integer");
      return (long) d;
    }
    int[] digitArray = new int[10];
    int i = 0;
    while (d > 10) {
      d = d / 10;
      digitArray[i] = d % 10;
      i++;
    return 0;

  }
}




