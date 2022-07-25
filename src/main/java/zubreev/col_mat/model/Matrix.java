package zubreev.col_mat.model;

import java.util.*;

public class Matrix {
    private List<List<Short>> matrix = null;

    private Group rowGroup = new Group();
    private Group columnGroup = new Group();

    public Matrix (){
        matrix = new ArrayList<List<Short>>();
    }

    public Matrix (short[][] matrix){
        List<List<Short>> curMatrix = new ArrayList<>();
        for(short[] row : matrix){
            List<Short> curRow = new ArrayList<>();
            for(short value : row){
                curRow.add(value);
            }
            curMatrix.add(curRow);
        }
        this.matrix = curMatrix;
    }

    public Matrix (List<List<Short>> matrix){
        this.matrix = matrix;
    }

    public void addRow( List<Short> row){
        matrix.add(row);
    }

    public void addColumn( List<Short> column){
        for(int i=0; i<column.size(); i++){
            List<Short> curColumn;
            if(matrix.size()<=i) {
                curColumn = new ArrayList<>();
                matrix.add(curColumn);
            } else{
                curColumn = matrix.get(i);
            }
            curColumn.add(column.get(i));
        }
    }

    public void setValue(DataForChange data){
        matrix.get(data.getRow()).set(data.getColumn(), data.getValue());
    }

    public List<List<Short>> getMatrix() {
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

    public List<Short> getRow( int row ){
        return matrix.get(row);
    }

    public List<Short> getColumn( int column ){
        List<Short> valColumns = new ArrayList<>();
        for(List<Short> curRow : matrix){
            valColumns.add(curRow.get(column));
        }
        return valColumns;
    }

    @Override
    public String toString() {
        StringBuilder strMatrix = new StringBuilder("\n");
        for(List<Short> row : matrix){
            strMatrix.append(row+"\n");
        }
        return "Matrix{" +
                "matrix=" + strMatrix +
                "\nrowGroup=" + rowGroup +
                "\ncolumnGroup=" + columnGroup +
                '}';
    }
}
