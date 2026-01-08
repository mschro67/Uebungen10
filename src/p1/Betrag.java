//by mschro67

package p1;

public class Betrag{
    private int euro,cent;

    public Betrag(int euro,int cent){
        this.euro=euro;
        this.setCent(cent);
    }

    public Betrag(){
        this.euro=0;
        this.cent=0;
    }

    public int getEuro(){
        return this.euro;
    }
    public void setEuro(int euro){
        this.euro = euro;
    }

    public int getCent(){
        return this.cent;
    }
    public void setCent(int cent){
        int euro;
        euro=cent/100;
        this.euro+=euro;
        this.cent=cent-euro*100;
    }

    @Override
    public String toString(){
        return euro+","+(cent<10 ? "0"+cent : cent)+"€";
    }
}