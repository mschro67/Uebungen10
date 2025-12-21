//by mschro67

package h1;

public class H1_main{
    public static void main(String[] args){
        Cell[] cells={new Cell(0,4),new Cell(1,1),new Cell(2,2),new Cell(2,3),new Cell(3,1),new Cell(3,2)};

        Grid test=new Grid(cells,4,5);

        System.out.println("Start:\n"+test.toString());
        test.computeGeneration(5);
    }
}