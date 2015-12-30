package miceandcats;

import java.util.Random;

/**
 *
 * @author Paul et Bruno
 */

public class Chien extends Animal {

    public Chien(int id, Case c, JeuModele jm) {
        super(id, c, jm);
    }


    @Override
    public void Deplacement() {
        int ligne = randomi();
        int colonne = randomj();
        
        if (this.jeu.getPlateau()[ligne][colonne].getType()==TypeCase.CHEMIN)
        {
            this.getCasee().setType(TypeCase.CHEMIN);
            this.getCasee().sortirAnimalCase(this);
            this.setCasee(this.jeu.getPlateau()[ligne][colonne]);
            this.jeu.getPlateau()[ligne][colonne].setType(TypeCase.CHIEN);
            this.getCasee().affecterAnimalCase(this);
        }
        else if (this.jeu.getPlateau()[ligne][colonne].getType()==TypeCase.CHAT)
        {
            this.getCasee().setType(TypeCase.CHEMIN);
            this.getCasee().sortirAnimalCase(this);
            this.setCasee(this.jeu.getPlateau()[ligne][colonne]);
            
            for(Animal animal : this.jeu.getPlateau()[ligne][colonne].getMyAnimals())
            {
                if(animal.getId()==3 || animal.getId()==4)
                {
                    animal.setEtat(EtatAnimal.MORT);
                }
            }
            this.setEtat(EtatAnimal.MORT);
            this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this); 
            this.jeu.getPlateau()[ligne][colonne].setType(TypeCase.CHEMIN);
        }
        else if(this.jeu.getPlateau()[ligne][colonne].getType()==TypeCase.SOURIS)
        {
            this.getCasee().setType(TypeCase.CHEMIN);
            this.getCasee().sortirAnimalCase(this);
            this.setCasee(this.jeu.getPlateau()[ligne][colonne]);
            
            for(Animal animal : this.jeu.getPlateau()[ligne][colonne].getMyAnimals())
            {
                if(animal.getId()==5 || animal.getId()==6 || animal.getId()==7)
                {
                    animal.setEtat(EtatAnimal.MORT);
                }
            }
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