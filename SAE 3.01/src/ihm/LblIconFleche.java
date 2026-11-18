package src.ihm;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.ihm.configuration.PanelPresentation;

public class LblIconFleche extends JLabel
{
    private static final ImageIcon ICON_FLECHE_BAS    = new ImageIcon( PanelPresentation.class.getResource("/src/ihm/image/icon_fleche_bas.png"   ) );
    private static final ImageIcon ICON_FLECHE_GAUCHE = new ImageIcon( PanelPresentation.class.getResource("/src/ihm/image/icon_fleche_gauche.png") );
    
    public LblIconFleche()
    {
        StyleOutils.setBackground( this, null );
        this.setIconFlecheGauche();
    }

    public void setIconFlecheBas()
    {
        this.setIcon( new ImageIcon( LblIconFleche.ICON_FLECHE_BAS.getImage().getScaledInstance( 20, 20, Image.SCALE_SMOOTH ) ) );
    }

    public void setIconFlecheGauche()
    {
        this.setIcon( new ImageIcon( LblIconFleche.ICON_FLECHE_GAUCHE.getImage().getScaledInstance( 20, 20, Image.SCALE_SMOOTH ) ) );
    }
}
