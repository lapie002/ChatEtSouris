package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public class JeuModele {
    
    private int nbFleches;
    private Animal [] animaux;
    private Case [] cases;
    
    public JeuModele(){
        this.nbFleches=3;
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    public Animal[] getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Animal[] animaux) {
        this.animaux = animaux;
    }

    public Case[] getCases() {
        return cases;
    }

    public void setCases(Case[] cases) {
        this.cases = cases;
    }
    
    public void Collision (Animal a, Animal b) {
        
    }
    
    public void Teleportation (Animal a){
        
    }
    
    public void Fleche (Case c){
        
    }
}
