package miceandcats;

import java.util.ArrayList;

/**
 *
 * @author Paul et Bruno
 */

public class JeuModele {
    
    private int nbFleches;
    private int sourisSafe;
    private ArrayList <Animal> animaux;
    private ArrayList <Case> cases;
    
    public JeuModele(){
        this.nbFleches=3;
        this.sourisSafe=0;
        animaux = new ArrayList<>();
        cases = new ArrayList<>();
        initialiserModele();
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    public ArrayList<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(ArrayList<Animal> animaux) {
        this.animaux = animaux;
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public void setCases(ArrayList<Case> cases) {
        this.cases = cases;
    }
    
    public int getSourisSafe() {
        return sourisSafe;
    }

    public void setSourisSafe(int sourisSafe) {
        this.sourisSafe = sourisSafe;
    }
    
    public void Collision (Animal a, Animal b) {
        
    }
    
    public void Teleportation (Animal a){
        //on place l'animal sur la case TELOUT
        a.setCasee(cases.get(32));
    }
    
    public void Fleche (Case c){
        
    }
    
    private void initialiserModele(){
        
        //Implementation de l'arrayList de cases, avec par defaut le type Vide
        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                Case c = new Case (TypeCase.VIDE,i,j);
                cases.add(c);
            }
        }
        
        //Creation de la case IN
        cases.get(0).setType(TypeCase.IN);
        
        //Creation de la case OUT
        cases.get(47).setType(TypeCase.OUT);
        
        //Creation des murs
        cases.get(3).setType(TypeCase.MUR);
        cases.get(9).setType(TypeCase.MUR);
        cases.get(13).setType(TypeCase.MUR);
        cases.get(19).setType(TypeCase.MUR);
        cases.get(21).setType(TypeCase.MUR);
        cases.get(22).setType(TypeCase.MUR);
        cases.get(26).setType(TypeCase.MUR);
        cases.get(35).setType(TypeCase.MUR);
        cases.get(36).setType(TypeCase.MUR);
        cases.get(38).setType(TypeCase.MUR);
        cases.get(41).setType(TypeCase.MUR);
        
        //Creation des chatons et ajout a l'arrayList des animaux
        cases.get(25).setType(TypeCase.CHAT);
        Chat chat1 = new Chat (1,cases.get(25));
        animaux.add(chat1);
        
        cases.get(28).setType(TypeCase.CHAT);
        Chat chat2 = new Chat (2,cases.get(28));
        animaux.add(chat2);
        
        //Creation des chiens et ajout a l'arrayList des animaux
        cases.get(45).setType(TypeCase.CHIEN);
        Chien chien1 = new Chien (1,cases.get(45));
        animaux.add(chien1);
        
        cases.get(46).setType(TypeCase.CHIEN);
        Chien chien2 = new Chien (2,cases.get(46));
        
        //Creation des teleporteurs
        cases.get(30).setType(TypeCase.TELIN);
        cases.get(32).setType(TypeCase.TELOUT);
        
        //Creation des souris, par defaut elles se situent sur la case IN
        Souris souris1 = new Souris (1,cases.get(0));
        Souris souris2 = new Souris (2,cases.get(0));
        Souris souris3 = new Souris (3,cases.get(0));
    }

}
