public class section {
  public static void main(String[] args) {
    //StdOut.println(max3(3.0, 2.0, 5.0));
    StdOut.println(odd(true, true, true));
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


}
