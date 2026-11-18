package src.ihm;

import src.Controleur;
import src.ihm.classe.BtnClasse;
import src.ihm.configuration.PanelConfiguration;

import java.awt.BorderLayout;
import java.awt.Color;

import java.io.File;
import java.util.HashMap;

import javax.swing.JFrame;

public class Frame extends JFrame
{
    private Controleur ctrl;

    private HashMap<BtnClasse, PanelConfiguration> mapConfiguration;

    public Frame( Controleur ctrl )
    {
        this.ctrl = ctrl;
        this.mapConfiguration = new HashMap<BtnClasse, PanelConfiguration>();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout( new BorderLayout() );
        this.setBackground( Color.WHITE );

        PanelMenuBar panelMenuBar;
        PanelConfiguration panelConfiguration;

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        panelMenuBar = new PanelMenuBar( this );
        panelConfiguration = new PanelConfiguration( this );
        
        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( panelMenuBar, BorderLayout.NORTH );
        this.add( panelConfiguration, BorderLayout.EAST );

        this.setVisible( true );
    }

    public void scannerFichier( File path )
    {
        this.ctrl.scannerFichier( path );
    }
}
