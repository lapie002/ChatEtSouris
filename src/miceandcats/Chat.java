package miceandcats;

/**
 *
 * @author Paul et Bruno
 */

public class Chat extends Animal {

    public Chat(int id, Case c, JeuModele jm) {
        super(id, c, jm);
    }

    @Override
    public void Deplacement() 
    {
        
         Case myCase = this.getCasee();
   
         myCase.setPositionC(myCase.getPositionC() + 1); 
         
         myCase.setPositionC(myCase.getPositionC() - 1); 

    }
    
}
