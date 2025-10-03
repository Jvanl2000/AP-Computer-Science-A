import java.util.Arrays;

public class section {
    public static void main(String[] args) {
        // threeEqual(1, 1, 1);
        // rollLoadedDie();
        // hellos(100);
        // oneTwoByFive();
        // averageRandom(1000);
        // functionGrowth();
        // baseToBase(981968, 14);
        // System.out.println(greatestCommonDivisor(48, 18));
        // relativelyPrime(100);
        // sumOfCubes(35000);
        // checksumISBN(217923784);
        // pepysSimulation(10000);
        // letsMakeADeal(10000);
        // childSimulation(10000);
        // threeDice(10000);
        // estimateRoot(27);
        // negEstimateRoot(27);
        // estimateCubeRoot(-127);
        // estimateNthRoot(777, 7);
        // sumRandomOne(10000);
        // factors(6125);
    }

    public static void sumOfCubes(int n) {
        int orig = n;
        n = (int) Math.pow(n, 1.0/3);
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                for (int c = a; c <= n; c++) {
                    for (int d = c; d <= n; d++) {
                        int sum1 = a*a*a + b*b*b;
                        int sum2 = c*c*c + d*d*d;
                        if (sum1 == sum2 && sum1 <= orig) {
                            if (a != c && a != d) {
                                System.out.print(sum1 + " = ");
                                System.out.println(a + " " + b + " " + c + " " + d);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void factors(long n) {
        System.out.print("The prime factorization of " + n + " is: ");

        for (long factor = 2; factor*factor <= n; factor++) {

            if (n % factor == 0) {
                System.out.print(factor + " ");
                while (n % factor == 0)
                    n = n / factor;
            }
        }

        if (n > 1) System.out.println(n);
        else       System.out.println();
    }

    public static void sumRandomOne(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            while (sum < 1) {
                sum += Math.random();
                total += 1;
            }
        }

        System.out.println((double) total / n);
    }

    public static void estimateNthRoot(int base, int root) {
        double currGuess = (double) base / root;
        double newGuess = ((root - 1) * currGuess + (double) base / Math.pow(currGuess, root - 1)) / root;
        int count = 0;
        while (Math.abs(currGuess - newGuess) > 0.0000001) {
            currGuess = newGuess;
            newGuess = ((root - 1) * currGuess + (double) base / Math.pow(currGuess, root - 1)) / root; 
            count++;
        }

        System.out.println(round(currGuess, 4));

        if (root % 2 == 0 && base > 0) {
            System.out.println(round(-newGuess, 4));
        }

        System.out.println("Looped " + count + " times");
    }

    public static void estimateCubeRoot(int root) {
        double currGuess = (double) root / 3;
        double newGuess = (2 * (currGuess*currGuess*currGuess) + root) / (3 * (currGuess * currGuess));
        while (Math.abs(currGuess - newGuess) > 0.0000001) {
            currGuess = newGuess;
            newGuess = (2 * (currGuess*currGuess*currGuess) + root) / (3 * (currGuess * currGuess));
        }

        System.out.println(currGuess);
    }

    public static void negEstimateRoot(int root) {
        double currGuess = (double) root / -2;
        double newGuess = (currGuess + ((double) root / currGuess)) / 2;
        while (Math.abs(currGuess - newGuess) > 0.0000001) {
            currGuess = newGuess;
            newGuess = (currGuess + ((double) root / currGuess)) / 2;
        }

        System.out.println(currGuess);
    }

    public static void estimateRoot(int root) {
        double currGuess = (double) root / 2;
        double newGuess = (currGuess + ((double) root / currGuess)) / 2;
        while (Math.abs(currGuess - newGuess) > 0.0000001) {
            currGuess = newGuess;
            newGuess = (currGuess + ((double) root / currGuess)) / 2;
        }

        System.out.println(currGuess);
    }

    public static void threeDice(int n) {
        int[] A = {2, 6, 7};
        int[] B = {1, 5, 9};
        int[] C = {3, 4, 8};
        int[][] ALL_SETS = {A, B, C};

        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (A[(int) Math.round(Math.random() * 2)] > ALL_SETS[(int) Math.round(Math.random() * 2)][(int) Math.round(Math.random() * 2)]) a += 1;
            if (B[(int) Math.round(Math.random() * 2)] > ALL_SETS[(int) Math.round(Math.random() * 2)][(int) Math.round(Math.random() * 2)]) b += 1;
            if (C[(int) Math.round(Math.random() * 2)] > ALL_SETS[(int) Math.round(Math.random() * 2)][(int) Math.round(Math.random() * 2)]) c += 1;
        }

        System.out.println("Chance of winning " + Arrays.toString(A) + ": " + round((a / (double) n) * 100, 2) + "%");
        System.out.println("Chance of winning " + Arrays.toString(B) + ": " + round((b / (double) n) * 100, 2) + "%");
        System.out.println("Chance of winning " + Arrays.toString(C) + ": " + round((c / (double) n) * 100, 2) + "%");
    }

    public static void childSimulation(int n) {
        int children = 0;
        for (int i = 0; i < n; i++) {
            boolean boy = false;
            boolean girl = false;

            while (!(boy && girl)) {
                int gender = (int)(Math.round(Math.random()));
                if (gender == 0)
                    boy = true;
                if (gender == 1)
                    girl = true;
                children += 1;
            }
        }

        System.out.println("Average Children: " + ((double) children / n));
    }

    public static void functionGrowth() {
        System.out.println("n\t\tlog n\t\tn log n\t\tn^2\t\tn^3\t\t2^n");
        for (int n = 16; n <= 2048; n *= 2) {
            double logn = Math.log(n); 
            double nlogn = n * Math.log(n);
            double n2 = Math.pow(n, 2);
            double n3 = Math.pow(n, 3);
            double pow2n = Math.pow(2, n);

            System.out.println(
                round(n, 2) + "\t\t" +
                round(logn, 2) + "\t\t" +
                round(nlogn, 2) + "\t\t" +
                round(n2, 2) + "\t\t" + 
                round(n3, 2) + "\t\t" +
                round(pow2n, 2) + "\t\t");
        }
    }

    public static double round(double number, int digits) {
        double factor = Math.pow(10, digits);
        return Math.round(number * factor) / factor;
    }

    public static void letsMakeADeal(int n) {
        int stay = 0;
        int change = 0;

        for (int i = 0; i < n; i++) {
            int playerChoice = (int) (Math.random() * 3);
            int correctDoor = (int) (Math.random() * 3);

            if (playerChoice == correctDoor)
                stay++;
            else
                change++;   
        }

        System.out.println("Stay Strat: " + stay);
        System.out.println("Changing Strat: " + change);
    }

    public static void pepysSimulation(int n) {
        int oneBySix = 0;
        int twoByTwelve = 0;

        for (int i = 0; i < n; i++) {
            for (int a = 1; a <= 6; a++) {
                int random = (int) (Math.random() * 6) + 1;
                if (random == 1) {
                    oneBySix += 1;
                    break;
                }
            }

            int two = 0;
            for (int b = 1; b <= 12; b++) {
                int random = (int) (Math.random() * 6) + 1;
                if (random == 1) {
                    two += 1;
                }
            }
            
            if (two >= 2) {
                twoByTwelve += 1;
            }
        }

        System.out.println("One Die Six Times: " + oneBySix);
        System.out.println("Two Dies Twelve Times: " + twoByTwelve);
    }

    public static void checksumISBN(int number) {
        double newNumber = number;
        int[] digits = new int[9];

        for (int i = 8; i >= 0; i--) {
            digits[i] = (int) (newNumber % 10);
            newNumber = newNumber / 10;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }

        int checkDigit = (11 - (sum % 11)) % 11;

        for (int i = 0; i < 9; i++) {
            System.out.print(digits[i]);
        }

        if (checkDigit == 10)
            System.out.println("X");
        else
            System.out.println(checkDigit);
    }


    public static void relativelyPrime(int n) {
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (greatestCommonDivisor(x, y) == 1) 
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void threeEqual(int a, int b, int c) {
        if (a == b && b == c) 
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }

    public static void rollLoadedDie() {
        int roll = (int)(Math.random() * 8) + 1;
        int result;
        if (roll <= 5)
            result = roll;
        else
            result = 6;

        System.out.println(result);
    }

    public static void hellos(int x) {
        for (int i = 1; i <= x; i++) {

            switch (i % 100) {
                case 11 -> {System.out.println(i + "th Hello!"); continue;}
                case 12 -> {System.out.println(i + "th Hello!"); continue;}
                case 13 -> {System.out.println(i + "th Hello!"); continue;}
            }

            switch (i % 10) {
                case 1 -> System.out.println(i + "st Hello!");
                case 2 -> System.out.println(i + "nd Hello!");
                case 3 -> System.out.println(i + "rd Hello!");
                default -> System.out.println(i + "th Hello!");
            }
        }
    }

    public static void oneTwoByFive() {
        for (int i = 1000; i <= 2000; i++) {
            if (i % 5 == 4) 
                System.out.println(i + " ");
            else 
                System.out.print(i + " ");
        }
    }

    public static void averageRandom(int n) {
        double total = 0.0;
    
        for (int i = 0; i < n; i++)
            total += Math.random();

        System.out.println(total / n);
    }

    public static void baseToBase(long i, int k) {
        String digits = "0123456789ABCDEF";

        if (i == 0) {
            System.out.println("0");
            return;
        }

        String result = "";

        while (i > 0) {
            int remainder = (int)(i % k);
            result = digits.charAt(remainder) + result;
            i /= k;
        }

        System.out.println(result);
    }

    public static int greatestCommonDivisor(int x, int y) {
        if (y > x) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x % y == 0) {
            return y;
        } else {
            return greatestCommonDivisor(x % y, y);
        }
    }
}