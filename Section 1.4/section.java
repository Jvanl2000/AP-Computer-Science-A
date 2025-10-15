import java.util.Arrays;

public class section {
    public static void main(String[] args) {
        // vectorEuclideanDistance(new int[] {3, 4, 5}, new int[] {5, 6, 7});
        // reverseArray(new String[] {"Hello", "World", "!"});
        // random2DArray(10);
        // queensChecker(new int[] {4, 1, 3, 0, 2});
        // howMany(new String[] {"Hello", "World", "!"});
        // copyArray(new int[][] {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}});
        // transposition(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        // advancedTransposition(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        lockerRoom();
    }

    public static void lockerRoom() {
        boolean[] lockers = new boolean[100];
        for (int i = 0; i < lockers.length; i++) {lockers[i] = true;}
        for (int i = 0; i < lockers.length; i++) {
            if ((i + 1) % 2 == 0)
                lockers[i] = !lockers[i];
        }

        for (int i = 3; i <= 100; i++) {
            for (int j = 0; j < lockers.length; j++) {
                if ((j + 1) % i == 0) {
                    lockers[j] = !lockers[j];
                }
            }
        }

        int total = 0;
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
}