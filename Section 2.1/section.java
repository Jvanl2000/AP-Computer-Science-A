public class section {
  public static void main(String[] args) {
    //StdOut.println(max3(3.0, 2.0, 5.0));
    //StdOut.println(odd(true, true, true));
    //StdOut.println(majority(true, true, false));
    //StdOut.println(eq(new int[] {1, 23, 3, 4}, new int[] {1, 2, 3}));
    //StdOut.println(areTriangular(3, 4, 5));
    //StdOut.println(sqrt(2));
    //StdOut.println(lg(5));
  }

//2.1.1

  public static int max3(int a, int b, int c) {
    int max = a;
    if (b > max)
      max = a;
    if (c > max)
      max = c;
    return max;
  }

  public static double max3(double a, double b, double c) {
    double max = a;
    if (b > max)
      max = a;
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
    if (!(a.length == b.length)) {return false;}
    for (int i = 0; i < a.length; i++) {
      if (!(a[i] == b[i])) {return false;}
    }
    return true;
  }

//2.1.5

  public static boolean areTriangular(double a, double b, double c) {
    if ((a >= b + c) || (b >= a + c) || (c >= b + a)) {return false;} 
    return true;
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

}


