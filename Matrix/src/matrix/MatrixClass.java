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
    public MatrixClass(int[][] matrix1) {
        if (matrix1.length == 0) {
            throw new IllegalArgumentException("Nu poate fi creata o matrice goala");
        }
        /*
         * verificm daca fiecare linie a matricei are acelasi numar de elemente
         */
        int nrC = matrix1[0].length;
        for (int i = 1; i < matrix1.length; i++) {
            if (matrix1.length != nrC) {
                throw new IllegalArgumentException("Incorrect!");
            }
            nrC = matrix1[i].length;
        }
        this.matrix = matrix1;
        this.row = matrix1.length;
        this.column = matrix1[0].length;
    }

    public MatrixClass(MatrixClass M, int rowM, int columnM) { //costructor de clonare
        this.matrix = M.matrix;
        this.row = M.row;
        this.column = M.column;
        for (int i = 0; i < this.matrix.length; i++) {
            System.arraycopy(M.matrix[i], 0, this.matrix[i], 0, this.matrix[i].length);
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
            for (int j = 0; j < this.matrix[i].length; j++) {
                result.matrix[i][j] = matrix[i][j] + x;
            }
        }
        return result;
    }

    public MatrixClass decreasingNo(int x) { //scadem numar
        MatrixClass result = new MatrixClass(row, column);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
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
                for (int j = 0; j < this.matrix[i].length; j++) {
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
                for (int j = 0; j < this.matrix[i].length; j++) {
                    result.matrix[i][j] = matrix[i][j] - m[i][j];
                }
            }
        }
        return result;
    }

    public MatrixClass identity() {
        for (int[] matrix1 : this.matrix) {
            for (int j = 0; j < this.matrix.length; j++) {
                matrix1[j] = 1;
            }
        }
        return this;
    }

    public MatrixClass multiplyingNo(int x) throws Exception { //inmultim cu numar
        MatrixClass result = new MatrixClass(row, column);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
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

    public int determinant(int[][] m) {
        int result = 0;
        if (this.matrix.length == 2) {
            result = this.matrix[0][0] * this.matrix[1][1] - this.matrix[1][0] * this.matrix[0][1];
        
        return result;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                MatrixClass temporar = new MatrixClass(matrix);
                result += Math.pow(-1, i + j) * determinant(temporar.matriceFara(i, j));
            }
        }
        return result;
    }

    public int[][] matriceFara(int r, int c) { //returnam matricea fara un rand si o coloana specificata
        int[][] temporar = new int[matrix.length - 1][matrix[0].length - 1];
        int k = 0;
        int l = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (r != i) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (c != j) {
                        temporar[k][l] = matrix[i][j];
                        l++;
                    }
                }
                k++;
                l = 0;
            }
        }

        return temporar;
    }
    
    

}
