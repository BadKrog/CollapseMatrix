package zubreev.col_mat.model;

public class DataForChange {
    private int row;
    private int column;
    private Cell cell;

    public DataForChange(int row, int column, Cell cell){
        this.row = row;
        this.column = column;
        this.cell = cell;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public Cell getCell() {
        return cell;
    }
}
