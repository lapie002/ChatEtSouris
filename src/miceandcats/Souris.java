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
        
        
        TypeCase myTypeCase = myCase.getType();
        
        // retourne l'indice du tableau de direction
        int myDirectionIndice = retournIndiceDirection(myDirection);
         
         //Case myNextCase = this.getCasee();
          
         // tester ou recuperer la prochaine case 
         //myCase.setPositionC(myCase.getPositionC() + 1); 
     
        
        
        
        
        
         switch(myTypeCase)
         {
            
            // deplacement haut
            case MUR:
                
            myCase.setPositionL(myCase.getPositionL() + 1);
            myCase.setPositionC(myCase.getPositionC());
            this.setCasee(myCase);
            
            myDirectionIndice = (myDirectionIndice + 1)%4; 
            this.setDirection(myDirectionIndice);
            break; 
             
            // deplacement haut
            case FHAUT:
            myCase.setPositionL(myCase.getPositionL() - 1);
            myCase.setPositionC(myCase.getPositionC());
            this.setCasee(myCase);
            
            myDirectionIndice = (myDirectionIndice + 1)%4; 
            this.setDirection(myDirectionIndice);
            break;

            // deplacement droit
            case FDROITE:
            myCase.setPositionL(myCase.getPositionL());
            myCase.setPositionC(myCase.getPositionC() + 1);
            this.setCasee(myCase);
            
            myDirectionIndice = (myDirectionIndice + 1)%4; 
            this.setDirection(myDirectionIndice);
            break;
            
            // deplacement bas
            case FBAS:
            myCase.setPositionL(myCase.getPositionL()+1);    
            myCase.setPositionC(myCase.getPositionL());
            this.setCasee(myCase);
            
            myDirectionIndice = (myDirectionIndice + 1)%4; 
            this.setDirection(myDirectionIndice);
            break;
            
            // deplacement droit
            case FGAUCHE:
            myCase.setPositionL(myCase.getPositionL()); 
            myCase.setPositionC(myCase.getPositionC() - 1);
            this.setCasee(myCase);
            
            myDirectionIndice = (myDirectionIndice + 1)%4; 
            this.setDirection(myDirectionIndice);
            break;
              
            // deplacement sur case vide     
            default: 
            myCase.setPositionL(myCase.getPositionL());     
            myCase.setPositionC(myCase.getPositionC() + 1);
            this.setCasee(myCase);
                
            myDirectionIndice = (myDirectionIndice + 1)%4; 
            this.setDirection(myDirectionIndice);    
            
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
    
    public boolean getNextCase()
    {
        Case myCase = getCasee();
        
        String myDirection = this.getDirection();
        
        if(myDirection.equals("FHAUT"))
        {
        
        }
        else if(myDirection.equals("FDROIT"))
        {}
        else if(myDirection.equals("FBAS"))
        {}
        else 
        {}
         
        
    
    }
    
    
    public static void main(String[] args)
    {
        
        Case c0 = new Case(TypeCase.VIDE, 0,0);
        Case c1 = new Case(TypeCase.VIDE, 0,1);
        Case c2 = new Case(TypeCase.VIDE, 0,2);
        Case c3 = new Case(TypeCase.VIDE, 1,0);
        Case c4 = new Case(TypeCase.VIDE, 1,1);
        Case c5 = new Case(TypeCase.MUR, 1,2);
        Case c6 = new Case(TypeCase.VIDE, 2,0);
        Case c7 = new Case(TypeCase.VIDE, 2,1);
        Case c8 = new Case(TypeCase.VIDE, 2,2);
       
        
        Souris s1 = new Souris(1,c4);
        
        s1.Deplacement();
        
        System.out.println(s1.getDirection());
        
        System.out.println(s1.getCasee().getPositionL()); 
        System.out.println(s1.getCasee().getPositionC());    
        
                
        
        
        
        
    }
    
}
