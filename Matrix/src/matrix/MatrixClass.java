/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Arrays;

/**
 *
 * @author Danna
 */
public class MatrixClass implements IMatrix{

    private int row, column, r;
    private int[] vector;
    private int[][] matrix;

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
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

    @Override
    public int[][] getMatrix() {
        return matrix;
    }

    @Override
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

    public MatrixClass(MatrixClass M) { //costructor de clonare
        this.matrix = M.matrix;
        this.row = M.row;
        this.column = M.column;
        for (int i = 0; i < this.matrix.length; i++) {
            System.arraycopy(M.matrix[i], 0, this.matrix[i], 0, this.matrix[i].length);
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public MatrixClass addingNo(int x) { //adunam numar
        MatrixClass result = new MatrixClass(row, column);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                result.matrix[i][j] = matrix[i][j] + x;
            }
        }
        return result;
    }

    @Override
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

    
    public int determinant(int[][] m){
        int result = 0;
        
        if(m.length == 0){
            throw new IllegalArgumentException("Matrice vida");
        }
        
        if(m.length == 1){
            result = m[0][0];
            return result; 
            
        }
        
        if(m.length == 2){
            result = m[0][0] * m[1][1] - m[0][1] * m[1][0];
            return result;
        }
        
        for (int i = 0; i < m.length; i++) {
            int temp[][] = new int[m.length - 1][m[0].length - 1];

            for (int j = 1; j < m[0].length; j++) {
                System.arraycopy(m[j], 0, temp[j - 1], 0, i);
                System.arraycopy(m[j], i + 1, temp[j - 1], i, m[0].length - i - 1);
            }

            result += m[0][i] * Math.pow(-1, i) * determinant(temp);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.row;
        hash = 71 * hash + this.column;
        hash = 71 * hash + this.r;
        hash = 71 * hash + Arrays.deepHashCode(this.matrix);
        hash = 71 * hash + this.vector.hashCode();
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatrixClass other = (MatrixClass) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.r != other.r) {
            return false;
        }
        if (!Arrays.equals(this.vector, other.vector)) {
            return false;
        }
        return Arrays.deepEquals(this.matrix, other.matrix);
    }

    @Override
    public String toString() {
        return "MatrixClass{" + "row=" + row + ", column=" + column + ", matrix=" + matrix + '}';
    }
    
    
}
