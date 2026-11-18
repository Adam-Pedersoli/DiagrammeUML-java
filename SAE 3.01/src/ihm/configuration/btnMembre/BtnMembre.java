package src.ihm.configuration.btnMembre;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Graphics;

import src.ihm.StyleOutils;

public class BtnMembre extends JButton
{
    private JLabel lblVisibilite;
    private JLabel lblNom;

    public BtnMembre()
    {
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
        StyleOutils.dessinerArrondi( g, this );
        super.paintComponent( g );
    }
}
