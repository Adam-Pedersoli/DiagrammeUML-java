package src.ihm.configuration.attribut;

import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import src.ihm.CompOutils;
import src.ihm.LblIconFleche;
import src.ihm.configuration.PanelAttribut;

public class BtnAcceuilAttribut extends JButton
{
    private PanelAttribut panelAttribut;
    private JLabel lblNbAttribut;
    private LblIconFleche lblIconFleche;

    public BtnAcceuilAttribut( PanelAttribut panelAttribut )
    {
        this.panelAttribut = panelAttribut;
        
        CompOutils.setBackgroundWhite( this );
        this.setLayout( new FlowLayout( FlowLayout.LEFT ) );

        JLabel lblTitre;

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.lblIconFleche = new LblIconFleche();

        lblTitre = new JLabel( "Attribut" );
        this.panelAttribut.addStyleTxtBold( lblTitre );

        this.lblNbAttribut = new JLabel("0");
        this.panelAttribut.addStyleTxtGray( this.lblNbAttribut );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( lblIconFleche );
        this.add( lblTitre );
        this.add( lblNbAttribut );
    }

    public void setTxtNb( int cpt )
    {
        this.lblNbAttribut.setText( cpt + "" );
    }

    public void setIconFlecheBas()
    {
        this.lblIconFleche.setIconFlecheBas();
    }

    public void setIconFlecheGauche()
    {
        this.lblIconFleche.setIconFlecheGauche();
    }
}
