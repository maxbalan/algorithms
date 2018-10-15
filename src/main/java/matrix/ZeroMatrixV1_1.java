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
 *
 * @author Maxim Balan
 **/
public class ZeroMatrixV1_1 {

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
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < row.length; i++) {
            for (int j=0; j< column.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        replaceRow(row, matrix);
        replaceColumn(column, matrix);
    }

    private static void replaceRow(boolean[] row, int[][] matrix) {
        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(matrix, i);
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i <matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }


    private static void replaceColumn(boolean[] column, int[][] matrix) {
        for (int i = 0; i < column.length; i++) {
            if (column[i])
                nullifyColumn(matrix, i);
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i <matrix.length; i++) {
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
