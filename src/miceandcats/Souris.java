package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public class Souris extends Animal{

    
     
    public Souris(int id, Case c, JeuModele jm) {
        
       
        super(id, c, jm);
        this.setDirectiontoString(directions[1]);
        indiceDeDirection = 1;
        // soit une case de type IN soit de type chemin 
        
//        this.typeCasePrecedente=TypeCase.IN;
        this.getCasee().affecterAnimalCase(this);
        this.setNom("souris");
        
    }

    

    @Override
    public void Deplacement() 
    {
        String myDirection = this.getDirection();
        Case myCase = this.getCasee();
        //TypeCase myTypeCase = myCase.getType();
        
        // retourne l'indice du tableau de direction
        int myDirectionIndice = retournIndiceDirection(myDirection);
        

         
        if(this.getNextCase() != TypeCase.MUR)
        {
            if(this.getNextCase() == TypeCase.TELIN)
            {
                Case caseOut = null;
                
                for(int i=1;i<7;i++)
                {
                    for(int j=1;j<9;j++)
                    {
                        if(this.jeu.getPlateau()[i][j].getTypeCprecedent() == TypeCase.TELOUT)
                        {
                            caseOut = this.jeu.getPlateau()[i][j];
                        }
                    }
                    
                }
                
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].setType(this.getTypeCasePrecedente());
                this.setTypeCasePrecedente(caseOut.getType());
                
                this.setCasee(this.jeu.getPlateau()[caseOut.getPositionL()][caseOut.getPositionC()]);
                this.jeu.getPlateau()[caseOut.getPositionL()][caseOut.getPositionC()].setType(TypeCase.SOURIS);       
                this.jeu.getPlateau()[caseOut.getPositionL()][caseOut.getPositionC()].affecterAnimalCase(this);
                
                
            
            }
            
            else if(this.getNextCase() == TypeCase.OUT)
            {
               this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
               this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].setType(this.getTypeCasePrecedente());
               this.setTypeCasePrecedente(this.getNextCase());
               
               this.setCasee(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()]);
               this.setEtat(EtatAnimal.ARRIVE);
               this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
               
                
            }
            
       
            /*deplacement avec un cas fleche*/
            else if(this.getNextCase() == TypeCase.FHAUT)
            {
                deplacementSourisViaFleche(myDirection, myCase, 0);
            }
            else if(this.getNextCase() == TypeCase.FDROITE)
            {
                deplacementSourisViaFleche(myDirection, myCase, 1);
            }
            else if(this.getNextCase() == TypeCase.FBAS)
            {
                deplacementSourisViaFleche(myDirection, myCase, 2);
            }
            else if(this.getNextCase() == TypeCase.FGAUCHE)
            {
                deplacementSourisViaFleche(myDirection, myCase, 3);
            }
            /*fin fleche*/
            
            
       
            else
            {
                //on retire l'animal de la case 
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
                //this.setTypeCasePrecedente(this.getNextCase());
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].setType(this.getTypeCasePrecedente());
                this.setTypeCasePrecedente(this.getNextCasePrec());

    //            myCase.setPositionL(ligneSuivante());
    //            myCase.setPositionC(colonneSuivante());

                this.setCasee(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()]);
                
                if(this.getCasee().getType() == TypeCase.CHAT || this.getCasee().getType() == TypeCase.CHIEN)
                {
                    this.setEtat(EtatAnimal.MORT);
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                }
                else
                {
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.SOURIS);       
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                }
                
            }
        }
        else
        {
             myDirectionIndice = (myDirectionIndice + 1)%4;
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
    
    public void deplacementSourisViaFleche(String myDirection, Case myCase, int i)
    {
                //on retire l'animal de la case 
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
                //this.setTypeCasePrecedente(this.getNextCase());
                this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].setType(this.getTypeCasePrecedente());
                this.setTypeCasePrecedente(this.getNextCasePrec());


                this.setCasee(this.jeu.getPlateau()[this.ligneSuivante()][this.colonneSuivante()]);
                
                if(this.getCasee().getType() == TypeCase.CHAT || this.getCasee().getType() == TypeCase.CHIEN)
                {
                    this.setEtat(EtatAnimal.MORT);
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                }
                else
                {   
                    int myDirectionIndice = i;
                    this.setDirection(myDirectionIndice);
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].setType(TypeCase.SOURIS);       
                    this.jeu.getPlateau()[this.getCasee().getPositionL()][this.getCasee().getPositionC()].affecterAnimalCase(this);
                }
    
    }
    
public static void main(String[] args)
    {
        
        
        JeuModele monjeu = new JeuModele();
        
        
        Souris s1 = new Souris(1,monjeu.getPlateau()[1][2],monjeu);
        Case c = monjeu.getPlateau()[1][2];
                
        c.affecterAnimalCase(s1);
        
        
        System.out.println(s1.getClass().toString());
        
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC()); 
        
        
        
        
        s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
        
        s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
        
                s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
        
                s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
                s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
                s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
                s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
        
        s1.Deplacement();
        //position et direction apres deplacement
        System.out.println(s1.getDirection());
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());
    }
    
}
