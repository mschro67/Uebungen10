package h2;

public class H2_main{
    public static void main(String[] args){
        int size = 5;
        Spielbrett b = new Spielbrett(size);
        Feld[][] a =
                {{new Feld(false,'U'),new Feld(false,'R'),new Feld(false,'L'),new Feld(false,'L'),new Feld(false,'D')},
                 {new Feld(false,'L'),new Feld(false,'R'),new Feld(false,'L'),new Feld(false,'L'),new Feld(false,'D')},
                 {new Feld(false,'U'),new Feld(false,'L'),new Feld(false,'L'),new Feld(false,'L'),new Feld(false,'R')},
                 {new Feld(false,'D'),new Feld(false,'R'),new Feld(false,'U'),new Feld(false,'L'),new Feld(false,'L')},
                 {new Feld(false,'U'),new Feld(false,'R'),new Feld(false,'L'),new Feld(false,'D'),new Feld(false,'D')}};
        b.setBrett(a);
        Spielstein s = new Spielstein(b,2,2);
        s.printPos();
        s.go(6);
        s.printPos();
    }
}