# 2.3.15 Binary representation

---

## A) While loop (wrong order)

```java
public class BinaryWrongOrder {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n <= 0) throw new IllegalArgumentException("n must be positive");

        while (n > 0) {
            int bit = n % 2;
            System.out.print(bit);   // wrong order
            n /= 2;
        }
        System.out.println();
    }
}
```

---

## B) Recursion (correct order)

```java
public class BinaryRepresentation {

    private static void printBinary(int n) {
        if (n < 2) {
            System.out.print(n);
            return;
        }

        printBinary(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n <= 0) throw new IllegalArgumentException("n must be positive");

        printBinary(n);
        System.out.println();
    }
}
```

---

---

# 2.3.17 Permutations

Print all `n!` permutations of the first `n` letters.

```java
public class Permutations {

    private static void permute(char[] a, int i) {

        if (i == a.length) {
            System.out.print(new String(a) + " ");
            return;
        }

        for (int j = i; j < a.length; j++) {
            swap(a, i, j);
            permute(a, i + 1);
            swap(a, i, j); // backtrack
        }
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if (n < 0 || n > 26)
            throw new IllegalArgumentException("n must be between 0 and 26");

        char[] letters = new char[n];
        for (int i = 0; i < n; i++)
            letters[i] = (char) ('a' + i);

        permute(letters, 0);
        System.out.println();
    }
}
```

---

---

# 2.3.19 Combinations

Print all `2^n` subsets, including the empty set.

```java
public class Combinations {

    private static void combinations(char[] letters, int i, String prefix) {

        if (i == letters.length) {
            System.out.print(prefix + " ");
            return;
        }

        // Exclude current letter
        combinations(letters, i + 1, prefix);

        // Include current letter
        combinations(letters, i + 1, prefix + letters[i]);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if (n < 0 || n > 26)
            throw new IllegalArgumentException("n must be between 0 and 26");

        char[] letters = new char[n];
        for (int i = 0; i < n; i++)
            letters[i] = (char) ('a' + i);

        combinations(letters, 0, "");
        System.out.println();
    }
}
```

---

---

# 2.3.29 Collatz function 

We want the `i < n` that produces the **maximum number of recursive calls**.

This is the **pure recursive** solution.

---

## Collatz Call Counter Version

```java
public class CollatzMax {

    // Returns number of recursive calls made by collatz(n)
    public static int collatzCalls(int n) {

        if (n == 1) return 1;

        if (n % 2 == 0)
            return 1 + collatzCalls(n / 2);
        else
            return 1 + collatzCalls(3 * n + 1);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if (n <= 1) {
            System.out.println("n must be greater than 1");
            return;
        }

        int bestI = 1;
        int maxCalls = 1;

        // Find i < n with the most recursive calls
        for (int i = 1; i < n; i++) {

            int calls = collatzCalls(i);

            if (calls > maxCalls) {
                maxCalls = calls;
                bestI = i;
            }
        }

        // Print result
        System.out.println(bestI);

        // Optional:
        // System.out.println("Max calls: " + maxCalls);
    }
}
```

✅ This follows the assignment exactly
✅ No maps, no arrays, no memoization
⚠️ Runs slower for large `n`, but correct

---

---

# ✅ 2.3.38 Binomial coefficients

---

## A) Pure recursion (no DP)

```java
public class BinomialRecursive {

    public static long binomial(int n, int k) {

        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        return binomial(n - 1, k - 1)
             + binomial(n - 1, k);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(binomial(n, k));
    }
}
```

### Runtime for `C(100, 15)`?

**Essentially impossible** with pure recursion.
The number of calls grows exponentially.

---

---

## B) Top-down DP (memoization array)

```java
public class BinomialTopDown {

    private static long[][] memo;

    public static long binomial(int n, int k) {

        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        if (memo[n][k] != -1)
            return memo[n][k];

        memo[n][k] = binomial(n - 1, k - 1)
                   + binomial(n - 1, k);

        return memo[n][k];
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        memo = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                memo[i][j] = -1;

        System.out.println(binomial(n, k));
    }
}
```

Runs instantly for `C(100, 15)`.

---

---

## C) Bottom-up DP

```java
public class BinomialBottomUp {

    public static long binomial(int n, int k) {

        if (k < 0 || k > n) return 0;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= Math.min(i, k); j++) {

                if (j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1]
                             + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(binomial(n, k));
    }
}
```

Also instant for `C(100, 15)`.

---