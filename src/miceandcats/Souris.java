package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public class Souris extends Animal{

    public Souris(int id, Case c) {
        
        super(id, c);
        this.setDirection(directions[1]);
        indiceDeDirection = 1; 
        
    }

    @Override
    public void Deplacement() 
    {
        
        
        String myDirection = this.getDirection();
        Case myCase = this.getCasee();
        
        //System.out.println(myDirection);
        
        TypeCase myTypeCase = myCase.getType();
        
        // retourne l'indice du tableau de direction
        int myDirectionIndice = retournIndiceDirection(myDirection);
         
         //Case myNextCase = this.getCasee();
          
         // tester ou recuperer la prochaine case 
         //myCase.setPositionC(myCase.getPositionC() + 1); 
     
         // switch(myTypeCase) myDirection
//         switch(myDirection)
//         {
//            
//            // deplacement haut du coup ca serait a supprimer 
//            /*case MUR:
//                
//            myCase.setPositionL(myCase.getPositionL() + 1);
//            myCase.setPositionC(myCase.getPositionC());
//            this.setCasee(myCase);
//            
//            myDirectionIndice = (myDirectionIndice + 1)%4; 
//            this.setDirection(myDirectionIndice);
//            break; 
//            */
//             
//            // deplacement haut ca c est le bon exemple 
//            case "FHAUT":
//                if(getNextCase(myCase))
//                {
//                    myCase.setPositionL(myCase.getPositionL() - 1);
//                    myCase.setPositionC(myCase.getPositionC());
//                    this.setCasee(myCase);
//                }
//                else
//                {
//                    myCase.setPositionL(myCase.getPositionL());
//                    myCase.setPositionC(myCase.getPositionC());
//                    this.setCasee(myCase);
//                    
//                    myDirectionIndice = (myDirectionIndice + 1)%4;
//                    //le setDirection() fait myDirection = directions[myDirectionIndice];
//                    this.setDirection(myDirectionIndice); 
//                }
//            break;
//
//            // deplacement droit
//            case "FDROITE":
//                
//                if(getNextCase(myCase))
//                {
//                    myCase.setPositionL(myCase.getPositionL());
//                    myCase.setPositionC(myCase.getPositionC() + 1);
//                    this.setCasee(myCase);
//                }
//                else
//                {
//                    myCase.setPositionL(myCase.getPositionL());
//                    myCase.setPositionC(myCase.getPositionC());
//                    this.setCasee(myCase);
//
//                    myDirectionIndice = (myDirectionIndice + 1)%4; 
//                    this.setDirection(myDirectionIndice);
//                }
//            break;
//            
//            // deplacement bas
//            case "FBAS":
//                if(getNextCase(myCase))
//                {
//                    myCase.setPositionL(myCase.getPositionL()+1);    
//                    myCase.setPositionC(myCase.getPositionL());
//                    this.setCasee(myCase);
//                }
//                else
//                {
//                    myCase.setPositionL(myCase.getPositionL());    
//                    myCase.setPositionC(myCase.getPositionL());
//                    this.setCasee(myCase);
//
//                    myDirectionIndice = (myDirectionIndice + 1)%4; 
//                    this.setDirection(myDirectionIndice);
//                }
//            break;
//            
//            // deplacement droit
//            case "FGAUCHE":
//                if(getNextCase(myCase))
//                {
//                    myCase.setPositionL(myCase.getPositionL()); 
//                    myCase.setPositionC(myCase.getPositionC() - 1);
//                    this.setCasee(myCase);
//                }
//                else
//                {
//                     myCase.setPositionL(myCase.getPositionL()); 
//                     myCase.setPositionC(myCase.getPositionC());
//                     this.setCasee(myCase);
//            
//                    myDirectionIndice = (myDirectionIndice + 1)%4; 
//                    this.setDirection(myDirectionIndice);
//                }
//            break;
//              
//            // deplacement sur case vide ERREUR VIENS DE LA CAR le reste ne s'excute pas 
//            
//            default: 
//                myCase.setPositionL(myCase.getPositionL());     
//                myCase.setPositionC(myCase.getPositionC() + 1);
//                this.setCasee(myCase);
//               
//         }
         
         //System.out.println("hello");
         //System.out.println(myDirection);
         
         if(myDirection=="AHAUT")
         {
                if(getNextCase(myCase))
                {
                    myCase.setPositionL(myCase.getPositionL() - 1);
                    myCase.setPositionC(myCase.getPositionC());
                    this.setCasee(myCase);
                }
                else
                {
                    myCase.setPositionL(myCase.getPositionL());
                    myCase.setPositionC(myCase.getPositionC());
                    this.setCasee(myCase);
                    
                    myDirectionIndice = (myDirectionIndice + 1)%4;
                    //le setDirection() fait myDirection = directions[myDirectionIndice];
                    this.setDirection(myDirectionIndice); 
                }
         }
         else if(myDirection=="ADROITE")
         {
             System.out.println(getNextCase(myCase));
                
                if(getNextCase(myCase))
                {
                    myCase.setPositionL(myCase.getPositionL());
                    myCase.setPositionC(myCase.getPositionC() + 1);
                    this.setCasee(myCase);
                }
                else
                {
                    myCase.setPositionL(myCase.getPositionL());
                    myCase.setPositionC(myCase.getPositionC());
                    this.setCasee(myCase);

                    myDirectionIndice = (myDirectionIndice + 1)%4; 
                    this.setDirection(myDirectionIndice);
                }
         }
         else if(myDirection=="ABAS")
         {
                if(getNextCase(myCase))
                {
                    myCase.setPositionL(myCase.getPositionL()+1);    
                    myCase.setPositionC(myCase.getPositionL());
                    this.setCasee(myCase);
                }
                else
                {
                    myCase.setPositionL(myCase.getPositionL());    
                    myCase.setPositionC(myCase.getPositionL());
                    this.setCasee(myCase);

                    myDirectionIndice = (myDirectionIndice + 1)%4; 
                    this.setDirection(myDirectionIndice);
                }
         }
         else if(myDirection=="AGAUCHE")
         {
                if(getNextCase(myCase))
                {
                    myCase.setPositionL(myCase.getPositionL()); 
                    myCase.setPositionC(myCase.getPositionC() - 1);
                    this.setCasee(myCase);
                }
                else
                {
                     myCase.setPositionL(myCase.getPositionL()); 
                     myCase.setPositionC(myCase.getPositionC());
                     this.setCasee(myCase);
            
                    myDirectionIndice = (myDirectionIndice + 1)%4; 
                    this.setDirection(myDirectionIndice);
                }
         }
         else
         {
                myCase.setPositionL(myCase.getPositionL());     
                myCase.setPositionC(myCase.getPositionC() + 1);
                this.setCasee(myCase);
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
    
    public boolean getNextCase(Case myCurrentCase)
    {
        //Case myCase = getCasee();
        Case currentCase = myCurrentCase;
        
        TypeCase myTypeCurrentCase = myCurrentCase.getType();
        boolean estUnBonneCase = false;
        
        String myDirection = this.getDirection();
        
        if(myDirection.equals("AHAUT"))
        {
            currentCase.setPositionL(currentCase.getPositionL() - 1);
            currentCase.setPositionC(currentCase.getPositionC());
            //this.setCasee(myNextCase);
            
            TypeCase myType = currentCase.getType();
            
            if(myType.equals(TypeCase.MUR))
            {
                estUnBonneCase = false;
                /* cette partie du code migre dans le switch
                myDirection = "FDROIT";
                this.setDirection(myDirection);
                */
            }
            else
            {
                estUnBonneCase = true;
            }
            
        }
        else if(myDirection.equals("ADROIT"))
        {
            currentCase.setPositionL(currentCase.getPositionL());
            currentCase.setPositionC(currentCase.getPositionC()+1);
            //this.setCasee(myNextCase);
            
            TypeCase myType = currentCase.getType();
            
            if(myType.equals(TypeCase.MUR))
            {
                estUnBonneCase = false;
                
            }
            else
            {
                estUnBonneCase = true;
            }
        }
        else if(myDirection.equals("ABAS"))
        {
            currentCase.setPositionL(currentCase.getPositionL());
            currentCase.setPositionC(currentCase.getPositionC()+1);
            //this.setCasee(myNextCase);
            
            TypeCase myType = currentCase.getType();
            
            if(myType.equals(TypeCase.MUR))
            {
                estUnBonneCase = false;
                
            }
            else
            {
                estUnBonneCase = true;
            }
        }
        else if(myDirection.equals("ABAS"))
        {
            currentCase.setPositionL(currentCase.getPositionL());
            currentCase.setPositionC(currentCase.getPositionC()+1);
            
            TypeCase myType = currentCase.getType();
            
            if(myType.equals(TypeCase.MUR))
            {
                estUnBonneCase = false;
              
            }
            else
            {
                estUnBonneCase = true;
            }
        }
         
        return estUnBonneCase;
    }
    
    
    public static void main(String[] args)
    {
        
        Case c0 = new Case(TypeCase.CHEMIN, 0,0);
        Case c1 = new Case(TypeCase.CHEMIN, 0,1);
        Case c2 = new Case(TypeCase.CHEMIN, 0,2);
        Case c3 = new Case(TypeCase.CHEMIN, 1,0);
        Case c4 = new Case(TypeCase.CHEMIN, 1,1);
        Case c5 = new Case(TypeCase.MUR, 1,2);
        Case c6 = new Case(TypeCase.CHEMIN, 2,0);
        Case c7 = new Case(TypeCase.CHEMIN, 2,1);
        Case c8 = new Case(TypeCase.CHEMIN, 2,2);
       
        
        Souris s1 = new Souris(1,c4);
        //position et direction avant deplacement
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
