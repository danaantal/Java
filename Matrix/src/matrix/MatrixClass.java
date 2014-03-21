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

    private int row, column, r;
    private int[] vector;
    private int[][] matrix;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public MatrixClass(int r1) {
        r = r1;
        vector = new int[r];
    }

    public MatrixClass(int r, int c) {
        row = r;
        column = c;
        matrix = new int[row][column];

    }

    public MatrixClass(MatrixClass M) {
        M = this;
    }

    public void display() {
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }       
        }
        System.out.println();
    }

    public int[][] addingNo(int x) { //adunam numar
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                matrix[i][j] += x;
            }
        }
        return matrix;
    }

    public int[][] decreasingNo(int x) { //scadem numar
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                matrix[i][j] -= x;
            }
        }
        return matrix;
    }

    public int[][] addingM(int r, int c, int[][] m) throws Exception { //adaugam matrice
        m = new int[r][c];
        if (r != row && c != column) {
            throw new Exception();
        } else {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    matrix[i][j] += m[i][j];
                }
            }
        }
        return matrix;
    }

    public int[][] decreasingM(int r, int c, int[][] m) throws Exception { //scadem matrice
        m = new int[r][c];
        if (r != row && c != column) {
            throw new Exception();
        } else {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    matrix[i][j] -= m[i][j];
                }
            }
        }
        return matrix;
    }

    public int[][] identity() { //matricea identica
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public int[][] multiplyingNo(int x) throws Exception { //inmultim cu numar

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                matrix[i][j] *= x;
            }
        }
        return matrix;
    }

    public MatrixClass multiplyingM(int r, int c, int[][] m) throws Exception { //inmultim cu matrice
        MatrixClass result = new MatrixClass(c, row);
        if (c != row) {
            throw new Exception();
        } else {
            for (int i = 0; i < result.column; i++) {
                for (int j = 0; j < result.row; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        result.matrix[i][j] += (matrix[i][k] * m[k][j]);
                    }
                }
            }
            return result;
        }

    }
}
