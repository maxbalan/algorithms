package matrix;

/**
 * 14/10/18
 *
 * Write an algorithm such that if an element in an M x N matrix is 0, its entire row and column are set to 0
 *
 * Solution 1:
 *
 * the idea is to have 2 vectors with boolean for columns and rows and every time we find a zero we set a flag to true
 * that is equal to the row and column.
 *
 * this algorithm works fine so the time function is O(N x M) where N and M are the rows and columns and the space
 * function is O(N x M) as we have 2 vectors with flags.
 *
 * Solution 2:
 *
 * even if the solution 1 does ok, there is still something we can do about space function, we can't do anything about
 * time function as we have to touch every entry in the matrix
 *
 * so to optimize the space function we can do the following instead of storing the zero's exact position in the matrix
 * we can just set the first row an column with zero for each zero we find and if the first row and column has zero
 * we cna set a simple flag.
 *
 *
 * @author Maxim Balan
 **/
public class ZeroMatrixV1_2 {

    public static void main(String[] args) {
        int column = 4;
        int row = 6;

        int[][] matrix = getMatrix(column, row);
        setZero(2, 2, matrix);
        setZero(column-1, row-2, matrix);

        printMatrix(matrix);
        zeroMatrix(matrix);
        printMatrix(matrix);


    }

    private static void zeroMatrix(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j=0; j< matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        rowHasZero = true;
                        columnHasZero = true;
                    } else if (i == 0) rowHasZero = true;
                    else if (j == 0) columnHasZero = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //now nullify rows
        for (int i = 0; i< matrix.length; i++) {
            if (matrix[i][0] == 0 && i != 0)
                nullifyRow(matrix, i);
        }

        //now nullify column
        for (int i = 0; i< matrix[0].length; i++) {
            if (matrix[0][i] == 0 && i != 0)
                nullifyColumn(matrix, i);
        }

        //nullify first row
        if (rowHasZero) nullifyRow(matrix, 0);
        if (columnHasZero) nullifyColumn(matrix, 0);
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i=0; i < matrix.length; i++) {
            System.out.println("\n\t");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " |");
            }
        }

        System.out.println("\n\n\t\t ||");
        System.out.println("\t\t ||");
        System.out.println("\t\t \\/");
    }

    private static void setZero(int x, int y, int[][] matrix) {
        matrix[x][y] = 0;
    }

    private static int[][] getMatrix(int column, int row) {
        int[][] matrix = new int[column][row];
        int counter = 0;
        for (int i=0; i < column; i++) {
            for(int j=0; j < row; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        return matrix;
    }

}
