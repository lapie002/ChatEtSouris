package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public abstract class Animal {
    
    protected JeuModele jeu;
    private EtatAnimal etat;
    private int id;
    private Case casee;
    
    private String direction;
    protected String[] directions = {"AHAUT","ADROITE", "ABAS", "AGAUCHE"};
    protected int indiceDeDirection;
    
    public Animal (int id,Case c, JeuModele jm){
        
        this.jeu = jm;
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

    public void setCasee(Case casee){
        this.casee = casee;
    }

    public String getDirection(){
        return direction;
    }
    /* pb on a deux setDirection */ 
    public void setDirectiontoString(String direction) 
    {
        this.direction = direction;
    }
   
    public void setDirection(int d) 
    {
        this.direction = directions[d];
    }
    
    public TypeCase getNextCase()
    {
        return(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()].getType());
    }
    
    
    public int ligneSuivante()
    {
        int ligne=0;
        
        if(this.direction=="ADROITE")
        {
            ligne =this.casee.getPositionL();
        }
        else if(this.direction=="ABAS")
        {
            ligne = this.casee.getPositionL()+1;
        }
        else if(this.direction=="AGAUCHE")
        {
            ligne = this.casee.getPositionL();
        }
        else if(this.direction=="AHAUT")
        {
            ligne = this.casee.getPositionL()-1;
        }
        
        return ligne;
    }
  
    public int colonneSuivante()
    {
        int colonne=0;
        
        if(this.direction=="ADROITE")
        {
            colonne =this.casee.getPositionC()+1;
        }
        else if(this.direction=="ABAS")
        {
            colonne = this.casee.getPositionC();
        }
        else if(this.direction=="AGAUCHE")
        {
            colonne = this.casee.getPositionC()-1;
        }
        else if(this.direction=="AHAUT")
        {
            colonne = this.casee.getPositionC();
        }
        
        return colonne;
    }
    
    
    
    
    
    public abstract void Deplacement ();
}
