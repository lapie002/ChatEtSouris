package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public abstract class Animal {
    
    private EtatAnimal etat;
    private int id;
    private Case casee;
    
    private String direction;
    protected String[] directions = {"AHAUT","ADROITE", "ABAS", "AGAUCHE"};
    protected int indiceDeDirection;
    
    public Animal (int id,Case c){
        this.id=id;
        this.casee=c;
        
        
        etat=EtatAnimal.VIVANT;
        
    }

    public EtatAnimal getEtat() {
        return etat;
    }

    public void setEtat(EtatAnimal etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Case getCasee() {
        return casee;
    }

    public void setCasee(Case casee) {
        this.casee = casee;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) 
    {
        this.direction = direction;
    }
    
    public void setDirection(int d) 
    {
        this.direction = directions[d];
    }
    
    public abstract void Deplacement ();
}
