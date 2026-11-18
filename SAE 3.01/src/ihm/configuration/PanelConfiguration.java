package src.ihm.configuration;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.ihm.StyleOutils;
import src.ihm.Frame;
import src.ihm.configuration.panelMembre.PanelAttribut;
import src.ihm.configuration.panelMembre.PanelMethode;

import java.awt.Component;

public class PanelConfiguration extends JPanel
{
    private Frame frame;

    private PanelTitre panelTitre;
    private PanelPresentation panelPresentation;
    private PanelInfo panelInfo;
    private PanelAttribut panelAttribut;
    private PanelMethode  panelMethode;

    public PanelConfiguration( Frame frame )
    {
        this.frame = frame;

        StyleOutils.setBackgroundWhite( this );
        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
        this.setAlignmentX( Component.LEFT_ALIGNMENT );


        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.panelTitre        = new PanelTitre();
        this.panelPresentation = new PanelPresentation();
        this.panelInfo         = new PanelInfo();
        this.panelAttribut     = new PanelAttribut( this );
        this.panelMethode      = new PanelMethode( this );
        
        StyleOutils.addStyleBorder( this.panelTitre       , 1, 1, 1, 1 );
        StyleOutils.addStyleBorder( this.panelPresentation, 0, 1, 1, 1 );
        StyleOutils.addStyleBorder( this.panelInfo        , 0, 1, 1, 1 );
        StyleOutils.addStyleBorder( this.panelAttribut    , 0, 1, 1, 1 );
        StyleOutils.addStyleBorder( this.panelMethode     , 0, 1, 1, 1 );
        
        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( this.panelTitre );
        this.add( this.panelPresentation );
        this.add( this.panelInfo );
        this.add( this.panelAttribut );
        this.add( this.panelMethode );
    }
}
