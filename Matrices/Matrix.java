import java.util.Arrays;

public class Matrix {
    // Class Variables
    public final int numberOfRows;
    public final int numberOfCols;
    public final double[][] values;

    // Provide test cases etc...
    public static void main(String[] args) {
        Matrix mat = new Matrix(new double[][] {{1, 1, 1, 1},
                                                {2, 2, 2, 2},
                                                {1, 1, 1, 1},
                                                {3, -1, 2, -1}});

        Matrix constants = new Matrix(new double[][] {{4},
                                                     {8}, 
                                                     {5}, 
                                                     {7}});

        System.out.println(mat.solveMatrix(constants));
    }

    // Constructor
    public Matrix(double[][] matrix) {
        this.values = matrix;
        this.numberOfRows = matrix.length;
        this.numberOfCols = matrix[0].length;
    }

    // Turns 2D matrix into a string
    @Override
    public String toString() {
        String string = "";
        for (int row = 0; row < this.numberOfRows; row++) {
            string += Arrays.toString(this.values[row]) + "\n";
        }

        return string;
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

        double[][] newArr = new double[this.numberOfRows][other.numberOfCols];

        for (int row = 0; row < this.numberOfRows; row++) 
            for (int col = 0; col < other.numberOfCols; col++)
                newArr[row][col] = dotProduct(this.values[row], other.getCollum(col).values[0]);

        return new Matrix(newArr);
    }

    // Matrices Transposition
    public Matrix transpose() {
        double[][] newArr = new double[this.values[0].length][this.values.length];

        for (int row = 0; row < this.numberOfRows; row++)
            for (int col = 0; col < this.numberOfCols; col++)
                newArr[col][row] = this.values[row][col];

        return new Matrix(newArr);
    }

    // Returns the inverse of the current matrix
    public Matrix inverse() {
        if (this.numberOfRows != this.numberOfCols)
            throw new IllegalArgumentException("Cannot compute the inverse of a non-square matrix");

        Matrix[] matrices = rowReduce(this, generateIdentity(this.numberOfRows));

        return matrices[1];
    }

    private Matrix[] rowReduce(Matrix matrix, Matrix identity) {
        Matrix thisMatrix = matrix.copy();
        Matrix identityMatrix = identity.copy();

        for (int pivot = 0; pivot < thisMatrix.numberOfRows; pivot++) {
            for (int currentRow = pivot + 1; currentRow < thisMatrix.numberOfRows; currentRow++) {
                if (thisMatrix.values[currentRow][pivot] == 0)
                    continue;

                double scalar = -(thisMatrix.values[currentRow][pivot] / thisMatrix.values[pivot][pivot]);

                thisMatrix = inverseOperation(thisMatrix, pivot, currentRow, scalar);
                identityMatrix = inverseOperation(identityMatrix, pivot, currentRow, scalar);
            }
        }

        for (int pivot = thisMatrix.numberOfRows - 1; pivot >= 0; pivot--) {
            for (int currentRow = pivot - 1; currentRow >= 0; currentRow--) {
                if (thisMatrix.values[currentRow][pivot] == 0)
                    continue;
                
                double scalar = -(thisMatrix.values[currentRow][pivot] / thisMatrix.values[pivot][pivot]);

                thisMatrix = inverseOperation(thisMatrix, pivot, currentRow, scalar);
                identityMatrix = inverseOperation(identityMatrix, pivot, currentRow, scalar);
            }
        }

        for (int pivot = 0; pivot < thisMatrix.numberOfRows; pivot++) {
            double scale = 1.0 / thisMatrix.values[pivot][pivot];
            thisMatrix = thisMatrix.multiplyRow(pivot, scale);
            identityMatrix = identityMatrix.multiplyRow(pivot, scale);
        }

        return new Matrix[] {thisMatrix, identityMatrix};
    }

    public Matrix solveMatrix(Matrix constants) {
        return this.inverse().multiply(constants);
    }

    // UTILITY FUNCTIONS
    public Matrix getRow(int row) {
        double[][] newArr = new double[1][this.numberOfCols];

        for (int i = 0; i < this.numberOfCols; i++) 
            newArr[0][i] = this.values[row][i];

        return new Matrix(newArr);
    }

    public Matrix getCollum(int collum) {
        double[][] newArr = new double[1][this.values.length];

        for (int i = 0; i < this.values.length; i++) 
            newArr[0][i] = this.values[i][collum];

        return new Matrix(newArr);
    }

    private double dotProduct(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += (a[i] * b[i]);

        return sum;
    }

    private Matrix generateIdentity(int n) {
        double[][] identityArray = new double[n][n];

        for (int index = 0; index < n; index++)
            identityArray[index][index] = 1;

        return new Matrix(identityArray);
    }

    public Matrix copy() {
        double[][] newArr = new double[this.numberOfRows][this.numberOfCols];

        for (int row = 0; row < this.numberOfRows; row++)
            for (int col = 0; col < this.numberOfCols; col++)
                newArr[row][col] = this.values[row][col];

        return new Matrix(newArr);
    }

    private Matrix inverseOperation(Matrix mat, int rowOne, int rowTwo, double scalar) {
        Matrix newMatrix = mat.copy(); 

        for (int col = 0; col < mat.numberOfCols; col++) {
            newMatrix.values[rowTwo][col] += scalar * mat.values[rowOne][col];
        }

        return newMatrix;
    }

    public Matrix multiplyRow(int row, double scalar) {
        double[][] newArr = new double[this.numberOfRows][this.numberOfCols];

        for (int rowIndex = 0; rowIndex < this.numberOfRows; rowIndex++) {
            for (int col = 0; col < this.numberOfCols; col++) {
                if (rowIndex != row)
                    newArr[rowIndex][col] = this.values[rowIndex][col];
                else
                    newArr[rowIndex][col] = this.values[rowIndex][col] * scalar;
            }
        }
        
        return new Matrix(newArr);
    }
}