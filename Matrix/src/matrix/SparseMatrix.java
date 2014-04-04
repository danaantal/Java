/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author dana.antal
 */
public abstract class SparseMatrix implements IMatrix {
    private int[] diagonal;
    private int[] column;  
    private int[] nonzero;

    public int[] getDigonal() {
        return diagonal;
    }

    public int[] getColumn() {
        return column;
    }

    public int[] getNonzero() {
        return nonzero;
    }

    public void setDigonal(int[] diagonal) {
        this.diagonal = diagonal;
    }

    public void setColumn(int[] column) {
        this.column = column;
    }

    public void setNonzero(int[] nonzero) {
        this.nonzero = nonzero;
    }


    public SparseMatrix(int[] r, int[] c, int[] n) {
        this.diagonal = r;
        this.column= c;
        this.nonzero = n;       
        }
    

    /*@Override
    public void display() {
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }*/

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
    public int determinant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
