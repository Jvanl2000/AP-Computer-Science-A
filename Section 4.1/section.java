import java.util.List;
import java.util.ArrayList;

public class section {

    public static void main(String[] args) {
        int startValue = 2;
        int iterations = 1000;

        double lastTimeTaken = 0;
        for (int i = 1; i <= iterations; i++) {
            double timeTaken = randomTest(startValue);
            System.out.println("Input: " + startValue + ", Time taken: " + timeTaken + " seconds" + (lastTimeTaken > 0 ? ", Ratio: " + (timeTaken / lastTimeTaken) : ""));
            lastTimeTaken = timeTaken;

            startValue *= 2;
        }        
    }

    // S8
    public static void mergeArraysMutate(int[] arr, int startSecondPart) {
        int i = 0;
        int j = startSecondPart;
        int k = 0;

        while (i < startSecondPart && j < arr.length) {
            if (arr[i] < arr[j]) {
                arr[k++] = arr[i++];
            } else {
                arr[k++] = arr[j++];
            }
        }

        while (i < startSecondPart) {
            arr[k++] = arr[i++];
        }

        while (j < arr.length) {
            arr[k++] = arr[j++];
        }
    }

    // S7
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    // S6 Factorial Growth Function (n!)

    // S5 Exponential Growth Function (2^n)

    // S4
    // n^3
    // n^6
    // n^3

    // S3
    // Multiply matrices function is cubic because there is a double for loop 
    //      inside the method and witin the double for loop a dot product method is called which
    //      in turn used another for loop. So there are three nested for loops which makes the time 
    //      complexity O(n^3).
    // Inverse of a matrix is also cubic because it uses Gaussian elimination which has a time complexity 
    //      of O(n^3) due to the three nested loops in the algorithm.

    // S2 - Linearithmic Growth Function (n log n) - Generate a Random String of Length n
    public static double randomTest(int n) {
        long startTime = System.nanoTime();
        String result = random(n);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static String random(int n) {
        if (n == 0) return "";
        int r = StdRandom.uniform(26);
        char c = 'a' + r;
        return random(n/2) + c + random(n - n/2 - 1);
    }

    // S1 - Exponential Growth Function (2^n) 
    public static double mystery3Test(int n) {
        long[] arr = randomArray(n);
        long startTime = System.nanoTime();
        int result = mystery3(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static int mystery3(long[] a) {
        int n = a.length;
        int count = 0;

        for (int k = 1; k < (1 << n); k++)  {
            long sum = 0;
            for (int i = 0; i < n; i++)
                if (((k >> i) & 1) == 1) sum = sum + a[i];
            if (sum == 0)
                count++;
        }

        return count;
    }

    // 4.1.39 - Factorial Growth Function (n!) - Permutations of a String

    // 4.1.32
    public static double youngTableauxTest(int n) {
        int[][] matrix = randomMatrix(n, n);
        long startTime = System.nanoTime();
        boolean result = youngTableaux(matrix, n);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static boolean youngTableaux(int[][] tableaux, int n) {
        int rows = tableaux.length;
        int cols = tableaux[0].length;

        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (tableaux[i][j] == n) return true;
            else if (tableaux[i][j] > n) j--;
            else i++;
        }

        return false;
    }

    private static int[][] randomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 1000);
            }
        }
        return matrix;
    }

    // 4.1.29
    public static double closestPairTest(int n) {
        int[] arr = randomIntArray(n);
        long startTime = System.nanoTime();
        int[] result = closestPair(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static int[] closestPair(int[] arr) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestPair[0] = arr[i];
                    closestPair[1] = arr[j];
                }
            }
        }

        return closestPair;
    }

    private static int[] randomIntArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000 - 500);
        }
        return arr;
    }

    // 4.1.27
    /*
    program 1,000         10,000       100,000     1,000,000        TYPE
    A       0.001 second  0.012 second 0.16 second 2 seconds        Linear
    B       1 minute      10 minutes   102 minutes 16.666... hours  Linear
    C       0.0166 second 1.7 minutes  168 minutes 11.7 days        Quadratic
    */

    // 4.1.19
    public static double reverseTest(int n) {
        String s = randomString(n);
        long startTime = System.nanoTime();
        String result = reverse1(s);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    public static double reverse2Test(int n) {
        String s = randomString(n);
        long startTime = System.nanoTime();
        String result = reverse2(s);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    // Quadratic Growth Function (n^2)
    private static String reverse1(String s) {
        int n = s.length();
        String reverse = "";
        for (int i = 0; i < n; i++)
            reverse = s.charAt(i) + reverse;

        return reverse;
    }

    // Linear Growth Function (n)
    private static String reverse2(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String left = s.substring(0, n/2);
        String right = s.substring(n/2, n);

        return reverse2(right) + reverse2(left);
    }

    private static String randomString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (StdRandom.bernoulli(0.5)) sb.append("0");
            else sb.append("1");
        return sb.toString();
    }

    // 4.1.16
    // Quadratic Growth Function (n^2)
    public static double mysteryTest(int n) {
        long startTime = System.nanoTime();
        String result = mystery(n);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    // Linear Growth Function (n)
    public static double mystery2Test(int n) {
        long startTime = System.nanoTime();
        String result = mystery2(n);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static String mystery(int n) {
        String s = "";
        for (int i = 0; i < n; i++)
            if (StdRandom.bernoulli(0.5)) s += "0";
            else                             s += "1";

        return s;
    }

    private static String mystery2(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (StdRandom.bernoulli(0.5)) sb.append("0");
            else sb.append("1");
        String s = sb.toString();

        return s;
    }

    // 4.1.15 - Cubic Growth Function (n^3)

    // 4.1.14 - Linearithmic Growth Function (n log n)
    public static double collectCouponsTest(int n) {
        long startTime = System.nanoTime();
        int result = collectCoupons(n);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static int collectCoupons(int n) {
        List<Boolean> isCollected = new ArrayList<>(n);
        for (int i = 0; i < n; i++) isCollected.add(false);
        int count = 0;
        int distinct = 0;
        while (distinct < n) {
            int r = getCoupon(n);
            count++;
            if (!isCollected.get(r)) distinct++;
            isCollected.set(r, true);
        }

        return count;
    }

    private static int getCoupon(int n) { 
        return (int) (Math.random() * n);
    }

    // 4.1.13 - Exponential Growth Function (2^n)
    public static double fTest(int n) {
        long startTime = System.nanoTime();
        int result = f(n);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static int f(int n) {
        if (n == 0) return 1;
        return f(n-1) + f(n-1);
    }

    // 4.1.11 - Quadratic Growth Function (n^2) - 125 Seconds

    // 4.1.10 - Quadratic Growth Function (n^2)

    // 4.1.8
    /*
    a. n(n - 1)(n - 2)(n - 3)/24      - ~1/24 n^4
    b. (n - 2)(lg n - 2)(lg n + 2)    - ~n(lg n)^2
    c. n(n + 1) - n^2                 - ~n
    d. n(n + 1)/2 + n lg n            - ~1/2 n^2 
    e. ln((n - 1)(n - 2)(n - 3))^2    - ~6 ln n
    */

    // 4.1.3 - Quartic Growth Function (n^4)
    public static double FourSumTest(int n) {
        long[] arr = randomArray(n);

        long startTime = System.nanoTime();
        int result = FourSum(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static int FourSum(long[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    private static long[] randomArray(int size) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (long) (Math.random() * 1000 - 500);
        }
        return arr;
    }
}