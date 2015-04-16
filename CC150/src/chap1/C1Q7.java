package chap1;

import CtCILibrary.*;

/**
 * Write an algorithm such that if an element in an M*N matrix is 0,
 * its entire row and column are set to 0.
 */

public class C1Q7 {
    private static void setZero(int[][] matrix) {
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(rowZero[i]) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(colZero[j]) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] matrix = AssortedMethods.randomMatrix(n, m, 0, 9);
        AssortedMethods.printMatrix(matrix);
        setZero(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}
