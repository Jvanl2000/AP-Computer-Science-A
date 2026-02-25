/*

API

public class Rectangle {
    public Rectangle(double x0, double y0, double w, double h)
    public double area()
    public double perimeter()
    public boolean contains(Rectangle b)
    public void draw()
    public String toString()
}

*/

public class Rectangle {

    private final double x, y;
    private final double width;
    private final double height; 

    public Rectangle(double x0, double y0, double w, double h) {
        x = x0;
        y = y0;
        width = w;
        height = h;
    }

    // public Rectangle(double x1, double y1, double x2, double y2) {
    //     this.x = Math.min(x1, x2);
    //     this.y = Math.min(y1, y2);
    //     this.width = Math.abs(x2 - x1);
    //     this.height = Math.abs(y2 - y1);
    // }

    public double area() { 
        return width * height; 
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public boolean contains(Rectangle b) { 
        return (b.x >= this.x) && (b.y >= this.y) &&
               (b.x + b.width <= this.x + this.width) &&
               (b.y + b.height <= this.y + this.height);
    }
    
    public void draw() { 
        StdDraw.rectangle(x + width/2, y + height/2, width/2, height/2);  
    }

    @Override
    public String toString() {
        return "Rectangle: (x = " + x + ", y = " + y + ", width = " + width + ", height = " + height + ")";
    }

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);

        int n = 5;
        double min = 0.0;
        double max = 100.0;

        double totalArea = 0.0;
        double totalPerimeter = 0.0;

        for (int i = 0; i < n; i++) {
            double x = Math.random() * (max - min) + min;
            double y = Math.random() * (max - min) + min;
            double w = Math.random() * (max - x);
            double h = Math.random() * (max - y);

            Rectangle rect = new Rectangle(x, y, w, h);
            totalArea += rect.area();
            totalPerimeter += rect.perimeter();

            rect.draw();
        }

        System.out.println("Average area: " + (totalArea / n));
        System.out.println("Average perimeter: " + (totalPerimeter / n));
    }

}