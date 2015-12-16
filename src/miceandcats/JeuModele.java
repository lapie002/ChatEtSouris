package miceandcats;

import java.util.ArrayList;

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
    
    
    private void initialiserModele()
    {
        creerContourDuJeu();
        placerInAndOut();
        placerInTelAndOut();
        placerLesMurs();
        placerLesChemins();
    }
    
//    public static void main(String[] args)
//    {
//        JeuModele test = new JeuModele();
//        
//        for(int i=0;i<8;i++)
//        {
//            for(int j=0;j<10;j++)
//            {
//                System.out.println(test.plateau[i][j].toStringType() + " ");
//            }
//        }
        
        
        
       
//        if(test.plateau[0][0]==null)
//        {
//            System.out.println("ok");
//        }
//        else{System.out.println("pas ok");}
//     
    
    
    
    
    
    /*
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
    */
}
