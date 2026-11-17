package src.ihm.configuration;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.ihm.CompOutils;
import src.ihm.LblIconFleche;

import java.awt.FlowLayout;
import java.awt.Component;


import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;

public class PanelPresentation extends JPanel
{
    private JLabel lblIcon;
    private JLabel lblNom;
    private JLabel lblDeclaration;

    public PanelPresentation()
    {
        CompOutils.setBackgroundWhite( this );
        this.setLayout( new FlowLayout() );
        this.setPreferredSize(new Dimension(300, 100));
        this.setMinimumSize(new Dimension(300, 100));

        JPanel panelNom = new JPanel();
        panelNom.setLayout( new BoxLayout(panelNom, BoxLayout.Y_AXIS) );
        panelNom.setAlignmentX( Component.LEFT_ALIGNMENT );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/        
        this.lblIcon = new JLabel( new ImageIcon( new ImageIcon( PanelPresentation.class.getResource("/src/ihm/image/icon_classe.png") ).getImage().getScaledInstance( 50, 50, Image.SCALE_SMOOTH ) ) );

        this.lblNom         = new JLabel( "Commande" );
        this.lblDeclaration = new JLabel( "Classe" );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        panelNom.add( lblNom );
        panelNom.add( lblDeclaration );

        this.add( lblIcon );
        this.add( panelNom );
    }
}
