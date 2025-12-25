//by mschro67

package h2;

public class Spielstein{
    private int currentRow,
            currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol){
        this.brett=brett;
        this.currentRow=Integer.valueOf(indexRow);
        this.currentCol=Integer.valueOf(indexCol);
    }

    private boolean movesOut(){
        int row=0;
        int col=0;
        switch (brett.get(currentRow,currentCol).getDirection()){
            case 'U':
                row=-1;
            case 'D':
                row=1;
            case 'L':
                col=-1;
            case 'R':
                col=1;
        }
        try{
            char dir=brett.get(this.currentRow+row,this.currentCol+col).getDirection();
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public void go(int n){
        for (int counter=0;counter<n;counter++){
            if (this.brett.get(currentRow,currentCol).getBoese()) {
                System.out.println("Das Feld an ("+this.currentRow+"|"+this.currentCol+") ist böse!");
            }else{
                if (movesOut()){
                    System.out.println("Der Stein verlässt das Spielfeld bei ("+this.currentRow+"|"+this.currentCol+")!");
                }else {
                    switch (this.brett.get(currentRow, currentCol).getDirection()) {
                        case 'U':
                            this.currentRow--;
                            break;
                        case 'D':
                            this.currentRow++;
                            break;
                        case 'L':
                            this.currentCol--;
                            break;
                        case 'R':
                            this.currentCol++;
                            break;
                        default:
                            System.out.println("Das Feld an ("+this.currentRow+"|"+this.currentCol+") hat keine gültige Richtung!");
                    }
                }
            }
        }
    }
}