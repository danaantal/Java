/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author dana.antal
 */
public class SparseMatrix {
    private int row, column;  
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

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public SparseMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public SparseMatrix(){
        
    }
}
