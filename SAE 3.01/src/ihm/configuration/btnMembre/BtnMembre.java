package src.ihm.configuration.btnMembre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import src.ihm.LblIconFleche;
import src.ihm.StyleOutils;

public class BtnMembre extends JButton implements ActionListener
{
    private JLabel lblVisibilite;
    private JLabel lblNom;

    private LblIconFleche lblIconFleche;

    public BtnMembre()
    {
        this.setLayout( new BorderLayout() );

        this.setContentAreaFilled( false );
        this.setBorderPainted( false );
        this.setFocusPainted( false );
        this.setOpaque( false );

        this.setBackground( new Color( 245, 245, 245 ) );

        JPanel panelText;
        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        panelText = new JPanel();
        StyleOutils.setBackground( panelText, new Color( 245, 245, 245 ) );

        this.lblVisibilite = new JLabel( "-" );
        this.lblNom = new JLabel( "Numero" );

        this.lblIconFleche = new LblIconFleche();
        StyleOutils.setBackground( this.lblIconFleche, new Color( 245, 245, 245 ) );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        panelText.add( lblVisibilite );
        panelText.add( lblNom );

        this.add( panelText, BorderLayout.WEST );
        this.add( lblIconFleche, BorderLayout.EAST );

        /*---------------------------*/
        // Activation des composants //
        /*---------------------------*/

    }
    
    public void actionPerformed( ActionEvent e )
    {
        if (e.getSource() == this )
            this.setAttributsVisible(!this.estActif);
    }

    protected void paintComponent( Graphics g )
    {
        StyleOutils.dessinerArrondi( g, this );
        super.paintComponent( g );
    }
}
