package miceandcats;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul et Bruno
 */

public class JeuModele{
    
    private int nbFleches;
    private int sourisSafe;
    private ArrayList<Animal> animaux;
    //private ArrayList <Case> cases;
    
    //private HashMap<String,Case> plateau;
    private final int tailleLigne = 8;
    private final int tailleColonne = 10;
    
    private List<Observateur> observateurs;
    
    private Case[][] plateau;
    
    public JeuModele(){
        this.nbFleches=3;
        this.sourisSafe=0;
        animaux = new ArrayList<>();
        //cases = new ArrayList<>();
        
        //plateau = new HashMap<>();
       plateau = new Case[tailleLigne][tailleColonne];
       
//        for(int i=0;i<tailleLigne;i++)
//        {
//            for(int j=0;j<tailleColonne;j++)
//            {
//                plateau[i][j] = null;
//            }
//        }
       
       
        initialiserModele();
        observateurs = new ArrayList<>();
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
        avertirObservateurs();
    }

    public ArrayList<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(ArrayList<Animal> animaux) {
        this.animaux = animaux;
    }
    
    /*
    public ArrayList<Case> getCases() {
        return cases;
    }

    public void setCases(ArrayList<Case> cases) {
        this.cases = cases;
    }
    */
    
    
    public int getSourisSafe() {
        return sourisSafe;
    }

    public void setSourisSafe(int sourisSafe) {
        this.sourisSafe = sourisSafe;
    }
    
    public void Collision (Animal a, Animal b) {
        
    }
    /**
    public void Teleportation (Animal a){
        //on place l'animal sur la case TELOUT
        a.setCasee(cases.get(32));
    }
    */
    public void Fleche (Case c)
    {
        
    }

    public Case[][] getPlateau() {
        return plateau;
    }
    
    
    public void creerContourDuJeu()
    {
        for(int i=0;i<10;i++)
        {
            //fait la premiere colonne avec que des murs
            this.plateau[0][i] = new Case (TypeCase.MUR, 0,i);
            //fait la colonne la derniere colonne avec que des murs
            this.plateau[7][i]= new Case (TypeCase.MUR, 7,i);
        }
        
        for(int j=0;j<8;j++)
        {
            //fait la premiere ligne avec que des murs
            this.plateau[j][0] = new Case (TypeCase.MUR, j,0);
            //fait la derniere ligne avec que des murs
            this.plateau[j][9] = new Case (TypeCase.MUR, j,9);
        }
    }
    
    public void placerInAndOut()
    {
        //creation de la case in
        this.plateau[1][1] = new Case (TypeCase.IN, 1,1);
        //creation de la case out
        this.plateau[6][8] = new Case (TypeCase.OUT, 6,8);
    }
    
    public void placerInTelAndOut()
    {
        //creation de la case TELIN
        this.plateau[6][1] = new Case (TypeCase.TELIN, 6,1);
        //creation de la case TELOUT
        this.plateau[2][8] = new Case (TypeCase.TELOUT, 2,8);
    }
    
    public void placerLesMurs()
    {
        //creation de la case MUR
        this.plateau[2][2] = new Case (TypeCase.MUR, 2,2);
        //creation de la case MUR
        this.plateau[6][2] = new Case (TypeCase.MUR, 6,2);
        //creation de la case MUR
        this.plateau[4][3] = new Case (TypeCase.MUR, 4,3);
        //creation de la case MUR
        this.plateau[7][2] = new Case (TypeCase.MUR, 7,2);
        //creation de la case MUR
        this.plateau[1][4] = new Case (TypeCase.MUR, 1,4);
        //creation de la case MUR
        this.plateau[3][4] = new Case (TypeCase.MUR, 3,4);
        //creation de la case MUR
        this.plateau[5][4] = new Case (TypeCase.MUR, 5,4);
        //creation de la case MUR
        this.plateau[5][5] = new Case (TypeCase.MUR, 1,4);
        //creation de la case MUR
        this.plateau[2][6] = new Case (TypeCase.MUR, 2,6);
        //creation de la case MUR
        this.plateau[3][6] = new Case (TypeCase.MUR, 3,6);
        //creation de la case MUR
        this.plateau[3][7] = new Case (TypeCase.MUR, 3,7);
        //creation de la case MUR
        this.plateau[5][7] = new Case (TypeCase.MUR, 5,7);
    }
    
    
    public void placerLesChemins()
    {
       
       for(int i=0;i<tailleLigne;i++)
       {
           for(int j=0;j<tailleColonne;j++)
           {
               if(plateau[i][j] == null)
               {
                   plateau[i][j] = new Case (TypeCase.CHEMIN, i,j);
               }
           }
       }
    }
    
    public void placerChien(){
        this.plateau[6][7]=new Case(TypeCase.CHIEN,6,7);
        Chien c1 = new Chien (1,this.plateau[6][7],this);
        animaux.add(c1);
        
        this.plateau[6][6]=new Case(TypeCase.CHIEN,6,7);
        Chien c2 = new Chien (1,this.plateau[6][6],this);
        animaux.add(c2);
    }
    
    
    private void initialiserModele()
    {
        creerContourDuJeu();
        placerInAndOut();
        placerInTelAndOut();
        placerLesMurs();
        placerLesChemins();
        placerChien();
    }
    
    public void addObservateur(Observateur obs) {
        observateurs.add(obs);
    }

    public void removeObservateur(Observateur obs) {
        observateurs.remove(obs);
    }

    public void avertirObservateurs() {
        for(Observateur obs : observateurs)
            obs.avertir();
    }
}
