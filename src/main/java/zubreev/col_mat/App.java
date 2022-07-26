package zubreev.col_mat;

import zubreev.col_mat.algoritm.CollapseService;
import zubreev.col_mat.model.Cell;
import zubreev.col_mat.model.DataForChange;
import zubreev.col_mat.model.Matrix;

public class App {
    public static void main(String[] args) {
        Cell[][] inputMatrix = {{new Cell(2, 2), new Cell(2, 2),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(1, 1), new Cell(1, 1),new Cell(1, 1),new Cell(1, 1),new Cell(1, 1)},
                                {new Cell(2, 2), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(2, 2), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(2, 2), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(2, 2), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(2, 0), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(2, 2), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)},
                                {new Cell(2, 0), new Cell(3, 3),new Cell(2, 2),new Cell(2, 2),new Cell(2, 2)}};

        System.out.println("\n********* Test function matrix ***********\n");
        Matrix firstMatrix = new Matrix(inputMatrix);
        System.out.println(firstMatrix.getNumOfRow());
        System.out.println(firstMatrix.getNumOfColumn());

        System.out.println(firstMatrix.getRow(1));
        System.out.println(firstMatrix.getColumn(0));

        System.out.println(firstMatrix);

        System.out.println("\n********* Collapse Row ***********\n");

        Matrix matrixColRow = CollapseService.collapsingMatrixByRow(firstMatrix);
        System.out.println(matrixColRow);

        System.out.println("\n********* Collapse Column ***********\n");

        Matrix matrixColColumn = CollapseService.collapsingMatrixByColumn(matrixColRow);
        System.out.println(matrixColColumn);

        System.out.println("\n********* Deploy Column ***********\n");

        Matrix matrixDeplColumn = CollapseService.deployMatrixByColumn(matrixColColumn);
        System.out.println(matrixDeplColumn);

        System.out.println("\n********* Deploy Row ***********\n");

        Matrix matrixDeplRow = CollapseService.deployMatrixByRow(matrixDeplColumn);
        System.out.println(matrixDeplRow);

        System.out.println("\n********* Change value in matrix ***********\n");

        Matrix matrixWithOtherValue = CollapseService.changeValue(firstMatrix,
                                                                  new DataForChange(0,0,new Cell(5,5)),
                                                                  new DataForChange(1,0,new Cell(5,5)),
                                                                  new DataForChange(2,0,new Cell(5,5)),
                                                                  new DataForChange(2,1,new Cell(5,5)),
                                                                  new DataForChange(3,2,new Cell(5,5)),
                                                                  new DataForChange(3,3,new Cell(5,5)),
                                                                  new DataForChange(3,4,new Cell(5,5)));
        System.out.println(matrixWithOtherValue);

        System.out.println("\n********* show all values in a matrix with modified data ***********\n");
        Matrix deployMatrix = CollapseService.deployMatrix(matrixWithOtherValue);
        System.out.println(deployMatrix);

    }
}
