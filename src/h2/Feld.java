//by mschro67

package h2;

public class Feld{
    private boolean boese;
    private char direction;

    public Feld(boolean boese,char direction){
        this.boese=boese;
        this.direction=direction;
    }

    public boolean getBoese(){
        return Boolean.valueOf(this.boese);
    }
    public void setBoese(boolean boese){
        this.boese=Boolean.valueOf(boese);
    }

    public char getDirection(){
        return Character.valueOf(this.direction);
    }
    public void setDirection(char direction) {
        this.direction = Character.valueOf(direction);
    }
}