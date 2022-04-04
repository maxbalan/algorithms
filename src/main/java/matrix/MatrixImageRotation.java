package matrix;

/**
 * 13/10/18
 * <p>
 * Given an image represented by N x N matrix, where every pixel of the image is 4 bytes, write a method to rotate
 * the image by 90 degrees. Can you do it in one place?
 * <p>
 * Solution 1:
 * the approach will be to swap edges and so go layer by layer from outermost to innermost
 * top -> right
 * right -> bottom
 * bottom -> left
 * left -> top
 * <p>
 * -------->
 * a | a | a | a
 * /\ b | b | b | b  ||
 * || c | c | c | c  \/
 * d | d | d | d
 * <------
 **/
public class MatrixImageRotation {

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = getMatrix(n);

        printMatrix(matrix);
        printMatrix(rotate(matrix));


        System.out.println();
    }

    // the time function is O(n^2) because we need to touch all the elements in the matrix and there is not a better way
    // to do it
    private static int[][] rotate(int[][] matrix) {
        //will return matrix array if the matrix length is not the same
        if (matrix.length == 0 || matrix.length != matrix[0].length) return matrix;

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) { // n/2 as we need to go only trough layers as the rotation is happening in circles
            int first = i;
            int lastIndex = n - 1 - first;

            for (int j = first; j < lastIndex; j++) {
                int offset = j - first;

                //store temp
                int temp = matrix[first][j]; //store top

                // left -> top
                matrix[first][j] = matrix[lastIndex - offset][first];

                // bot -> left
                matrix[lastIndex - offset][first] = matrix[lastIndex][lastIndex - offset];

                // right -> bottom
                matrix[lastIndex][lastIndex - offset] = matrix[j][lastIndex];

                //top -> right
                matrix[j][lastIndex] = temp;

            }
        }

        return matrix;
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n\t");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[i][j] + " |");
            }
        }

        System.out.println("\n\n\t\t ||");
        System.out.println("\t\t ||");
        System.out.println("\t\t \\/");
    }

    private static int[][] getMatrix(int size) {
        int[][] matrix = new int[size][size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        return matrix;
    }
}
