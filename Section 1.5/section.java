import java.util.Arrays;
public class section {
    public static void main(String[] args) {
        // maxMin();
        // positiveMaxMin();
        // meanAndDev(2);
        // longestConsec();
        // missingNumber(10);
        // closestPoint(1, 2, 3);
        // drawRandomCirclePointArray(5, 1);
        // rose(6, 100);
        // manyCircles(100, 1, 0.01, 0.05);
        // spinograph(0.021, 0.034, 0.098);
        // drawBouncingBall(new double[] {50, 50}, new double[] {23, -34}, 2);
        // drawGravityBall(new double[] {25, 75}, new double[] {300, 400}, 3, -9.8, 0.55);
        // parityMatrix(4);
        StdDraw.setCanvasSize(600, 600);
        StdDraw.enableDoubleBuffering();
        double[][][] points = spiral(10);
        for (double[][] pent : points) {
            for (int i = 0; i < pent.length; i++) {
                int nextIndex = (i + 1) >= pent.length ? 0 : (i + 1);
                StdDraw.line(pent[i][0], pent[i][1], pent[nextIndex][0], pent[nextIndex][1]);
            }
        }

        StdDraw.show();
        StdOut.println("Image Drawn!");
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

    // 1.5.15
    public static void closestPoint(int x, int y, int z) {
        int[] closestPoint = new int[3];
        double closestDistance = Double.MAX_VALUE;
        StdOut.println("Input x, y, and z values: ");
        while (!StdIn.isEmpty()) {
            int xi = StdIn.readInt();  
            int yi = StdIn.readInt();  
            int zi = StdIn.readInt();  
            StdOut.println("Input x, y, and z values: ");

            if ((Math.pow(x - xi, 2) + Math.pow(y - yi, 2) + Math.pow(z - zi, 2)) < closestDistance) {
                closestDistance = (Math.pow(x - xi, 2) + Math.pow(y - yi, 2) + Math.pow(z - zi, 2));
                closestPoint = new int[] {xi, yi, zi};
            }
        }

        StdOut.println("Closest Point is: " + Arrays.toString(closestPoint));
    }

    //1.5.19
    public static void drawRandomCirclePointArray(int n, double p) {
        double[][] points = generateCirclePointArray(n);

        StdDraw.setCanvasSize(600, 600);
        for (int i = 0; i < points.length; i++) { 
            for (int j = 0; j < points.length; j++) {
                double[] nextPoint = points[j];
                if (Math.random() <= p)
                    StdDraw.line(points[i][0], points[i][1], nextPoint[0], nextPoint[1]);
            }
        }

        StdOut.println("Image Drawn!");
    }

    public static double[][] generateCirclePointArray(int n) {
        double incrementAngle = (2*Math.PI)/n;
        double angle = 0;
        double[][] pointArray = new double[n][2];
        double radi = 0.4;
        for (int i = 0; i < n; i++) {
            pointArray[i] = new double[] {radi * Math.sin(angle)+0.5, radi * Math.cos(angle)+0.5};
            angle = angle + incrementAngle;
        }
        return pointArray;
    }

    // 1.5.21
    public static void rose(int n, int pointAmount) {
        double[][] points = new double[pointAmount][2];
        double increment = 2 * Math.PI / pointAmount;
        double theta = 0;

        for (int i = 0; i < pointAmount; i++) {
            double r = (Math.sin(n * theta))/2;
            points[i][0] = r * Math.sin(theta) + 0.5;
            points[i][1] = r * Math.cos(theta) + 0.5;
            theta = theta + increment;
        }

        StdDraw.setCanvasSize(600, 600);
        for (int i = 0; i < points.length; i++) { 
            int nextIndex = (i + 1) >= points.length ? 0 : (i + 1);
            StdDraw.line(points[i][0], points[i][1], points[nextIndex][0], points[nextIndex][1]);
        }

        StdOut.println("Image Drawn!");
    }

    // 1.5.26
    public static void manyCircles(int numCircles, double p, double min, double max) {
        double[][] points = new double[numCircles][2];
        for (double[] point : points) { point[0] = Math.random(); point[1] = Math.random(); }

        for (double[] point : points) {
            StdDraw.setPenColor(Math.random() <= p ? StdDraw.BLACK : StdDraw.WHITE);
            StdDraw.filledCircle(point[0], point[1], min + (Math.random() * (max - min)));
        }

        StdOut.println("Image Drawn!");
    }

    // 1.5.31
    public static void spinograph(double R, double r, double a) {
        double x, y;
        double[][] xyArray = new double[100_000][2];
        for (int t = 0; t < xyArray.length; t++) {
            x = (R + r) * Math.cos(t / 10.0) - (r + a) * Math.cos((R + r) * ((t / 10.0) / r));
            y = (R + r) * Math.sin(t / 10.0) - (r + a) * Math.sin((R + r) * ((t / 10.0) / r));
            xyArray[t] = new double[] {x + 0.5, y + 0.5};
        } 
        
        StdDraw.setCanvasSize(600, 600);
        for (int i = 0; i < xyArray.length; i++) { 
            int nextIndex = (i + 1) >= xyArray.length ? 0 : (i + 1);
            StdDraw.line(xyArray[i][0], xyArray[i][1], xyArray[nextIndex][0], xyArray[nextIndex][1]);
            // StdDraw.point(xyArray[i][0], xyArray[i][1]);
        }

        StdOut.println("Image Drawn!");
    }

    // 1.5.34
    public static void drawBouncingBall(double[] startPos, double[] startVel, double radius) {
        double[] ballPos = new double[] {startPos[0], startPos[1]};
        double[] ballVel = new double[] {startVel[0], startVel[1]};
        
        StdDraw.setCanvasSize(600, 600);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        int i = 0;
        while (i <= 100_000_000) {
            StdDraw.filledCircle(ballPos[0], ballPos[1], radius);
            gravityBallIncrement(ballPos, ballVel, radius, 0, 1);
            i++;
            // StdDraw.show();
            // StdDraw.pause(30);
        }
        StdDraw.show();
    }

    // 1.5.35
    public static void drawGravityBall(double[] startPos, double[] startVel, double radius, double gravity, double elasticity) {
        double[] ballPos = new double[] {startPos[0], startPos[1]};
        double[] ballVel = new double[] {startVel[0], startVel[1]};
        
        StdDraw.setCanvasSize(600, 600);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        while (true) {
            StdDraw.clear();
            StdDraw.filledCircle(ballPos[0], ballPos[1], radius);
            gravityBallIncrement(ballPos, ballVel, radius, gravity, elasticity);
            StdDraw.show();
            StdDraw.pause(30);
        }
    }

    public static void gravityBallIncrement(double[] locat, double[] vel, double radius, double gravity, double elasticity) {
        double newXV = vel[0];
        double newYV = vel[1] + (1.0/24 * gravity);
        double newX = locat[0] + (1.0/24 * newXV);
        double newY = locat[1] + (1.0/24 * newYV);
        if ((newX + radius) > 100 || (newX - radius) < 0) {
            newXV *= (-1 * elasticity);
            newYV *= elasticity;
            if (((newX + radius) / 100.0) >= 1) newX = (100 - radius);
            else newX = (0 + radius);
        }
        if ((newY + radius) > 100 || (newY - radius) < 0) {
            newYV *= (-1 * elasticity);
            newXV *= elasticity;
            if (((newY + radius) / 100.0) >= 1) newY = (100 - radius);
            else newY = (0 + radius);
        }

        locat[0] = newX;
        locat[1] = newY;
        vel[0] = newXV;
        vel[1] = newYV;
    }

    // S1
    public static double[][] nextShape(double[][] firstShape, int N) {
        double[][] newShape = new double[N][2];
        for (int i = 0; i < N; i++) {
            int e;
            if (i == N - 1) {e = 0;}
             else {e = i + 1;}
            double x0 = firstShape[i][0];
            double y0 = firstShape[i][1];
            double x1 = firstShape[e][0];
            double y1 = firstShape[e][1];
            double newX = x0 + (x1 - x0) / N;
            double newY = y0 + (y1 - y0) / N;
            newShape[i] = new double[] {newX, newY};
        }
        return newShape;
    }

    public static double[][][] spiral(int N) {
        double[][][] shapeArray = new double[1000][N][2];
        shapeArray[0] = generateCirclePointArray(N);
        for (int i = 1; i < shapeArray.length; i++) {
            double[][] newShape = nextShape(shapeArray[i-1], N);
            shapeArray[i] = newShape;
        }
        return shapeArray;
    }

    // S2
    public static void parityMatrix(int n) {
        int x = -1;
        int y = -1;

        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int value = StdIn.readInt();
                sum += value;
                col[j] += value;
            }

            if ((sum % 2.0) != 0) {
                for (int k = 0; k < n; k++) {
                    if ((col[k] % 2) != 0) {
                        if (x == -1) { StdOut.println("This has been CURRUPTED!"); break; }
                    }
                }
            }

            if (x == -1) { StdOut.println("This has NOT been currupted!"); }
            else { StdOut.println("There is an error at [" + x + ", " + y + "]"); }
        }
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
