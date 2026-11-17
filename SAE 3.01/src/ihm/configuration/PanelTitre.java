package src.ihm.configuration;

import javax.swing.JLabel;
import javax.swing.JPanel;

import src.ihm.CompOutils;

public class PanelTitre extends JPanel
{
    public PanelTitre()
    {
        CompOutils.setBackgroundWhite( this );
        JLabel lblTitre;
        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        lblTitre = new JLabel( "Propriétés" );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add(lblTitre);
    }
}