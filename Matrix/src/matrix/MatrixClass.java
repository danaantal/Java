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

    public MatrixClass(MatrixClass M, int rowM, int columnM) { //costructor de clonare
        this.matrix = M.matrix;
        this.row = M.row;
        this.column = M.column;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
              this.matrix[i][j] = M.matrix[i][j];
            }
        }
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

    public MatrixClass addingNo(int x) { //adunam numar
        MatrixClass result = new MatrixClass(row, column);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.matrix[i][j] = matrix[i][j] + x;
            }
        }
        return result;
    }

    public MatrixClass decreasingNo(int x) { //scadem numar
        MatrixClass result = new MatrixClass(row, column);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
               result.matrix[i][j] = matrix[i][j] - x;
            }
        }
        return result;
    }

    public MatrixClass addingM(int r, int c, int[][] m) throws Exception { //adaugam matrice
        MatrixClass result = new MatrixClass(row, column);      
        if (r != row && c != column) {
            throw new Exception();
        } else {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    result.matrix[i][j] = matrix[i][j] + m[i][j];
                }
            }
        }
        return result;
    }

    public MatrixClass decreasingM(int r, int c, int[][] m) throws Exception { //scadem matrice
        MatrixClass result = new MatrixClass(row, column); 
        if (r != row && c != column) {
            throw new Exception();
        } else {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    result.matrix[i][j] = matrix[i][j] - m[i][j];
                }
            }
        }
        return result;
    }

    public MatrixClass identity() { //matricea identica
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                this.matrix[i][j] = 1;
            }
        }
        return this;
    }

    public MatrixClass multiplyingNo(int x) throws Exception { //inmultim cu numar
        MatrixClass result = new MatrixClass(row, column);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.matrix[i][j] = matrix[i][j] * x;
            }
        }
        return result;
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

    public MatrixClass transpose() { //matricea transpusa
        MatrixClass result = new MatrixClass(column, row);
        for (int i = 0; i < result.row; i++) {
            for (int j = 0; j < result.column; j++) {
                result.matrix[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public int determinat() {
        int result = 0;
        
        return result;
    }
}
