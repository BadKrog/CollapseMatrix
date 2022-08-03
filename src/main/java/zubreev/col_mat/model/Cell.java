package zubreev.col_mat.model;

import java.util.Objects;

public class Cell {
    private short dly;
    private short ncdly;

    public Cell(int dly, int ncdly){
        if(dly>180 || ncdly>180) throw new RuntimeException("The value must be less than 180");
        this.dly = (short) dly;
        this.ncdly = (short) ncdly;
    }

    public short getNcdly() {
        return ncdly;
    }
    public short getDly() {
        return dly;
    }

    public void setData(Cell cell){
        this.dly = cell.getDly();
        this.ncdly = cell.getNcdly();
    }

    public void setData(short dly, short ncdly){
        if(dly>180 || ncdly>180) throw new RuntimeException("The value must be less than 180");
        this.dly = (short) dly;
        this.ncdly = (short) ncdly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return dly == cell.dly && ncdly == cell.ncdly;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dly, ncdly);
    }

    @Override
    public String toString() {
        return "(" + dly +
                ", " + ncdly+")";
    }
}
