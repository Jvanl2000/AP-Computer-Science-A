import java.util.Arrays;

public class section {
    public static void main(String[] args) {
        // vectorEuclideanDistance(new int[] {3, 4, 5}, new int[] {5, 6, 7});
        // reverseArray(new String[] {"Hello", "World", "!", "IDK"});
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