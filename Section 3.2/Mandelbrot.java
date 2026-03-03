import java.awt.Color;

public class Mandelbrot {

    public static int numIters(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static void main(String[] args)  {
        
        double xc = -0.5;
        double yc = 0;
        double size = 2;

        int n   = 700; 
        int max = 255; 

        Picture picture = new Picture(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double x0 = xc - size/2 + size*i/n;
                double y0 = yc - size/2 + size*j/n;
                Complex z0 = new Complex(x0, y0);
                int iter = numIters(z0, max);
                Color color = new Color(iter == max ? Math.abs((int)((Math.sin(z0.abs())) * 255)) : iter % 8 * 32, 
                                        iter == max ? Math.abs((int)((Math.cos(z0.real())) * 255)) : iter % 16 * 16, 
                                        iter == max ? Math.abs((int)((Math.sin(z0.imaginary())) * 255)) : iter % 32 * 8);
                picture.set(i, n-1-j, color);
            }
        }
        
        picture.show();
        
    }
}