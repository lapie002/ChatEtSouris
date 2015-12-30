package miceandcats;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Paul et Bruno
 */

public class ControlFleche extends MouseAdapter{

    private final int ligne;
    private final int colonne;
    private JeuModele modele;
    
    public ControlFleche(int i, int j, JeuModele jm){
        this.ligne=i;
        this.colonne=j;
        this.modele=jm;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        
                switch(modele.getPlateau()[ligne][colonne].getType()){
                    case CHEMIN:
                        if (modele.getNbFleches()>0){
                            
                            modele.getPlateau()[ligne][colonne] = new Case (TypeCase.FDROITE,ligne,colonne);
                            System.out.println(modele.getPlateau()[ligne][colonne].getType());
                            this.modele.setNbFleches(this.modele.getNbFleches() -1);
                        }
                        else{
                            System.out.println("non");
                        }
                        break;
                        
                    case FDROITE:
                        modele.getPlateau()[ligne][colonne] = new Case (TypeCase.FBAS,ligne,colonne);
                        System.out.println(modele.getPlateau()[ligne][colonne].getType());
                        this.modele.setNbFleches(this.modele.getNbFleches());
                        break;
                        
                    case FBAS:
                        modele.getPlateau()[ligne][colonne] = new Case (TypeCase.FGAUCHE,ligne,colonne);
                        System.out.println(modele.getPlateau()[ligne][colonne].getType());
                        this.modele.setNbFleches(this.modele.getNbFleches());
                        break;
                        
                    case FGAUCHE:
                        modele.getPlateau()[ligne][colonne] = new Case (TypeCase.FHAUT,ligne,colonne);
                        System.out.println(modele.getPlateau()[ligne][colonne].getType());
                        this.modele.setNbFleches(this.modele.getNbFleches());
                        break;
                        
                    case FHAUT:
                        modele.getPlateau()[ligne][colonne] = new Case (TypeCase.CHEMIN,ligne,colonne);
                        System.out.println(modele.getPlateau()[ligne][colonne].getType());
                        this.modele.setNbFleches(this.modele.getNbFleches() +1);
                        break;
                        
                    default:
                        System.out.println("Case introuvable");
                }
    }
}
