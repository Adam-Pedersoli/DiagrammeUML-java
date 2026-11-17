package src.ihm.classe;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelClasseHeader extends JPanel
{
    private JLabel lblDeclaration;
    private JLabel lblModificateur;
    private JLabel lblNom;

    public PanelClasseHeader( String declaration )
    {
        this.setLayout( new GridLayout( 0, 1 ) );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.lblDeclaration  = new JLabel( declaration, JLabel.CENTER );
        this.lblNom          = new JLabel( ""         , JLabel.CENTER );
        this.lblModificateur = new JLabel( ""         , JLabel.CENTER );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( this.lblDeclaration );
        this.add( this.lblNom );
        this.add( this.lblModificateur );
    }

    public void setTxtDeclaration( String declaration )
    {
        if ( declaration == null )
            return;
        this.lblDeclaration.setText( declaration ); 
    }

    public void setTxtNom( String nom )
    {
        if ( nom == null )
            return;
        this.lblNom.setText( nom );
    }

    public void setTxtModificateur( String modificateur )
    {
        if ( modificateur == null )
            return;
        this.lblNom.setText( modificateur );
    }
}
