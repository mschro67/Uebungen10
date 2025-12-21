//by mschro67

package h2;

import java.util.Arrays;

public class Spielbrett{
    private Feld[][] brett;
    private int dim;

    public Spielbrett(int dim){
        this.brett=new Feld[dim][dim];
    }

    public Feld[][] getBrett(){
        return this.brett;
    }
    public void setBrett(Feld[][] brett){
        this.brett=brett;
        this.dim=brett.length;
    }

    public int getDim(){
        return Integer.valueOf(this.dim);
    }
    public void setDim(int dim){
        this.dim=Integer.valueOf(dim);
        this.brett=new Feld[dim][dim];
    }

    public Feld get(int row,int col){
        return this.brett[row][col];
    }
}