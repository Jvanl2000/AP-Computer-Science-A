import java.awt.Color;

public class Turtle {
    private double x, y;  
    private double angle;  
    private boolean down;

    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
        down = true;
    }

    public void turnLeft(double delta) {
        this.angle += delta;
    }

    public void turnRight(double delta) {
        this.angle -= delta;
    }

    public void goForward(double step) {
        double oldx = this.x;
        double oldy = this.y;
        x += step * Math.cos(Math.toRadians(this.angle));
        y += step * Math.sin(Math.toRadians(this.angle));
        if (this.down) StdDraw.line(oldx, oldy, this.x, this.y);
    }

    public void goBack(double step) {
        double oldx = this.x;
        double oldy = this.y;
        x -= step * Math.cos(Math.toRadians(this.angle));
        y -= step * Math.sin(Math.toRadians(this.angle));
        if (this.down) StdDraw.line(oldx, oldy, this.x, this.y);
    }

    public void penDown() {
        this.down = true;
    }

    public void penUp() {
        this.down = false;
    }

    public void switchPen() {
        this.down = !this.down;
    }

    public void walkTo(double x0, double y0) {
        x = x0;
        y = y0;
        if (this.down) StdDraw.line(this.x, this.y, x0, y0);
    }

    public void teleport(double x0, double y0) {
        this.x = x0;
        this.y = y0;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void pause(int t) {
        StdDraw.pause(t);
    }

    public void setColor(Color color) {
        StdDraw.setPenColor(color);
    }
    
    public void setRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }

    public void show() {
        StdDraw.show();
    }

    public static void main(String[] args) {
        // Turtle franklin = new Turtle(0.0, 0.0, 0.0);
        // franklin.setXscale(-400, 400);
        // franklin.setYscale(-400, 400);
        // franklin.teleport(-100, -100);

        // for (int i = 0; i < 6; i++) {
        //     franklin.goForward(40);
        //     franklin.turnRight(360/6);
        // }

        // franklin.teleport(-200, 0);
        // for (int i = 0; i < 6; i++) {
        //     if (i % 2 == 1) {
        //         franklin.penDown();
        //     } else {
        //         franklin.penUp();
        //     }
            
        //     franklin.goBack(40);
        //     franklin.turnLeft(360/6);
        // }

        // int x = 50;
        // int y = 0;
        // franklin.penUp();
        // franklin.walkTo(x, y);
        // franklin.penDown();
        // for (int i = 0; i < 6; i++) {
        //     x -= 10;
        //     y -= 10;
        //     franklin.walkTo(x, y);
        //     franklin.switchPen();
        // }

        int n = 20; 
        int trials = 5000; 
        double step = 0.005; 
        
        Turtle[] turtles = new Turtle[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            turtles[i] = new Turtle(x, y, 0.0);
        }

        for (int t = 0; t < trials; t++) { 
            for (int i = 0; i < n; i++) { 
                turtles[i].turnLeft(StdRandom.uniform(0.0, 360.0));
                turtles[i].goForward(step);
                turtles[i].x = Math.max(0, Math.min(1, turtles[i].getX()));
                turtles[i].y = Math.max(0, Math.min(1, turtles[i].getY()));
            }
        }
    }

}