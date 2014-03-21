/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Danna
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        int row, column;
        int[][] d = {{1, 2, 3, 2, 2}, {4, 5, 6, 5, 6}, {9, 1, 3, 4, 4}, {3, 3, 3, 3, 3}, {1, 5, 6, 7, 4}};
        int x = 5, y = 5;
        Scanner scan = new Scanner(new FileReader("matrix.txt"));
        row = scan.nextInt();
        column = scan.nextInt();
        int[][] m = new int[row][column];

        MatrixClass matrix = new MatrixClass(row, column);
        matrix.setColumn(column);//setam coloana
        matrix.setRow(row); //setam linie

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = scan.nextInt();
            }
        }
        matrix.setMatrix(m);

        for (int i = 0; i < matrix.getRow(); i++) {
            System.out.println("");
            for (int j = 0; j < matrix.getColumn(); j++) {
                System.out.print(matrix.getMatrix()[i][j] + " ");
            }
        }
        System.out.println();

        MatrixClass M = matrix.multiplyingM(x, y, d);
        for (int i = 0; i < M.getRow(); i++) {
            System.out.println("");
            for (int j = 0; j < M.getColumn(); j++) {
                System.out.print(M.getMatrix()[i][j] + " ");
            }
        }
        

    }
}
