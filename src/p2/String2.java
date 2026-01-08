//by mschro67

package p2;

import java.lang.ref.SoftReference;

public abstract class String2 implements Editable{
    public String mainString;

    public String2(String mainString){
        this.mainString=mainString;
    }

    @Override
    public void addPrefix(String s) {
        this.mainString=s+this.mainString;
    }

    @Override
    public void addPostfix(String s) {
        this.mainString+=s;
    }

    @Override
    public String toString(){
        return this.mainString;
    }
}