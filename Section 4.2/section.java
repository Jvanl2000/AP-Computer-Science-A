import java.util.Arrays;

public class section {
    public static void main(String[] arg) {

        int[] A = new int[] {11, -3, 7, 0, 1, 0, -5, 13, 1, 1};
        int[] B = new int[] {5, 99, 87, 15, 1, 1, 56, 58};
        int[] C = new int[] {-5, -3, 0, 0, 1, 1, 1, 7, 11, 13};
        int[] bitonic = new int[] {1, 3, 5, 6, 7, 4, 2, 0};
        int[] majority = new int[] {1, 2, 3, 2, 2, 2, 1};
        int[] partition = new int[] {0, 1, 1, 0, 1, 0, 0, 1, 0, 1};
        int[] indexIsValue = new int[] {-3, -1, 1, 2, 4, 9, 11, 18, 19, 90};

        // System.out.println(NonrecursiveBinarySearch(new int[] {1, 2, 3, 4, 5}, 4));
        // System.out.println(FullBinarySearch(new int[] {0, 1, 2, 3, 4, 4, 5}, 4));
        // TraceInsertionSort(A);
        // NonrecursiveMergeSort(A);
        // System.out.println(median(A));
        // System.out.println(mode(A));
        // CountSort(B);
        // System.out.println(floor(C, 10));
        // System.out.println(ceiling(C, 10));
        // System.out.println(bitonicPeak(bitonic));
        // System.out.println(Arrays.toString(closestPair(bitonic)));
        // System.out.println(Arrays.toString(furthestPair(bitonic)));
        // System.out.println(majority(majority));
        // partition(partition);
        // quickSort(partition); 
        // System.out.println(indexIsValue(indexIsValue));
        // System.out.println(Arrays.toString(sumExits(indexIsValue, 15)));
    }
    
    

    
    // S7
    // Linear

    // S6
    public static int[] sumExits(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {left, right};
            }
        }

        return new int[] {-1, -1};
    }

    // S5
    public static int indexIsValue(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            if (a[mid] < mid) {
                left = mid + 1;
            } else if (a[mid] > mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    // 4.2.35
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (r - l <= 1) return;
        int part = a[l];
        int i = l + 1;
        int j = r - 1;
        
        while (i <= j) {
            if (a[i] > part && a[j] <= part) {
                exchange(a, i, j);
                i++;
                j--;
            } else if (a[i] <= part) {
                i++;
            } else if (a[j] > part) {
                j--;
            }
        }

        exchange(a, l, j);
        quickSort(a, l, j);
        quickSort(a, j + 1, r);
    }

    // 4.2.33
    public static void partition(int[] a) {
        int[] indecies = furthestPair(a);
        int small = a[indecies[0]];
        int large = a[indecies[1]];
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            if (a[i] == small && a[j] == large) {
                i++;
                j--;
            } else if (a[i] == small && a[j] == small) {
                i++;
            } else if (a[i] == large && a[j] == large) {
                j--;
            } else {
                exchange(a, i, j);
                i++;
                j--;
            }
        }
    }

    // 4.2.30
    public static int majority(int[] a) {
        int count = 0;
        int candidate = -1;
        for (int value : a) {
            if (count == 0) {
                candidate = value;
                count = 1;
            } else if (value == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    // 4.2.27
    public static int[] furthestPair(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
            if (a[i] > max) {
                max = a[i];
                maxIndex = i; 
            }
        }

        return new int[] {minIndex, maxIndex};
    }

    // 4.2.26
    public static int[] closestPair(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        NonrecursiveMergeSort(copy);
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 1; i < copy.length; i++) {
            int diff = copy[i] - copy[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = i - 1;
                result[1] = i;
            }
        }

        return result;
    }

    // 4.2.24
    public static int bitonicPeak(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            if (mid > 0 && mid < a.length - 1) {
                if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                    return mid;
                } else if (a[mid] < a[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (mid == 0) {
                return a[0] > a[1] ? 0 : 1;
            } else {
                return a[a.length - 1] > a[a.length - 2] ? a.length - 1 : a.length - 2;
            }
        }

        return -1;
    }

    // 4.2.23
    public static int ceiling(int[] a, int value) {
        int left = 0;
        int right = a.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            if (a[mid] <= value) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int floor(int[] a, int value) {
        int left = 0;
        int right = a.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            if (a[mid] > value) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // 4.2.22
    public static void CountSort(int[] a) {
        int[] counts = new int[100];
        for (int value : a) counts[value] = counts[value] + 1;
        for (int i = 0; i < counts.length; i++)
            for (int j = 0; j < counts[i]; j++)
                System.out.print(i + " ");
        System.out.println();
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
    public static void SubInsertionSort(int[] a, int l, int r) { 
        for (int i = l + 1; i < r; i++)
            for (int j = i; j > l; j--)
                if (a[j] < a[j-1])
                    exchange(a, j-1, j);
            else break;
    }

    private static void exchange(int[] a, int i, int j) { 
        int temp = a[j]; a[j] = a[i]; a[i] = temp; 
    }

    public static void SubMergeSort(int [] a, int l, int r) {
        int[] aux = new int[a.length];
        SubMergeSort(a, aux, l, r);
    }
    private static void SubMergeSort(int[] a, int[] aux, int l, int r) {
        if (r - l <= 1) return;
        int mid = l + (r-l)/2;
        SubMergeSort(a, aux, l, mid);
        SubMergeSort(a, aux, mid, r);
        int i = l, j = mid;
        for (int k = l; k < r; k++)
        if (i == mid) aux[k] = a[j++];
        else if (j == r) aux[k] = a[i++];
        else if (a[j] < a[i]) aux[k] = a[j++];
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