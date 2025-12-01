import java.util.Arrays;

public class Matrix {
    public final int numberOfRows;
    public final int numberOfCols;
    public final double[][] values;

    public static void main(String[] args) {
        Matrix mat = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.deepToString(mat.values));
        System.out.println(mat.numberOfRows);
        System.out.println(mat.numberOfCols);
    }

    public Matrix(double[][] matrix) {
        this.values = matrix;
        this.numberOfRows = matrix.length;
        this.numberOfCols = matrix[0].length;
    }
}