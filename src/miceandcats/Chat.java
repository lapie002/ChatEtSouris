package miceandcats;

/**
 *
 * @author Paul et Bruno
 */
import java.util.Random;

public class Chat extends Animal {

    
    
    public Chat(int id, Case c, JeuModele jm,int i) 
    {
        super(id, c, jm);
        this.setDirectiontoString(directions[i]);
        
        //indiceDeDirection = retournIndiceDirection(directions[i]);
        //this.typeCasePrecedente = TypeCase.IN;
        this.getCasee().affecterAnimalCase(this);
        this.setNom("chat");
    }
    
    
    
    
    @Override
    public void Deplacement() 
    {
        
        String myDirection = this.getDirection();
        Case myCase = this.getCasee();
        TypeCase typePrec = TypeCase.CHEMIN;
        //TypeCase myTypeCase = myCase.getType();
        
        // retourne l'indice du tableau de direction
        int myDirectionIndice = retournIndiceDirection(myDirection);
        
//        Choix des conditions pour le chat en fonction de la case ou il peut et doit aller:        
//        if(this.getNextCase() == TypeCase.CHEMIN || this.getNextCase() == TypeCase.CHAT this.getNextCase() == TypeCase.CHIEN || this.getNextCase() == TypeCase.SOURIS)
//        if(this.getNextCase() != TypeCase.MUR)
//        if(this.getNextCase() != TypeCase.MUR && this.getNextCase() != TypeCase.OUT && this.getNextCase() != TypeCase.TELIN && this.getNextCase() != TypeCase.TELOUT)
        
        //if(this.getNextCase() == TypeCase.CHEMIN || this.getNextCase() == TypeCase.CHAT || this.getNextCase() == TypeCase.CHIEN || this.getNextCase() == TypeCase.SOURIS)
        if(this.getNextCase() != TypeCase.MUR && this.getNextCase() != TypeCase.OUT )
        {
                //on retire l'animal de la case 
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].setType(this.getTypeCasePrecedente());
                //this.getCasee().setType(TypeCase.CHEMIN);
                this.setTypeCasePrecedente(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()].getType());
                this.setCasee(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()]);
                
                if(this.getCasee().getType() == TypeCase.CHIEN)
                {
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                    
                    for(Animal animal : this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].getMyAnimals())
                    {
                        if(animal.getNom()=="chien"){
                            animal.setEtat(EtatAnimal.MORT);
                            typePrec=animal.getTypeCasePrecedente();
                        }
                    }
                    this.setEtat(EtatAnimal.MORT);
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(typePrec);
                    
                }
                else if(this.getCasee().getType() == TypeCase.SOURIS)
                {
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                    
                    for(Animal animal : this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].getMyAnimals())
                    {
                        if(animal.getNom()=="souris")
                        {
                            animal.setEtat(EtatAnimal.MORT);
                        }
                    }
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.CHAT);
                }
                else
                {   
                        this.setTypeCasePrecedente(this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].getType());
                        this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.CHAT);       
                        this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                    
                }
        }
        else
        {
             myDirectionIndice = (myDirectionIndice + 2)%4;
             this.setDirection(myDirectionIndice);
             this.Deplacement();
        }

    }
    
    
    public int retournIndiceDirection(String d)
    {
        boolean trouve = false;
        int indice = 0;
        int i = 0;
        
        while(!trouve && i<directions.length)
        {
            if(d.equals(directions[i]))
            {
                trouve = true;
                indice = i;
            }
            i++;
        }
        
        return indice;
        
    }
    
    public int randomChat()
    {
       Random indiceDeDirectionChat = new Random();
       int valeur = (0) + indiceDeDirectionChat.nextInt((1) - (0)); 
       return valeur;
    }
    
}
