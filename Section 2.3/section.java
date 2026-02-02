import java.util.Arrays;

public class section {
    public static void main(String[] args) {
        // System.out.println(intToBinary(11));

        // System.out.println(count(5, new int[] {5, 5, 4, 3, 7, 8, 5, 5, 4, 3, 5}));
        
        // int[] array = new int[] {1, 2, 3, 4, 5};
        // reverseMutate(array, 0);
        // System.out.println(Arrays.toString(array));

        // int[] array = new int[] {1, 2, 3, 4, 5};
        // System.out.println(Arrays.toString(reverseNonMutate(array)));

        // int[] array = new int[] {5, 2, 1, 4, 5};
        // System.out.println(min(array));

        // int[] array = new int[] {1, 2, 3, 4, 5};
        // System.out.println(max(array));

        // System.out.println(sumOfDigits("10"));
        
        // System.out.println(intToBinary2(4));

        // System.out.println(gcf(6, 3));

        // ex233(6);

        // System.out.println(mystery(2, 25));

    }

    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    // 2.3.7
    public static boolean gcdlike(int p, int q) {
        if (q == 0) return (p == 1);
        return gcdlike(q, p % q);
    }

    // 2.3.3
    public static void ex233(int n) {
        if (n <= 0) return;
        System.out.println(n);
        ex233(n-2);
        ex233(n-3);
        System.out.println(n);
    }

    // S6
    // a_1 ​= 2
    // a_n​ = 2(a_(n−1)​)^2  

    // S15-d
    public static int sumOfDigits(String num) {
        if (num.length() <= 1) return Integer.parseInt(num);
        return Integer.parseInt(String.valueOf(num.charAt(0))) + sumOfDigits(num.substring(1));
    }

    // S15-e
    public static String intToBinary2(int n) {
        if (n == 1) return "1";
        return intToBinary2(n / 2) + (n % 2);
    }

    // S15-f    
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
    
    // S15-c
    public static int max(int[] arr) {
        if (arr.length == 1) return arr[0];
        return arr[0] > max(tail(arr)) ? arr[0] : max(tail(arr));
    }
    
    // S15-c
    public static int min(int[] arr) {
        if (arr.length == 1) return arr[0];
        return arr[0] < min(tail(arr)) ? arr[0] : min(tail(arr)); 
    }

    // S15-b (non-mutator)
    public static int[] reverseNonMutate(int[] array) {
        if (array.length == 1) return Arrays.copyOf(array, array.length);
        return concat(reverseNonMutate(tail(array)), (new int[] {array[0]}));
        
    }

    // S15-b (non-mutator helper)
    public static int[] concat(int[] a, int[] b) {
        int[] newArr = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) { newArr[i] = a[i]; }
        for (int i = 0; i < b.length; i++) { newArr[a.length + i] = b[i]; }

        return newArr;
    }

    // (helper)
    public static int[] tail(int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }    
        
        return newArray; 
    } 
        
    // S15-b (mutator)
    public static void reverseMutate(int[] array, int i) {
        if (i >= (array.length / 2));
        else {
            int index = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = index;
            reverseMutate(array, i + 1);
        }
    }

    // S15-a
    public static int count(int num, int[] arr) {
        if (arr.length == 0) return 0;
        else {
            if (arr[0] == num) return 1 + count(num, Arrays.copyOfRange(arr, 1, arr.length));
            else return count(num, Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    // 2.3.15
    public static String intToBinary(int n) {
        String temp = "";

        while (n > 0) {
            temp += String.valueOf(n%2);
            n = n/2;
        }

        return reverse(temp);
    }

    public static String reverse(String string) {
        if (string.length() <= 1) return string;
        else return string.charAt(string.length() - 1) + reverse(string.substring(0, string.length() - 1));
    }
}