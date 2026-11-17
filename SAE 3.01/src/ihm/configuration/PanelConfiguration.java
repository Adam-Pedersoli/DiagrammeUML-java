package src.ihm.configuration;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.ihm.CompOutils;
import src.ihm.Frame;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;


public class PanelConfiguration extends JPanel
{
    private Frame frame;

    public PanelConfiguration( Frame frame )
    {
        this.frame = frame;

        CompOutils.setBackgroundWhite( this );
        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
        this.setAlignmentX( Component.LEFT_ALIGNMENT );

        PanelTitre panelTitre;
        PanelPresentation panelPresentation;
        PanelInfo panelInfo;
        PanelAttribut panelAttribut;

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        panelTitre        = new PanelTitre();
        panelPresentation = new PanelPresentation();
        panelInfo         = new PanelInfo();
        panelAttribut     = new PanelAttribut( this );
        
        CompOutils.addStyleBorder( panelTitre       , 1, 1, 1, 1 );
        CompOutils.addStyleBorder( panelPresentation, 0, 1, 1, 1 );
        CompOutils.addStyleBorder( panelInfo        , 0, 1, 1, 1 );
        CompOutils.addStyleBorder( panelAttribut    , 0, 1, 1, 1 );
        
        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( panelTitre );
        this.add( panelPresentation );
        this.add( panelInfo );
        this.add( panelAttribut );
    }

    public void removeStyleBtn( JButton btn )
    {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
    }

    public void addStyleBtnAdd( JButton btn )
    {
        this.removeStyleBtn( btn );
        btn.setHorizontalAlignment( SwingConstants.LEFT );
        btn.setForeground( new Color( 56, 107, 255 ) );
        btn.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    }

    public void addStyleBtnGray( JButton btn )
    {
        this.removeStyleBtn( btn );
        btn.setContentAreaFilled(true);
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setBorder( BorderFactory.createLineBorder(Color.GRAY, 1, true) );
    }

    public void addStyleTxtBold( JLabel lbl )
    {
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public void addStyleTxtGray( JLabel lbl )
    {
        lbl.setForeground(Color.GRAY);
    }
}
