package chap1;
import CtCILibrary.*;

/**
 * Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class C1Q6 {
    private static void rotate(int[][] matrix, int n) {

        for(int initPoint = 0; initPoint < n / 2; initPoint++) {
            int len = n - 2 * initPoint;
            for(int termPoint = initPoint; termPoint - initPoint + 1 < len; termPoint++) {
                int temp = matrix[initPoint][termPoint];
                matrix[initPoint][termPoint] = matrix[n - 1 - termPoint][initPoint];
                matrix[n - 1 - termPoint][initPoint] = matrix[n - 1 - initPoint][n - 1 - termPoint];
                matrix[n - 1 - initPoint][n - 1 - termPoint] = matrix[termPoint][n - 1 - initPoint];
                matrix[termPoint][n - 1 - initPoint] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = AssortedMethods.randomMatrix(n, n, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotate(matrix, n);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}
