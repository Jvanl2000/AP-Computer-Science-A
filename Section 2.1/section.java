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

    // StdOut.println(checksum("7992039871"));

    // double[] scaleArr = new double[] {1.2, 3.8, 2.5, 4.1};
    // scale(scaleArr);
    // StdOut.println(Arrays.toString(scaleArr));

    // String[] reverseArr = new String[] {"Hello", "World", "!"};
    // StdOut.println(Arrays.toString(reverse(reverseArr)));
    // reverseInplace(reverseArr);
    // StdOut.println(Arrays.toString(reverseArr));

    // StdOut.println(Arrays.deepToString(readBoolean2D()));

    // int[] histogramArr = new int[] {1,1,5,8,9,6,6,3,1,4,5,8,7,3,5,0};
    // StdOut.println(Arrays.toString(histogram(histogramArr, 10)));

    // int[][] multiplyA = new int[][] {{4, 2, 5}, {7, 3, 2}, {7, 8, 9}};
    // int[][] multiplyB = new int[][] {{5, 1}, {8, 7}, {1, 2}};
    // StdOut.println(Arrays.deepToString(multiply(multiplyA, multiplyB)));

    // boolean[] anyAllArr = new boolean[] {false, true, false};
    // StdOut.println(any(anyAllArr));
    // StdOut.println(all(anyAllArr));

    StdOut.println(Arrays.toString(getPrimeFactors(4096)));

    // StdOut.println(Arrays.toString(primefactors(10000)));
  }

  // 2.1.1
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

  // 2.1.2
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

  // 2.1.3
  public static boolean majority(boolean a, boolean b, boolean c) {
    return (a && b) || (a && c) || (b && c);
  }

  //2.1.4
  public static boolean eq(int[] a, int[] b) {
    return Arrays.equals(a, b);
  }

  // 2.1.5
  public static boolean areTriangular(double a, double b, double c) {
    return !((a >= b + c) || (b >= a + c) || (c >= b + a));
  }

  // 2.1.7 
  public static double sqrt(double c) { 
    double EPSILON = 1e-15;
    double t = c;
    while (Math.abs(t - c/t) > EPSILON * t) { // Replace t by the average of t and c/t.
      t = (c/t + t) / 2.0;
    }
    return t;
  }

  // 2.1.10
  public static int lg(int n) {
    int closestLogVal = 0;
    while (Math.pow(2, closestLogVal) <= n) {closestLogVal++;}
    return closestLogVal-1; 
  }

  // 2.1.11
  public static int signum(int n) {
    return (n == 0 ? 0 : n / Math.abs(n));  
  }

  // 2.1.12

  // 2.1.14
  public static String checksum(String d) {
    int sum = Integer.parseInt(String.valueOf(d.charAt(0)));
    for (int i = 1; i < 10; i++) {
      if (i % 2 == 0) {
        sum += Integer.parseInt(String.valueOf(d.charAt(i)));
      } else {
        sum += f(Integer.parseInt(String.valueOf(d.charAt(i))));
      }
    }

    return d + String.valueOf(sum % 10);
  }

  public static int f(int d) {
    int d2 = d * 2;
    int sum = d2 % 10;
    while (d2 > 10) {
      d2 = d2 / 10;
      sum += d2 % 10;
    }

    return sum;
  }

  // 2.1.16
  public static void scale(double[] arr) {
    double max = max(arr);
    double min = min(arr);
    for (int i = 0; i < arr.length; i++) { arr[i] -= min; arr[i] /= (double) (Math.abs(max - min)); }
  }

  public static double min(double[] arr) {
    double min = arr[0];
    for (double value : arr) {
      if (value < min) min = value;
    }

    return min;
  }

  public static double max(double[] arr) {
    double max = arr[0];
    for (double value : arr) {
      if (value > max) max = value;
    }

    return max;
  }

  // 2.1.17
  public static String[] reverse(String[] arr) {
    String[] newArr = new String[arr.length];
    for (int i = 0; i < newArr.length; i++) {
      newArr[i] = arr[arr.length - i - 1];
    }

    return newArr;
  }

  public static void reverseInplace(String[] arr) {
    for (int i = 0; i < (arr.length / 2); i++) {
      String temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
  }

  // 2.1.18
  public static boolean[][] readBoolean2D() {
    int rows;
    int cols;
    
    StdOut.print("Input number of rows: ");
    rows = StdIn.readInt();
    StdOut.print("Input number of cols: ");
    cols = StdIn.readInt();

    boolean[][] booleanArr2D = new boolean[rows][cols];

    StdOut.println("Input Array with True (1) and False (0) values: ");
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        booleanArr2D[row][col] = StdIn.readInt() == 1;
      }
    }

    return booleanArr2D;
  }

  // 2.1.19
  public static int[] histogram(int[] arr, int m) {
    int[] newArr = new int[m];
    for (int value : arr) {
      newArr[value] += 1;
    }

    return newArr;
  }

  // 2.1.21
  public static int[][] multiply(int[][] a, int[][] b) {
    int[][] newArr = new int[a.length][b[0].length];

    for (int i = 0; i < newArr.length; i++) {
      for (int j = 0; j < newArr[0].length; j++) {
        newArr[i][j] = matrixMultiplicationSum(a[i], getCollum(b, j));
      }
    }

    return newArr;
  }

  public static int matrixMultiplicationSum(int[] a, int[] b) {
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += (a[i] * b[i]);
    }

    return sum;
  }

  public static int[] getCollum(int[][] a, int collum) {
    int[] newArr = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      newArr[i] = a[i][collum];
    }

    return newArr;
  }

  // 2.1.22
  public static boolean any(boolean[] arr) {
    for (boolean bool : arr) {
      if (bool) { return bool; }
    }

    return false;
  }

  public static boolean all(boolean[] arr) {
    for (boolean bool : arr) {
      if (!bool) { return bool; }
    }

    return true;
  }

  // 2.1.26
  public static int[] getPrimeFactors(int n) {
    if (isPrime(n)) {
      return new int[] {n};
    }
    
    int nextPrime = 2;
    while (n % nextPrime != 0 || !(isPrime(nextPrime))) { nextPrime++; }
    return combineArray(new int[] {nextPrime}, getPrimeFactors(n / nextPrime));
  }

  public static boolean isPrime(int n) {
    for (int i = 2; i <= (n / 2); i++) {
      if (n % i == 0) {return false;}
    }
    return true;
  }

  public static int[] combineArray(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    for (int i = 0; i < a.length; i++) { c[i] = a[i]; }
    for (int i = a.length; i < a.length + b.length; i++) { c[i] = b[i - a.length]; }

    return c;
  }
}