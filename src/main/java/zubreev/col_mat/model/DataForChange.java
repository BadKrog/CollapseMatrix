package zubreev.col_mat.model;

public class DataForChange {
    private int row;
    private int column;
    private short value;

    public DataForChange(int row, int column, int value){
        this.column = column;
        this.row = row;
        if(value>180) throw new NullPointerException("Не превышай 180 в value");
        this.value = (short) value;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public short getValue() {
        return value;
    }
}
