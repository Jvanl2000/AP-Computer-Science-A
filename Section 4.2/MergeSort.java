import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {
    
    public static final int N = 100;
    public static final int DELAY = 250;

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

    private static void merge(int[] a, int[] aux, int l, int mid, int r) {
        for (int k = l; k < r; k++)
            aux[k] = a[k];
        int i = l;
        int j = mid;
        for (int k = l; k < r; k++)
        if (i == mid) a[k] = aux[j++];
        else if (j == r) a[k] = aux[i++];
        else if (aux[j] < aux[i]) a[k] = aux[j++];
        else a[k] = aux[i++];
    }

    private static void drawFrame(int[] a, int swapOne, int swapTwo) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            if (i == swapOne || i == swapTwo) {
                StdDraw.setPenColor(StdDraw.ORANGE);
            } else if (a[i] == i) {
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

        int swapOne = -1;
        int swapTwo = -1;

        drawFrame(array, swapOne, swapTwo);
    

        int[] aux = new int[N];
        for (int sz = 1; sz < N; sz *= 2) {
            for (int l = 0; l < N - sz; l += 2 * sz) {
                int mid = l + sz;
                merge(array, aux, l, mid, Math.min(l + (2 * sz), N));
                swapOne = mid - 1;
                swapTwo = mid;
                drawFrame(array, swapOne, swapTwo);
                sleep(DELAY);
            }
        }

        drawFrame(array, -1, -1);
    }
    
}
