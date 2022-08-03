package zubreev.col_mat.model;

import java.util.*;

public class Matrix {
    private List<List<Cell>> matrix = null;

    private Group rowGroup = new Group();
    private Group columnGroup = new Group();

    public Matrix (){
        matrix = new ArrayList<List<Cell>>();
    }

    public Matrix (Cell[][] matrix){
        List<List<Cell>> curMatrix = new ArrayList<>();
        for(Cell[] row : matrix){
            List<Cell> curRow = new ArrayList<>();
            for(Cell cell : row){
                curRow.add(cell);
            }
            curMatrix.add(curRow);
        }
        this.matrix = curMatrix;
    }

    public Matrix (List<List<Cell>> matrix){
        this.matrix = matrix;
    }

    public void addRow( List<Cell> row){
        matrix.add(row);
    }

    public void addColumn( List<Cell> column){
        for(int i=0; i<column.size(); i++){
            List<Cell> curColumn;
            if(matrix.size()<=i) {
                curColumn = new ArrayList<>();
                matrix.add(curColumn);
            } else{
                curColumn = matrix.get(i);
            }
            curColumn.add(column.get(i));
        }
    }

    public void setValue(int row, int column, Cell data){
        matrix.get(row).set(column, data);
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public Group getColumnGroup() {
        return columnGroup;
    }

    public void setColumnGroup(Group columnGroup) {
        this.columnGroup = columnGroup;
    }

    public Group getRowGroup() {
        return rowGroup;
    }

    public void setRowGroup(Group rowGroup) {
        this.rowGroup = rowGroup;
    }

    public Integer getNumOfRow(){
        return matrix.size();
    }

    public Integer getNumOfColumn(){
        return matrix.get(0).size();
    }

    public List<Cell> getRow( int row ){
        return matrix.get(row);
    }

    public List<Cell> getColumn( int column ){
        List<Cell> valColumns = new ArrayList<>();
        for(List<Cell> curRow : matrix){
            valColumns.add(curRow.get(column));
        }
        return valColumns;
    }

    @Override
    public String toString() {
        StringBuilder strMatrix = new StringBuilder("\n");
        for(List<Cell> row : matrix){
            strMatrix.append(row+"\n");
        }
        return "Matrix{" +
                "matrix=" + strMatrix +
                "\nrowGroup=" + rowGroup +
                "\ncolumnGroup=" + columnGroup +
                '}';
    }
}
