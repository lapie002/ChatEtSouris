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
        
    }

    @Override
    public void Deplacement() 
    {
        String myDirection = this.getDirection();
        Case myCase = this.getCasee();
        TypeCase myTypeCase = myCase.getType();
        
        // retourne l'indice du tableau de direction
        int myDirectionIndice = retournIndiceDirection(myDirection);
        

         
        if(this.getNextCase() == TypeCase.MUR)
        {
                myDirectionIndice = (myDirectionIndice + 1)%4;
                this.setDirection(myDirectionIndice); 
        }
        
        else
        {
            //on retire l'animal de la case 
            this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].sortirAnimalCase(this);
                 
            myCase.setPositionL(ligneSuivante());
            myCase.setPositionC(colonneSuivante());
                    
            this.setCasee(myCase);
                    
            this.jeu.getPlateau()[myCase.getPositionL()][myCase.getPositionC()].affecterAnimalCase(this);
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
    
public static void main(String[] args)
    {
        
        
        JeuModele monjeu = new JeuModele();
        
        
        Souris s1 = new Souris(1,monjeu.getPlateau()[1][1],monjeu);
        Case c = monjeu.getPlateau()[1][1];
                
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
    }
    
}
