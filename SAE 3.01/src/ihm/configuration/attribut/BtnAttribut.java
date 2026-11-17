
package src.ihm.configuration.attribut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import src.ihm.CompOutils;

public class BtnAttribut extends JButton
{
    private JLabel lblVisibilite;
    private JLabel lblNom;

    public BtnAttribut()
    {
        CompOutils.setBackgroundWhite( this );
        this.setLayout( new FlowLayout( FlowLayout.LEFT ) );

        this.setContentAreaFilled( false );
        this.setBorderPainted( false );
        this.setFocusPainted( false );
        this.setOpaque( false );

        this.setBackground( new Color( 245, 245, 245 ) );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.lblVisibilite = new JLabel( "-" );
        this.lblNom = new JLabel( "Numero" );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( lblVisibilite );
        this.add( lblNom );
    }

    protected void paintComponent( Graphics g )
    {
        CompOutils.dessinerArrondi( g, this );
        super.paintComponent( g );
    }
}
