/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author dana.antal
 */
public interface IMatrix {
    
    public int getRow();
    public void setRow(int row);
    public int getColumn();
    public void setColumn(int column);
    public int getR();
    public void setR(int r);
    public int[] getVector();
    public void setVector(int[] vector);
    public int[][] getMatrix();
    public void setMatrix(int[][] matrix);
    
    
    
    public void display();
    public MatrixClass addingNo(int x);
    public MatrixClass decreasingNo(int x);
    public MatrixClass addingM(int r, int c, int[][] m) throws Exception;
    public MatrixClass decreasingM(int r, int c, int[][] m) throws Exception;
    public MatrixClass identity();
    public MatrixClass multiplyingNo(int x) throws Exception;
    public MatrixClass multiplyingM(int r, int c, int[][] m) throws Exception;
    public MatrixClass transpose();
    public int determinant(int[][] m);
}
