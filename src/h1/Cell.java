//by mschro67

package h1;

public class Cell{
    private int indexRow;
    private int indexCol;

    private boolean alive;
    private boolean isAliveNextGen;

    private int numLivingNeighbors;

    public Cell(int indexRow,int indexCol, boolean alive){
        this.indexRow=Integer.valueOf(indexRow);
        this.indexCol=Integer.valueOf(indexCol);
        this.alive=Boolean.valueOf(alive);

        this.numLivingNeighbors=Integer.MIN_VALUE;
    }

    public Cell(int indexRow,int indexCol){
        this.indexRow=Integer.valueOf(indexRow);
        this.indexCol=Integer.valueOf(indexCol);
        this.alive=false;

        this.numLivingNeighbors=Integer.MIN_VALUE;
    }

    public void countLivingNeighbors(Cell[][] gridArray){
        this.numLivingNeighbors=0;
        for (int a=-1;a<=1;a++){
            for (int b=-1;b<=1;b++){
                if (!(a==0&&b==0)){
                    try {
                        if (gridArray[this.indexRow+a][this.indexCol+b].isAlive()==true){
                            this.numLivingNeighbors++;
                        }
                    }catch (Exception e){
                        continue;
                    }
                }
            }
        }
    }

    private void decideNextStatus(){
        boolean aliveNextGen;
        if (this.alive){
            if (this.numLivingNeighbors==2||this.numLivingNeighbors==3){
                //System.out.println("A");
                aliveNextGen=true;
            }else{
                //System.out.println("B");
                aliveNextGen=false;
            }
        }else{
            if (this.numLivingNeighbors==3){
                //System.out.println("C");
                aliveNextGen=true;
            }else{
                //System.out.println("D");
                aliveNextGen=false;
            }
        }
        this.isAliveNextGen=aliveNextGen;
    }
    public void setNextStatus(){
        decideNextStatus();
    }
    public boolean getNextStatus(){
        /*System.out.println(this.numLivingNeighbors);
        System.out.println(this.isAliveNextGen);*/
        return this.isAliveNextGen;
    }

    public boolean isAlive(){
        return Boolean.valueOf(this.alive);
    }
    public int getLivingNeighbors(){
        return Integer.valueOf(this.numLivingNeighbors);
    }

    public int getIndexRow(){
        return Integer.valueOf(this.indexRow);
    }
    public int getIndexCol(){
        return Integer.valueOf(this.indexCol);
    }

    public void setAlive(boolean newStatus){
        this.alive=Boolean.valueOf(newStatus);
    }
}
