package miceandcats;

/**
 *
 * @author Paul et Bruno
 */
import java.util.Random;

public class Chat extends Animal {

    private TypeCase typeCasePrecedente; 
    
    public Chat(int id, Case c, JeuModele jm,int i) 
    {
        super(id, c, jm);
        this.setDirectiontoString(directions[i]);
        //indiceDeDirection = retournIndiceDirection(directions[i]);
        //this.typeCasePrecedente = TypeCase.IN;
        this.getCasee().affecterAnimalCase(this);
    }
    
    public TypeCase getTypeCasePrecedente() {
        return typeCasePrecedente;
    }

    public void setTypeCasePrecedente(TypeCase typeCasePrecedente) {
        this.typeCasePrecedente = typeCasePrecedente;
    }

    
    
    
    @Override
    public void Deplacement() 
    {
        
        String myDirection = this.getDirection();
        Case myCase = this.getCasee();
        //TypeCase myTypeCase = myCase.getType();
        
        // retourne l'indice du tableau de direction
        int myDirectionIndice = retournIndiceDirection(myDirection);
//        Choix des conditions pour le chat en fonction de la case ou il peut et doit aller:        
//        if(this.getNextCase() == TypeCase.CHEMIN || this.getNextCase() == TypeCase.CHAT this.getNextCase() == TypeCase.CHIEN || this.getNextCase() == TypeCase.SOURIS)
//        if(this.getNextCase() != TypeCase.MUR)
//        if(this.getNextCase() != TypeCase.MUR && this.getNextCase() != TypeCase.OUT && this.getNextCase() != TypeCase.TELIN && this.getNextCase() != TypeCase.TELOUT)
        
        if(this.getNextCase() == TypeCase.CHEMIN || this.getNextCase() == TypeCase.CHAT || this.getNextCase() == TypeCase.CHIEN || this.getNextCase() == TypeCase.SOURIS)
        {
                //on retire l'animal de la case 
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
                
                this.getCasee().setType(TypeCase.CHEMIN);
                this.setCasee(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()]);
                
                if(this.getCasee().getType() == TypeCase.CHIEN)
                {
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                    
                    for(Animal animal : this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].getMyAnimals())
                    {
                        if(animal.getId()==1 || animal.getId()==2)
                        {
                            animal.setEtat(EtatAnimal.MORT);
                        }
                    }
                    this.setEtat(EtatAnimal.MORT);
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.CHEMIN);
                    
                }
                else if(this.getCasee().getType() == TypeCase.SOURIS)
                {
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                    
                    for(Animal animal : this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].getMyAnimals())
                    {
                        if(animal.getId()==1 || animal.getId()==2)
                        {
                            animal.setEtat(EtatAnimal.MORT);
                        }
                    }
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.CHAT);
                }
                else
                {
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
