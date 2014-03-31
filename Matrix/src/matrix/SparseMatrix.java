/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author dana.antal
 */
public class SparseMatrix implements IMatrix {
    private int row, column;  
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

    @Override
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     *
     * @param matrix
     */
    @Override
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public SparseMatrix(int r, int c) {
        this.row = r;
        this.column= c;
        matrix = new int[row][column];
        for(int i=0;i<this.matrix.length;i++){
            for(int j=0;j<this.matrix[i].length;j++){
                this.matrix[i][j] = 0;
            }
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
    public MatrixClass addingNo(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass decreasingNo(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass addingM(int r, int c, int[][] m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass decreasingM(int r, int c, int[][] m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass identity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass multiplyingNo(int x) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass multiplyingM(int r, int c, int[][] m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixClass transpose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int determinant(int[][] m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
