import java.util.Arrays;

public class section {
    public static void main(String[] arg) {

        int[] A = new int[] {11, -3, 7, 0, 1, 0, -5, 13, 1, 1};

        // System.out.println(NonrecursiveBinarySearch(new int[] {1, 2, 3, 4, 5}, 4));
        // System.out.println(FullBinarySearch(new int[] {0, 1, 2, 3, 4, 4, 5}, 4));
        // TraceInsertionSort(A);
        // NonrecursiveMergeSort(A);
        // System.out.println(median(A));
        // System.out.println(mode(A));
        
    }

    // 4.2.21
    public static int mode(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        NonrecursiveMergeSort(copy);
        int mode = copy[0];
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == copy[i - 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    mode = copy[i - 1];
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            mode = copy[copy.length - 1];
        }
        return mode;
    }

    // 4.2.20
    public static int median(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        NonrecursiveMergeSort(copy);
        int n = copy.length;
        if (n % 2 == 1) {
            return copy[n / 2];
        } else {
            return (copy[n / 2 - 1] + copy[n / 2]) / 2;
        }
    }

    // 4.2.16
    public static void NonrecursiveMergeSort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        for (int sz = 1; sz < n; sz *= 2)
            for (int l = 0; l < n - sz; l += 2 * sz)
                merge(a, aux, l, l + sz, Math.min(l + (2 * sz), n));
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

    // 4.2.15
    public static void SubInsertionSort(Comparable[] a, int l, int r) { 
        for (int i = l + 1; i < r; i++)
            for (int j = i; j > l; j--)
                if (a[j].compareTo(a[j-1]) < 0)
                    exchange(a, j-1, j);
            else break;
    }

    private static void exchange(Comparable[] a, int i, int j) { 
        Comparable temp = a[j]; a[j] = a[i]; a[i] = temp; 
    }

    public static void SubMergeSort(Comparable[] a, int l, int r) {
        Comparable[] aux = new Comparable[a.length];
        SubMergeSort(a, aux, l, r);
    }
    private static void SubMergeSort(Comparable[] a, Comparable[] aux, int l, int r) {
        if (r - l <= 1) return;
        int mid = l + (r-l)/2;
        SubMergeSort(a, aux, l, mid);
        SubMergeSort(a, aux, mid, r);
        int i = l, j = mid;
        for (int k = l; k < r; k++)
        if (i == mid) aux[k] = a[j++];
        else if (j == r) aux[k] = a[i++];
        else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
        else aux[k] = a[i++];
        for (int k = l; k < r; k++)
        a[k] = aux[k];
    }

    // 4.2.6
    public static void TraceInsertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int focus = a[i];
            int j = i - 1;
            boolean moved = false;
            while (j >= 0 && a[j] > focus) {
                a[j + 1] = a[j];
                j--;
                moved = true;
            }
            if (moved) System.out.println("Moved " + i + " to " + (j + 1));
            a[j + 1] = focus;
        }
    }

    /* 4.2.4
    
    Describe what happens if you apply binary search to an unordered array: It does not search properly, and may return an incorrect index or -1 even if the key is present in the array.

    Why shouldn’t you check whether the array is sorted before each call to binary search: Because this would check the entire array for each call, which would take O(n) time, defeating the purpose of using binary search which is O(log n).

    Could you check that the elements binary search examines are in ascending order? Yes, but this would only check a few elements (the middle ones) and would not guarantee that the entire array is sorted. It could lead to incorrect results if the array is not sorted, as binary search relies on the order of elements to function correctly.

    */

    // 4.2.3
    public static int FullBinarySearch(int [] a, int key) { 
        return FullBinarySearch(a, key, 0, a.length);
    }

    public static int FullBinarySearch(int [] a, int key, int l, int r) { 
        if (r <= l) return -1;
        int mid = (int) ((l + r) / 2);
        int cmp = a[mid] - key;
        if (cmp > 0) return FullBinarySearch(a, key, l, mid);
        else if (cmp < 0) return FullBinarySearch(a, key, mid+1, r);
        else {
            int result = FullBinarySearch(a, key, l, mid);
            return result == -1 ? mid : result;
        }
    }

    // 4.2.2
    public static int NonrecursiveBinarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            if (key < a[mid]) {
                right = mid - 1;
            } else if (key > a[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}