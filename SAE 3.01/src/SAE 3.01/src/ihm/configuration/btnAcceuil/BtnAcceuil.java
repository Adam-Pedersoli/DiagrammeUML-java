package src.ihm.configuration.btnAcceuil;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import src.ihm.StyleOutils;
import src.ihm.LblIconFleche;

public abstract class BtnAcceuil extends JButton
{
    protected JLabel lblNbAttribut;
    protected LblIconFleche lblIconFleche;
    protected JLabel lblTitre;

    protected BtnAcceuil()
    {
        StyleOutils.setBackgroundWhite( this );

        this.setLayout( new FlowLayout( FlowLayout.LEFT ) );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.lblIconFleche = new LblIconFleche();

        this.lblTitre = new JLabel( "Attribut" );
        StyleOutils.addStyleTxtBold( this.lblTitre );

        this.lblNbAttribut = new JLabel("0");
        StyleOutils.addStyleTxtGray( this.lblNbAttribut );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( this.lblIconFleche );
        this.add( this.lblTitre );
        this.add( this.lblNbAttribut );
    }

    public void setIconFlecheBas()
    {
        this.lblIconFleche.setIconFlecheBas();
    }

    public void setIconFlecheGauche()
    {
        this.lblIconFleche.setIconFlecheGauche();
    }

    public abstract void setTxtNb( int cpt );
}
