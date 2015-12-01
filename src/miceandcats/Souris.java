package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public class Souris extends Animal{

    public Souris(int id, Case c) {
        super(id, c);
        
        this.setDirection(directions[1]);
    }

    @Override
    public void Deplacement() 
    {
         Case myCase = this.getCasee();
         //Case myNextCase = this.getCasee();
          
         // tester ou recuperer la prochaine case 
         myCase.setPositionC(myCase.getPositionC() + 1); 
         
         
         switch(myCase.getType())
         {
            
            // deplacement haut
            case MUR:
            myCase.setPositionC(myCase.getPositionL());
            myCase.setPositionC(myCase.getPositionL() + 1);
            break; 
             
            // deplacement haut
            case FHAUT:
            myCase.setPositionC(myCase.getPositionL() - 1);
            break;

            // deplacement droit
            case FDROITE:
            myCase.setPositionC(myCase.getPositionC() + 1);
            break;
            
            // deplacement bas
            case FBAS:
            myCase.setPositionC(myCase.getPositionL() + 1);
            break;
            
            // deplacement droit
            case FGAUCHE:
            myCase.setPositionC(myCase.getPositionC() - 1);
            break;
              
            // deplacement sur case vide     
            default: 
            myCase.setPositionC(myCase.getPositionC() + 1);
            
         }
         
    }
    
}
