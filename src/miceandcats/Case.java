package miceandcats;

import java.util.ArrayList;

/**
 *
 * @author Paul et Bruno
 */

public class Case {
    
    private TypeCase typeC;
    private TypePresence typeP;
    private TypeCase typeCprecedent;
    
    private ArrayList<Animal> myAnimals;
    
    
    private int positionL;
    private int positionC;
    
    
    public Case (TypeCase t, int pl, int pc)
    {
        this.typeC=t;
        this.typeCprecedent=t;
        this.positionL=pl;
        this.positionC=pc;
        
        myAnimals = new ArrayList<Animal>();
    }

    public TypeCase getType() {
        return typeC;
    }

    public void setType(TypeCase type) {
        this.typeC = type;
    }

    public TypeCase getTypeCprecedent() {
        return typeCprecedent;
    }

    public void setTypeCprecedent(TypeCase typeCprecedent) {
        this.typeCprecedent = typeCprecedent;
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
    public String toStringType() {
        return ""+typeC;
    }

    public ArrayList<Animal> getMyAnimals() {
        return myAnimals;
    }

    public void affecterAnimalCase(Animal a)
    {
        this.myAnimals.add(a);        
    }
    
    public void sortirAnimalCase(Animal a)
    {
        if(this.myAnimals.contains(a))
        {
            this.myAnimals.remove(a);
        }
        else
        {
            System.out.println("cet animal n est pas present dans cette case!");
        }
    }
 
    
    
}
