/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author Danna
 */
public class MatrixClass {

    int row, column, r;
    int[] vector = new int[r];
    int[][] matrix = new int[row][column];

    public MatrixClass(int r1) {
        r = r1;
        int[] vector1 = new int[r1];
        
        for(int i : vector1){
            vector[i] = vector1[i];
        }
    }

    public MatrixClass(int r, int c) {
        row = r;
        column = c;
        int[][] matrix1 = new int[r][c];
        
        for(int[] i : matrix1){
            for(int j : i){
                matrix[j] = matrix1[j];
            }
        }

    }
}
