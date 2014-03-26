/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

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
     * @throws java.io.FileNotFoundException
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
        for (int[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                m1[j] = scan.nextInt();
            }
        }
        matrix.setMatrix(m);
        matrix.display();
        
        System.out.println(matrix.determinant(m));
        
        MatrixClass H = matrix.addingM(x, y, d);
        H.display();
        
        MatrixClass I = matrix.addingNo(x);
        I.display();
        
        MatrixClass J = matrix.decreasingM(x, y, d);
        J.display();
        
        MatrixClass K = matrix.decreasingNo(x);
        K.display();
        
        MatrixClass L = matrix.multiplyingNo(x);
        L.display();

        MatrixClass M = matrix.multiplyingM(x, y, d);
        M.display();

        MatrixClass N = matrix.transpose();
        N.display();

        MatrixClass O = matrix.multiplyingNo(y);
        O.display();
        
        MatrixClass P = matrix.addingM(x, y, d);
        P.display();
        
        MatrixClass Q = matrix.identity();
        Q.display();
        
        

    }
}
