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

    // public Rectangle(double x0, double y0, double w, double h) {
    //     this.x0 = x0 - w/2;
    //     this.y0 = y0 - h/2;
    //     this.x1 = x0 + w/2;
    //     this.y1 = y0 + h/2;
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
        StdDraw.rectangle(x, y, width/2, height/2);  
    }

    @Override
    public String toString() {
        return "Rectangle: (x = " + x + ", y = " + y + ", width = " + width + ", height = " + height + ")";
    }

    public static void main(String[] args) {
        int n = 10;
        double min = 0.5;
        double max = 1.0;
        double totalArea = 0.0;
        double totalPerimeter = 0.0;

        for (int i = 0; i < n; i++) {
            double width = Math.random() * (max - min) + min;
            double height = Math.random() * (max - min) + min;
            Rectangle rect = new Rectangle(0.5, 0.5, width, height);

            rect.draw();

            totalArea += rect.area();
            totalPerimeter += rect.perimeter();
        }

        System.out.println("Average area: " + (totalArea / n));
        System.out.println("Average perimeter: " + (totalPerimeter / n));
    }

}