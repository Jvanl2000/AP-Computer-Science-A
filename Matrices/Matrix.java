
public class Matrix {
    // Class Variables
    public final int numberOfRows;
    public final int numberOfCols;
    public final double[][] values;

    // Provide test cases etc...
    public static void main(String[] args) {
        Matrix mat = new Matrix(new double[][] {{0.386, 99, 1.0001, 4.8},
                                                {55, -4, -0.1, 0},
                                                {8, 8, 9.86, 2.8},
                                                {3.14159, 21.418, 38.223, 0}});

        System.out.println(Arrays.deepToString(mat.values));
        System.out.println(mat.numberOfRows);
        System.out.println(mat.numberOfCols);
    }

    // Constructor
    public Matrix(double[][] matrix) {
        this.values = matrix;
        this.numberOfRows = matrix.length;
        this.numberOfCols = matrix[0].length;
    }

    // Scalar Multiplication
    public Matrix scalarMultiplication(double scaler) {
        double[][] newArr = new double[this.values.length][this.values[0].length];
        for (int row = 0; row < numberOfRows; row++) 
            for (int col = 0; col < numberOfCols; col++)
                newArr[row][col] = this.values[row][col] * scaler;

        return new Matrix(newArr);
    }

    // Matrices Addition
    public Matrix add(Matrix other) {
        if (this.values.length != other.values.length || this.values[0].length != other.values[0].length) {
            throw new IllegalArgumentException(
                "Matrix dimension mismatch: cannot add a " +
                this.values.length + "x" + this.values[0].length +
                " matrix with a " +
                other.values.length + "x" + other.values[0].length +
                " matrix."
            );
        }

        double[][] newArr = new double[this.values.length][this.values[0].length];
        for (int row = 0; row < numberOfRows; row++) 
            for (int col = 0; col < numberOfCols; col++)
                newArr[row][col] = this.values[row][col] + other.values[row][col];

        return new Matrix(newArr);
    }

    // Matrices Subtraction
    public Matrix subtract(Matrix other) {
        if (this.values.length != other.values.length || this.values[0].length != other.values[0].length) {
            throw new IllegalArgumentException(
                "Matrix dimension mismatch: cannot subtract a " +
                this.values.length + "x" + this.values[0].length +
                " matrix with a " +
                other.values.length + "x" + other.values[0].length +
                " matrix."
            );
        }

        double[][] newArr = new double[this.values.length][this.values[0].length];
        for (int row = 0; row < numberOfRows; row++) 
            for (int col = 0; col < numberOfCols; col++)
                newArr[row][col] = this.values[row][col] - other.values[row][col];

        return new Matrix(newArr);
    }

    // Matrices Multiplication
    public Matrix multiply(Matrix other) {
        if (this.values[0].length != other.values.length) {
            throw new IllegalArgumentException(
                "Matrix dimension mismatch: cannot multiply a " +
                this.values.length + "x" + this.values[0].length +
                " matrix with a " +
                other.values.length + "x" + other.values[0].length +
                " matrix."
            );
        }

        double[][] newArr = new double[this.values.length][this.values[0].length];

        for (int row = 0; row < this.numberOfRows; row++) 
            for (int col = 0; col < this.numberOfCols; col++)
                newArr[row][col] = matrixMultiplicationSum(this.values[row], getCollum(other.values, col));

        return new Matrix(newArr);
    }

    private double matrixMultiplicationSum(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += (a[i] * b[i]);

        return sum;
    }

    private double[] getCollum(double[][] a, int collum) {
        double[] newArr = new double[a.length];

        for (int i = 0; i < a.length; i++) 
            newArr[i] = a[i][collum];

        return newArr;
    }

    // Matrices Transposition
    public Matrix transpose() {
        double[][] newArr = new double[this.values[0].length][this.values.length];

        for (int row = 0; row < this.numberOfRows; row++)
            for (int col = 0; col < this.numberOfCols; col++)
                newArr[col][row] = this.values[row][col];

        return new Matrix(newArr);
    }

    public Matrix inverse() {
        if (this.numberOfRows != this.numberOfCols)
            throw new IllegalArgumentException("Cannot compute the inverse of a non-square matrix");

        return new Matrix(this.values);
    }

    private double determinate(Matrix mat) {
        if (mat.values.length == 2)
            return (mat.values[0][0] * mat.values[1][1]) - (mat.values[0][1] * mat.values[1][0]);

        double deter = 0;

        for (int i = 0; i < mat.values.length; i++) {
            double[][] newArr = new double[mat.values.length - 1][mat.values[0].length - 1];
            for (int row = 0; row < mat.values.length; row++) {
                for (int col = 0; col < mat.values[0].length; col++) {
                    if (col != i && row != 0) {
                        if (col < i) { newArr[row - 1][col] = mat.values[row][col]; }
                        else { newArr[row - 1][col - 1] = mat.values[row][col]; }
                    }
                }
            }

            if (i % 2 == 0) { deter += (mat.values[0][i] * determinate(new Matrix(newArr))); }
            else { deter -= (mat.values[0][i] * determinate(new Matrix(newArr))); }
        }

        return deter;
    }
}