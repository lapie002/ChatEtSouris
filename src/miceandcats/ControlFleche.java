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
    
    public ControlFleche(int i, int j){
        this.ligne=i;
        this.colonne=j;
    }
    
    public void mouseClicked(MouseEvent e){
        
    }
}
