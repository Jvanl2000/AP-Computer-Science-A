public class section {
    public static void main(String[] args) {
        // maxMin();
        // positiveMaxMin();
        // meanAndDev(2);
        // longestConsec();
        missingNumber(10);
    }


    // 1.5.1
    public static void maxMin() {
        StdOut.print("Input Values: ");
        int min = StdIn.readInt();
        int max = min;

        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value > max) max = value;
            if (value < min) min = value;
        }

        System.out.println();
        System.out.println("Max Value: " + max);
        System.out.println("Min Value: " + min);
    }

    //1.5.2
    public static void positiveMaxMin() {
        System.out.print("(POSITIVE) Input Values: ");
        int min = StdIn.readInt();
        while (min < 0) {
            System.out.println("Values MUST be positive!");
            System.out.print("(POSITIVE) Input Values: ");
            min = StdIn.readInt();
        }
        int max = min;

        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            while (value < 0) {
                System.out.println("Values MUST be positive!");
                value = StdIn.readInt();
            }
            if (value > max) max = value;
            if (value < min) min = value;
        }

        System.out.println();
        System.out.println("Max Value: " + max);
        System.out.println("Min Value: " + min);
    }

    // 1.5.3
    public static void meanAndDev(int n) {
        float[] floats = new float[n];
        for (int i = 0; i < n; i++) {
            StdOut.print("Input float: ");
            floats[i] = StdIn.readFloat();
        }
        StdOut.println("Average: " + mean(floats));
        StdOut.println("Sample Standard Deviation: " + deviat(floats));

    }


    // 1.5.5
    public static void longestConsec() {
        int curLong = 0;
        int longestVal = 0;
        int prevInt = 0;
        int sum = 0;
        
        StdOut.print("Input Ints: ");
        while (!StdIn.isEmpty()) {
            int newInt = StdIn.readInt();
            if (newInt == prevInt)
                sum++;
            else {
                prevInt = newInt;
                sum = 0;
            }
            if (sum > curLong) {
                curLong = sum;
                longestVal = prevInt;
            }

        }
        StdOut.print(curLong + 1 + " consecutive " + longestVal + "s.");
    }
    

    // 1.5.7
    public static void missingNumber(int n) {
        boolean[] values = new boolean[n];

        StdOut.print("Input Values: ");
        for (int i = 0; i < (n - 1); i++) {
            int value = StdIn.readInt();
            values[value - 1] = true;
        }

        int missing = -1;
        for (int i = 0; i < values.length; i++)
            if (!values[i])
                missing = i + 1;

        StdOut.println();
        StdOut.println("Missing Value: " + missing);
    }







    // UTILITY METHODS

    public static float mean(float[] floats) {
        float sum = 0;
        for (int i = 0; i < floats.length; i++) {
            sum = sum + floats[i];
        }

        return sum / floats.length;
    }

    public static float deviat(float[] floats) {
        float sum = 0;
        float mean = mean(floats);
        for (int i = 0; i < floats.length; i++) {
            sum = sum + (float) Math.pow(mean - floats[i], 2);
        }
        float sqrt = (float) Math.sqrt(sum);
        return sqrt / (floats.length - 1);
    }
}