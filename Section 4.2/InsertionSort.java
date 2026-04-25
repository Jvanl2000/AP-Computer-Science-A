import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertionSort {
    
    public static final int N = 100;
    public static final int DELAY = 100;

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateIntegerArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
    
        return a;
    }

    private static void shuffleArray(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a) list.add(i);
        Collections.shuffle(list);
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void drawFrame(int[] a, int swapOne, int swapTwo, int completed) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            if (i == swapOne || i == swapTwo) {
                StdDraw.setPenColor(StdDraw.ORANGE);
            } else if (i <= completed) {
                StdDraw.setPenColor(StdDraw.GREEN);
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }

            StdDraw.filledRectangle(i * (100.0 / N) + (100.0 / N) / 2, a[i] * (100.0 / N) / 2, ((100.0 / N) / 2) * 0.8, a[i] * (100.0 / N) / 2);
        }

        StdDraw.show();
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.enableDoubleBuffering();

        int[] array = generateIntegerArray(N);
        shuffleArray(array);

        int completed = 0;
        int swapOne = -1;
        int swapTwo = -1;

        drawFrame(array, swapOne, swapTwo, completed);
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                swapOne = j;
                swapTwo = j + 1;
                exchange(array, j, j + 1);
                drawFrame(array, swapOne, swapTwo, completed);
                sleep(DELAY);
                j--;
            }

            completed += 1;
        }

        drawFrame(array, -1, -1, completed);
    }
    
}
