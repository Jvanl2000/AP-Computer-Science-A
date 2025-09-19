public class section {
    public static void main(String[] args) {
        // cosAndSin(args);
        // isDiv(args);
        // euclideanDistance(args);
        // randomBetween(args);
        // rollDice();
        // betweenDate(args);
        // inOrder(args);
        // polarCoordinates(new String[] {"5.6", "20.1"});
        // dayOfTheWeek(new String[] {"1", "1", "0"});
        // greatCircle(new String[] {"48.87", "2.33", "37.8", "122.4"});
        // threeSort(new String[] {"64", "87", "-8"});
        // dragonCurve();
        // greaterValue(new String[] {"8", "-52"});
        // lesserValue(new String[] {"8", "-52"});
        // tripleGreaterValue(new String[] {"-8", "1", "6"});
    }

    private static void tripleGreaterValue(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int r = Integer.parseInt(args[2]);

        int greaterNumber = (int) ((((p + q + Math.abs(p - q)) / 2.0) + r + Math.abs(((p + q + Math.abs(p - q)) / 2.0) - r)) / 2.0);

        System.out.println(greaterNumber);
    }

    private static void lesserValue(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        int lesserNumber = (int) ((2 * ((p + q) / 2.0)) - (((p + q) / 2.0) + ((Math.abs(p - q)) / 2.0)));
    
        System.out.println(lesserNumber);
    }

    private static void greaterValue(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        int greaterNumber = (int) (((p + q) / 2.0) + ((Math.abs(p - q)) / 2.0));

        System.out.println(greaterNumber);
    }

    private static void dragonCurve() {
        System.out.println("F");
        System.out.println("FLF");
        System.out.println("FLFLFRF");
        System.out.println("FLFLFRFLFLFRFRF");
        System.out.println("FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRF");
        System.out.println("FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRFLFLFLFRFLFLFRFRFRFLFLFRFRFLFRFRF");
    }

    private static void threeSort(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int max = Math.max(a, Math.max(b, c));
        int mid = Math.max(a, Math.min(b, c));
        int min = Math.min(a, Math.min(b, c));

        System.out.println(max + ", " + mid + ", " + min);
    }

    private static void greatCircle(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double sinProduct = Math.sin(x1) * Math.sin(x2);
        double cosProduct = Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2); 

        double distance = 60 * Math.toDegrees(Math.acos(sinProduct + cosProduct));

        System.out.println(distance);
    }

    private static void polarCoordinates(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);

        System.out.println(r + ", " + theta);
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

    private static void cosAndSin(String[] args) {
        double x = Double.parseDouble(args[0]);

        System.out.println((Math.sin(x) * Math.sin(x)) + (Math.cos(x) * Math.cos(x)));
    }
}