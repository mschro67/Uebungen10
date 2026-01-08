//by mschro67

package p1;

public class P1_main{
    public static void main(String[] args){
        Betrag b=new Betrag(0,200);
        System.out.println(b.toString());
    }
    public static Betrag summe(Betrag a,Betrag b){
        Betrag result=new Betrag();
        result.setEuro(a.getEuro()+b.getEuro());
        result.setCent(a.getCent()+b.getCent());
        return result;
    }
}