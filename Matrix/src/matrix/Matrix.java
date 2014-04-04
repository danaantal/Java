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
        int[][] e = {{1, 2}, {2, 2}};
        int[][] f = {{1}};
        int x = 5, y = 5;
        Scanner scan = new Scanner(new FileReader("matrix.txt"));
        row = scan.nextInt();
        column = scan.nextInt();
        int[][] m = new int[row][column];

        IMatrix matrix = new MatrixClass(row, column);
        matrix.setColumn(column);//setam coloana
        matrix.setRow(row); //setam linie
        for (int[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                m1[j] = scan.nextInt();
            }
        }
        System.out.print("Matricea initiala: ");
        matrix.setMatrix(m);
        matrix.display();
        System.out.println("Matrice clona: ");
        IMatrix O = new MatrixClass((MatrixClass) matrix);
        O.display();
        System.out.println("Matrice rara 0: ");


        System.out.print("Adaugam matrice: ");
        MatrixClass H = matrix.addingM(x, y, d);
        H.display();
        System.out.print("Adaugam numar: ");
        MatrixClass I = matrix.addingNo(x);
        I.display();
        System.out.print("Scadem matrice: ");
        MatrixClass J = matrix.decreasingM(x, y, d);
        J.display();
        System.out.print("Scadem numar: ");
        MatrixClass K = matrix.decreasingNo(x);
        K.display();
        System.out.print("Multiplicam cu numar: ");
        MatrixClass L = matrix.multiplyingNo(x);
        L.display();
        System.out.print("Multiplicam cu matrice: ");
        MatrixClass M = matrix.multiplyingM(x, y, d);
        M.display();
        System.out.print("Matricea transpusa: ");
        MatrixClass N = matrix.transpose();
        N.display();
        System.out.print("Adaugam matrice: ");
        MatrixClass P = matrix.addingM(x, y, d);
        P.display();
        System.out.print("Identitate: ");
        MatrixClass Q = matrix.identity();
        Q.display();

        MatrixClass matrix1 = new MatrixClass(d);
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < column; j++) {
                System.out.print(d[i][j] + " ");
            }
        }
        System.out.println();

        System.out.println("Determinantul matricii este:  " + matrix1.determinant());

        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < column; j++) {
                System.out.print(d[i][j] + " ");
            }
        }
        System.out.println();

    }
}
