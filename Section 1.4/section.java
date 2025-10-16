import java.util.*;

public class section {

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static void main(String[] args) {
        // vectorEuclideanDistance(new int[] {3, 4, 5}, new int[] {5, 6, 7});
        // reverseArray(new String[] {"Hello", "World", "!"});
        // random2DArray(10);
        // queensChecker(new int[] {4, 1, 3, 0, 2});
        // howMany(new String[] {"Hello", "World", "!"});
        // copyArray(new int[][] {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}});
        // transposition(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        // advancedTransposition(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        // squareLockerRoom();
        // diceSimulation(6, 100000);
        // findPlateau(new int[] {1, 2, 2, 2, 1, 3, 3, 2});
        // inversePermutation(new int[] {2, 0, 1});
        // printHadamard(hadamard(4));w
        // printBoard(generateMinesweeper(5, 5, 0.2));
        // hasDuplicate(new int[] {3, 1, 4, 2, 5, 3});
        // birthdayExperament(100_000);
        // primeLockers();
        // printSpiral(new int[][] {
        //     {1, 2, 3, 4},
        //     {5, 6, 7, 8},
        //     {9, 10, 11, 12},
        //     {13, 14, 15, 16}
        // });
        // countAndPrintInBase(12);
    }

    public static String convertToBaseN(int number, int base) {
        StringBuilder result = new StringBuilder();
        int currentNumber = number;

        while (currentNumber > 0) {
            int remainder = currentNumber % base;
            result.append(DIGITS[remainder]);
            currentNumber /= base;
        }

        return result.reverse().toString();
    }

    public static void countAndPrintInBase(int base) {
        for (int i = 0; i <= 1000; i++) {
            String convertedValue = convertToBaseN(i, base);
            System.out.println(i + " - " + convertedValue);
        }
    }

    public static void printSpiral(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }

    public static int birthdayTrial() {
        boolean[] seen = new boolean[365];
        int count = 0;

        while (true) {
            int birthday = (int) (Math.random() * 365);
            count++;
            if (seen[birthday]) {
                return count;
            }
            seen[birthday] = true;
        }
    }

    public static void birthdayExperament(int trials) {
        int total = 0;
        for (int t = 0; t < trials; t++) {
            total += birthdayTrial();
        }
        System.out.println("Birthday Average: " + (double) total / trials);
    }

    public static void hasDuplicate(int[] a) {
        int n = a.length;
        boolean duplicateFound = false;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(a[i]) - 1;
            if (a[index] < 0) {
                duplicateFound = true;
            } else {
                a[index] = -a[index];
            }
        }

        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(a[i]);
        }

        System.out.println("Has duplicate: " + duplicateFound);
    }

    public static char[][] generateMinesweeper(int m, int n, double p) {
        boolean[][] bombs = new boolean[m + 2][n + 2];
        int[][] neighbors = new int[m + 2][n + 2];
        char[][] board = new char[m][n];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                bombs[i][j] = Math.random() < p;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (bombs[i][j]) continue;
                int count = 0;
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        if (bombs[i + di][j + dj]) count++;
                    }
                }
                neighbors[i][j] = count;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (bombs[i][j]) board[i - 1][j - 1] = '*';
                else board[i - 1][j - 1] = (neighbors[i][j] == 0)
                        ? '.' : Character.forDigit(neighbors[i][j], 10);
            }
        }

        return board;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static boolean[][] hadamard(int n) {
        if (n == 1) {
            return new boolean[][] { { true } };
        }

        boolean[][] H = hadamard(n / 2);
        boolean[][] A = new boolean[n][n];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A[i][j] = H[i][j];
                A[i][j + n / 2] = H[i][j];
                A[i + n / 2][j] = H[i][j];
                A[i + n / 2][j + n / 2] = !H[i][j];
            }
        }
        return A;
    }

    public static void printHadamard(boolean[][] H) {
        int n = H.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(H[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }

    public static void inversePermutation(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 || arr[i] >= n) {
                throw new IllegalArgumentException("Value " + arr[i] + " out of range [0, " + (n - 1) + "]");
            }
            if (seen[arr[i]]) {
                throw new IllegalArgumentException("Duplicate value: " + arr[i]);
            }
            seen[arr[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            newArr[arr[i]] = i;
        }

        System.out.println("Permutation: " + Arrays.toString(arr));
        System.out.println("Inverse:     " + Arrays.toString(newArr));
    }


    public static void findPlateau(int[] arr) {
        int bestStart = -1;
        int bestLen = 0;

        int i = 0;
        while (i < arr.length) {
            int j = i;
            while (j + 1 < arr.length && arr[j + 1] == arr[i]) {
                j++;
            }

            int len = j - i + 1;
            boolean leftSmaller = (i == 0) || (arr[i - 1] < arr[i]);
            boolean rightSmaller = (j == arr.length - 1) || (arr[j + 1] < arr[j]);

            if (leftSmaller && rightSmaller) {
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = i;
                }
            }
            i = j + 1; 
        }

        if (bestStart == -1)
            System.out.println("No plateau found");
        else
            System.out.println("Longest plateau starts at index " + bestStart + " with length " + bestLen);
    }

    public static void diceSimulation(int number, int iters) {
        int[] frequencies = new int[13];
        for (int i = 1; i <= 6; i++)
            for (int j = 1; j <= 6; j++)
                frequencies[i+j]++;

        double[] probabilities = new double[13];
        for (int k = 1; k <= 12; k++)
            probabilities[k] = frequencies[k] / 36.0;

        int valid = 0;
        int invalid = 0;
        for (int i = 0; i < iters; i++) {
            int die1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
            int die2 = 1 + (int)(Math.random() * ((6 - 1) + 1));

            if ((die1 + die2) == number) { valid++; }
            else { invalid++; }
        }

        System.out.println("Difference in probability: " + Math.abs(((double) valid / (valid + invalid)) - probabilities[number]));
    }

    public static void primeLockers() {
        boolean[] lockers = new boolean[100];
        for (int i = 1; i < lockers.length; i++) {
            lockers[i] = true;
        }

        for (int door = 2; door < lockers.length; door++) {
            for (int locker = 2 * door; locker <= lockers.length; locker += door) {
                lockers[locker - 1] = false;
            }
        }

        System.out.print("Open Lockers: ");
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    public static void squareLockerRoom() {
        boolean[] lockers = new boolean[100];
        for (int i = 0; i < lockers.length; i++) {lockers[i] = true;}
        for (int i = 0; i < lockers.length; i++) {
            if ((i + 1) % 2 == 0)
                lockers[i] = !lockers[i];
        }

        for (int i = 3; i <= lockers.length; i++) {
            for (int j = 0; j < lockers.length; j++) {
                if ((j + 1) % i == 0) {
                    lockers[j] = !lockers[j];
                }
            }
        }

        System.out.print("Open Lockers: ");
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i]) {System.out.print(i + 1 + " ");}
        }
        System.out.println();
    }

    public static void advancedTransposition(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        System.out.println("Transposed Array: " + Arrays.deepToString(arr));
    }

    public static void transposition(int[][] arr) {
        int[][] newArr = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                newArr[i][j] = arr[j][i];
            }
        }

        System.out.println("Transposed Array: " + Arrays.deepToString(newArr));
    }

    public static void copyArray(int[][] arr) {
        int[][] newArr = new int[arr.length][];

        for (int i = 0; i < newArr.length; i++) {
            int[] tempArr = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                tempArr[j] = arr[i][j];
            }
            newArr[i] = tempArr;
        }

        System.out.println("Original Array: " + Arrays.deepToString(arr));
        System.out.println("New Array: " + Arrays.deepToString(newArr));
    }

    public static void howMany(String[] arr) {
        System.out.println("Array Length: " + arr.length);
    }

    public static void queensChecker(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j)
                    continue;

                if (Math.abs(i - j) == Math.abs(board[i] - board[j])) 
                    System.out.println("Valid Queens Setup: false");
            }
        }
        System.out.println("Valid Queens Setup: true");
    }

    public static void random2DArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        for (int i = 0; i < (n - 1); i++) {
            int min = i + 1;
            int max = n - 1;
            int newIndex = i + (int)(Math.random() * (max - i + 1));
            int temp = arr[i];
            arr[i] = arr[newIndex];
            arr[newIndex] = temp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == arr[j])
                    System.out.print(" Q ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void reverseArray(String[] arr) {
        System.out.println("Original Array: " + Arrays.toString(arr));
        for (int i = 0; i <= ((int)(arr.length / 2)); i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println("New Array: " + Arrays.toString(arr));
    }

    public static void vectorEuclideanDistance(int[] vectorOne, int[] vectorTwo) {
        int sum = 0;

        for (int i = 0; i < vectorOne.length; i++) {
            sum += (int) (Math.pow(vectorOne[i] - vectorTwo[i], 2));
        }

        System.out.println("Vector Euclidean Distance: " + Math.sqrt(sum));
    }

    public static int max(int[] a) {
        int max = a[0];
        for (int value : a)
            if (value > max) max = value;
        return max;
    }

    public static int[] minMax(int[] a) {
        int min = a[0], max = a[0];
        for (int value : a) {
            if (value < min) min = value;
            if (value > max) max = value;
        }
        return new int[]{min, max};
    }

    public static double median(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        int n = copy.length;
        if (n % 2 == 1)
            return copy[n / 2];
        else
            return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
    }

    public static int mostFrequent(int[] a) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : a)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        int mode = a[0], maxCount = 0;
        for (var entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public static long sumOfSquares(int[] a) {
        long sum = 0;
        for (int value : a)
            sum += (long) value * value;
        return sum;
    }

    public static double average(int[] a) {
        long sum = 0;
        for (int value : a) sum += value;
        return (double) sum / a.length;
    }

    public static int closestToZero(int[] a) {
        int closest = a[0];
        for (int value : a) {
            if (Math.abs(value) < Math.abs(closest) ||
               (Math.abs(value) == Math.abs(closest) && value > closest)) {
                closest = value;
            }
        }
        return closest;
    }

    public static int[] greaterThanAverage(int[] a) {
        double avg = average(a);
        return Arrays.stream(a).filter(x -> x > avg).toArray();
    }

    public static int[] sortAscending(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        return copy;
    }
}