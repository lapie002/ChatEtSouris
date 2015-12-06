package miceandcats;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Paul et Bruno
 */

public class ControlFleche extends MouseAdapter{

    private int ligne;
    private int colonne;
    private JeuModele modele;
    
    public ControlFleche(int i, int j){
        this.ligne=i;
        this.colonne=j;
        
        modele = new JeuModele();
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        
        for (int i=0;i<modele.getCases().size();i++){
            if (modele.getCases().get(i).getPositionL()==this.ligne && modele.getCases().get(i).getPositionC()==this.colonne){
                switch (modele.getCases().get(i).getType()){
                    case VIDE :
                        modele.getCases().get(i).setType(TypeCase.FDROITE);
                    break;
                        
                    case FDROITE :
                        modele.getCases().get(i).setType(TypeCase.FBAS);
                    break;
                    
                    case FBAS :
                        modele.getCases().get(i).setType(TypeCase.FGAUCHE);
                    break;
                        
                    case FGAUCHE :
                        modele.getCases().get(i).setType(TypeCase.FHAUT);
                    break;
                        
                    case FHAUT :
                        modele.getCases().get(i).setType(TypeCase.VIDE);
                    break;
                    
                    default:
                        System.out.println("Impossible d'effectuer cette action, cette case n'est pas vide.");
                }
                    
            }
            
            else {
                System.out.println("Case introuvable");
            }
        }
        
    }
}
