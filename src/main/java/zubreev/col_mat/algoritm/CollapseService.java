package zubreev.col_mat.algoritm;

import zubreev.col_mat.model.Cell;
import zubreev.col_mat.model.DataForChange;
import zubreev.col_mat.model.Group;
import zubreev.col_mat.model.Matrix;

public class CollapseService {

    public static Matrix collapsingMatrixByRow(Matrix matrix){
        Matrix newMatrix = new Matrix();
        newMatrix.setRowGroup((Group) matrix.getRowGroup().clone());
        newMatrix.setColumnGroup((Group) matrix.getColumnGroup().clone());
        Group rowGroup = newMatrix.getRowGroup();
        Group columnGroup = newMatrix.getColumnGroup();


        for(int i=0; i<matrix.getNumOfRow();i++){
            if(i==0) {
                newMatrix.addRow(matrix.getRow(i));
            }
            else{
                boolean addToGroup = false;
                for(int k=i-1; k>=0; k--){
                    if(matrix.getRow(k).equals( matrix.getRow(i) )){
                        rowGroup.addValue(k, i);
                        addToGroup = true;
                        break;
                    }
                }
                if( ! addToGroup) {
                    newMatrix.addRow(matrix.getRow(i));
                }
            }
        }
        return newMatrix;
    }

    public static Matrix collapsingMatrixByColumn(Matrix matrix){
        Matrix newMatrix = new Matrix();
        newMatrix.setRowGroup((Group) matrix.getRowGroup().clone());
        newMatrix.setColumnGroup((Group) matrix.getColumnGroup().clone());
        Group rowGroup = newMatrix.getRowGroup();
        Group columnGroup = newMatrix.getColumnGroup();

        for(int i=0; i<matrix.getNumOfColumn(); i++){
            if(i==0) {
                newMatrix.addColumn(matrix.getColumn(i));
            }
            else{
                boolean addToGroup = false;
                for(int k=i-1; k>=0; k--){
                    if(matrix.getColumn(k).equals( matrix.getColumn(i) )){
                        columnGroup.addValue(k, i);
                        addToGroup = true;
                        break;
                    }
                }
                if( ! addToGroup) {
                    newMatrix.addColumn(matrix.getColumn(i));
                }
            }
        }
        return newMatrix;
    }

    public static Matrix deployMatrixByColumn(Matrix matrix){
        Matrix newMatrix = new Matrix();
        newMatrix.setRowGroup((Group) matrix.getRowGroup().clone());
        Group columnGroup = (Group) matrix.getColumnGroup();

        for(int i=0, curColumn=0; curColumn<matrix.getNumOfColumn() || i<=columnGroup.getMaxValue(); i++, curColumn++){
            Integer group = columnGroup.checkGroup(i);
            if(group == null || group==i){
                newMatrix.addColumn(matrix.getColumn(curColumn));
            } else{
                newMatrix.addColumn(newMatrix.getColumn(group));
                curColumn--;
            }
        }
        return newMatrix;
    }

    public static Matrix deployMatrixByRow(Matrix matrix){
        Matrix newMatrix = new Matrix();
        Group rowGroup = (Group) matrix.getRowGroup();

        for(int i=0, curRow=0; curRow<matrix.getNumOfRow() || i<=rowGroup.getMaxValue(); i++, curRow++){
            Integer group = rowGroup.checkGroup(i);
            if(group == null || group==i){
                newMatrix.addRow(matrix.getRow(curRow));
            } else{
                newMatrix.addRow(newMatrix.getRow(group));
                curRow--;
            }
        }
        return newMatrix;
    }

    public static Matrix changeValue(Matrix matrix, DataForChange... arrData){
        Matrix newMatrix = deployMatrixByColumn(matrix);
        newMatrix = deployMatrixByRow(newMatrix);

        for(DataForChange data : arrData){
            newMatrix.setValue(data.getRow(), data.getColumn(), data.getCell());
        }

        newMatrix = collapsingMatrixByRow(newMatrix);
        newMatrix = collapsingMatrixByColumn(newMatrix);

        return newMatrix;
    }

    public static Matrix deployMatrix(Matrix matrix){
        Matrix newMatrix = deployMatrixByColumn(matrix);
        newMatrix = deployMatrixByRow(newMatrix);
        return newMatrix;
    }

}
