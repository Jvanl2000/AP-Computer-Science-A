public class section {
    public static void main(String[] args) {
        // System.out.println(cosAndSin(args));
        // isDiv(args);
        // euclideanDistance(args);
        // randomBetween(args);
        // rollDice();
        // betweenDate(args);
        // inOrder(args);
        // dayOfTheWeek(new String[] {"1", "1", "0"});
    }

    private static void dayOfTheWeek(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        System.out.println(d0);
    }

    private static void inOrder(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        boolean result = (((x < y) && (y < z)) || ((x > y) && (y < z)));
        System.out.println(result);
    }

    private static void betweenDate(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        boolean month = -3 <= (m - 6) && 0 >= (m - 6);
        boolean day = ((3 < m) && (m < 6)) || ((m == 3) && (d >= 20)) || ((m == 6) && (d <= 20));

        System.out.println(month && day);
    }

    private static void rollDice() {
        int die1 = randomBetween(new String[] {"1", "6"});
        int die2 = randomBetween(new String[] {"1", "6"});

        System.out.println(die1 + die2);
    }

    private static int randomBetween(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int randomValue = a + (int)(Math.random() * (b - a + 1));

        System.out.println(randomValue);
        return randomValue;
    }

    private static void euclideanDistance(String[] args) {

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        System.out.println(Math.sqrt(x * x + y * y));
    }

    private static void isPossibleTriangle(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        boolean result = ((a < b + c) && (b < a + c) && (c < a + b));
       
        System.out.println(result);
    }

    private static void isDiv(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        boolean result = ((a % b == 0) || (b % a == 0));

        System.out.println(result);
    }

    private static double cosAndSin(String[] args) {
        double x = Double.parseDouble(args[0]);

        return (Math.sin(x) * Math.sin(x)) + (Math.cos(x) * Math.cos(x));
    }
}