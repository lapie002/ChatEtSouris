package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public class Case {
    
    private TypeCase type;
    private int positionL;
    private int positionC;
    
    public Case (TypeCase t, int pl, int pc){
        this.type=t;
        this.positionL=pl;
        this.positionC=pc;
    }

    public TypeCase getType() {
        return type;
    }

    public void setType(TypeCase type) {
        this.type = type;
    }

    public int getPositionL() {
        return positionL;
    }

    public void setPositionL(int positionL) {
        this.positionL = positionL;
    }

    public int getPositionC() {
        return positionC;
    }

    public void setPositionC(int positionC) {
        this.positionC = positionC;
    }
}
