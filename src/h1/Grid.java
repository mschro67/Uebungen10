//by mschro67

package h1;

public class Grid{
    private Cell[][] gridArray;
    private String[] lastGens=new String[2];
    private int gens;

    public Grid(Cell[] cells,int gridRows,int gridCols){
        this.gridArray=new Cell[gridRows][gridCols];
        for (int row=0;row<gridRows;row++){
            for (int col=0;col<gridCols;col++){
               this.gridArray[row][col]=new Cell(row,col);
            }
        }

        for (Cell cell:cells){
            int accesRow=cell.getIndexRow();
            int accesCol=cell.getIndexCol();
            if (cell.getIndexRow()>gridRows){
                accesRow%=gridRows;
            }
            if (cell.getIndexCol()>gridCols){
                accesCol%=gridCols;
            }
            this.gridArray[cell.getIndexRow()][cell.getIndexCol()].setAlive(true);
        }

        lastGens[0]="UNDEFINED";
        lastGens[1]="UNDEFINED";

        gens=0;
    }

    public void computeNextGen(){
        lastGens[0]=new String();
        lastGens[0]=lastGens[1].toString();
        lastGens[1]=new String();
        lastGens[1]=this.toString();

        Cell[][] after = new Cell[this.gridArray.length][this.gridArray[0].length];
        for (int row=0;row<this.gridArray.length;row++){
            for (int col=0;col<this.gridArray[row].length;col++){
                this.gridArray[row][col].countLivingNeighbors(this.gridArray);
                this.gridArray[row][col].setNextStatus();
                after[row][col]=new Cell(row,col,this.gridArray[row][col].getNextStatus());
            }
        }

        this.gridArray=after;
        gens++;
    }

    public void computeGeneration(int n){
        for (int gen=0;gen<n;gen++){
           computeNextGen();
           if (this.getAliveCells().length==0) {
               System.out.println("All cells are dead!");
               break;
           }else if (this.lastGens[0].equals(this.lastGens[1])&&this.gridArray.toString().equals(this.lastGens[1])){
               System.out.println("The Generations are repeating!");
               break;
           }else{
               System.out.println("Generation " + (gen + 1) + ":\n" + this.toString());
           }
        }
    }

    public Cell[] getAliveCells(){
        int aliveCount=0;

        for (Cell[] row:this.gridArray){
            for (Cell el:row) {
                aliveCount += (el.isAlive() ? 1 : 0);
            }
        }

        Cell[] aliveCells=new Cell[aliveCount];
        int index=0;

        for (int row=0;row<this.gridArray.length;row++){
            for (int col=0;col<this.gridArray[row].length;col++){
                if (this.gridArray[row][col].isAlive()){
                    aliveCells[index]=new Cell(this.gridArray[row][col].getIndexRow(),this.gridArray[row][col].getIndexCol());
                    index++;
                }
            }
        }

        return aliveCells;
    }

    @Override
    public String toString(){
        String string="";
        for (Cell[] row:this.gridArray){
            for (Cell el:row){
                string+=(el.isAlive() ? "X" : "-");
            }
            string+="\n";
        }
        return string;
    }
}