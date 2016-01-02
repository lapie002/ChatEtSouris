package miceandcats;

import java.util.Random;

/**
 *
 * @author Paul et Bruno
 */

public class Chien extends Animal {

    public Chien(int id, Case c, JeuModele jm) {
        super(id, c, jm);
        this.setNom("chien");
    }


    @Override
    public void Deplacement() {
        int ligne = randomi();
        int colonne = randomj();
        TypeCase typePrec=TypeCase.CHEMIN;
        
        if (this.jeu.getPlateau()[ligne][colonne].getType()==TypeCase.CHEMIN)
        {
            this.getCasee().setType(this.getTypeCasePrecedente());
            this.getCasee().sortirAnimalCase(this);
            this.setTypeCasePrecedente(this.jeu.getPlateau()[ligne][colonne].getType());
            this.setCasee(this.jeu.getPlateau()[ligne][colonne]);
            this.jeu.getPlateau()[ligne][colonne].setType(TypeCase.CHIEN);
            this.getCasee().affecterAnimalCase(this);
        }
        else if (this.jeu.getPlateau()[ligne][colonne].getType()==TypeCase.CHAT)
        {
            this.getCasee().setType(this.getTypeCasePrecedente());
            this.getCasee().sortirAnimalCase(this);
            this.setCasee(this.jeu.getPlateau()[ligne][colonne]);
            
            for(Animal animal : this.jeu.getPlateau()[ligne][colonne].getMyAnimals())
            {
                if(animal.getNom()=="chat")
                {
                    animal.setEtat(EtatAnimal.MORT);
                    typePrec=animal.getTypeCasePrecedente();
                }
            }
            this.setEtat(EtatAnimal.MORT);
            this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this); 
            this.jeu.getPlateau()[ligne][colonne].setType(typePrec);
        }
        else if(this.jeu.getPlateau()[ligne][colonne].getType()==TypeCase.SOURIS)
        {
            this.getCasee().setType(this.getTypeCasePrecedente());
            this.getCasee().sortirAnimalCase(this);
            this.setCasee(this.jeu.getPlateau()[ligne][colonne]);
            
            for(Animal animal : this.jeu.getPlateau()[ligne][colonne].getMyAnimals())
            {
                if(animal.getNom()=="souris")
                {
                    animal.setEtat(EtatAnimal.MORT);
                    typePrec=animal.getTypeCasePrecedente();
                }
            }
            this.setTypeCasePrecedente(typePrec);
            this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.CHIEN);
            this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this); 
        }
        else {
            Deplacement();
        }
    }
    
    public int randomi(){
       Random r = new Random();
       int valeur = (0) + r.nextInt((8) - (0)); 
       return valeur;
    }
    
    public int randomj(){
        Random r = new Random();
        int valeur = (0) + r.nextInt((10) - (0));
        return valeur;
    }
    
}