package src.ihm.configuration;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.ihm.CompOutils;
import src.ihm.configuration.attribut.BtnAcceuilAttribut;
import src.ihm.configuration.attribut.BtnAttribut;

public class PanelAttribut extends JPanel implements ActionListener
{
    private PanelConfiguration panelConfiguration;
    
    private BtnAcceuilAttribut btnAcceuilAttribut;
    private boolean            estActif;

    private List<BtnAttribut>  lstAttributs;
    private JButton            btnAddAttribut;

    public PanelAttribut( PanelConfiguration panelConfiguration )
    {
        this.panelConfiguration = panelConfiguration;
     
        this.lstAttributs = new ArrayList<BtnAttribut>();
        this.estActif = true;

        CompOutils.setBackgroundWhite( this );
        this.setLayout( new GridLayout(0, 1, 0, 5) );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.btnAcceuilAttribut = new BtnAcceuilAttribut( this );
        this.panelConfiguration.removeStyleBtn( this.btnAcceuilAttribut );

        this.btnAddAttribut     = new JButton("+ Ajouter un attribut");
        this.panelConfiguration.addStyleBtnAdd( this.btnAddAttribut );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( btnAcceuilAttribut );
        this.add( btnAddAttribut );

        /*---------------------------*/
        // Activation des composants //
        /*---------------------------*/
        this.btnAcceuilAttribut.addActionListener(this);
        this.btnAddAttribut.addActionListener(this);
    }

    public void addAttribut()
    {
        BtnAttribut btnAttribut = new BtnAttribut();
        this.lstAttributs.add( btnAttribut );
        this.add( btnAttribut, this.lstAttributs.size() );

        this.btnAcceuilAttribut.setTxtNb( this.lstAttributs.size() );
    
        this.revalidate();
        this.repaint();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnAddAttribut)
        {
            this.setAttributsVisible( true );
            this.addAttribut();
        }
        
        if ( e.getSource() == this.btnAcceuilAttribut )
            this.setAttributsVisible( ! this.estActif );
    }

    private void setAttributsVisible( boolean isVisible )
    {
        this.estActif = isVisible;
        for ( int cpt = 0 ; cpt < this.lstAttributs.size() ; cpt++ )
            if ( this.estActif )
            {    
                this.add( this.lstAttributs.get( cpt ), cpt + 1 );
                this.btnAcceuilAttribut.setIconFlecheBas();
            }
            else
            {
                this.remove( this.lstAttributs.get( cpt ) );
                this.btnAcceuilAttribut.setIconFlecheGauche();
            }
        this.revalidate();
        this.repaint();
    }

    public void addStyleTxtBold( JLabel lbl )
    {
        this.panelConfiguration.addStyleTxtBold( lbl );;
    }

    public void addStyleTxtGray( JLabel lbl )
    {
        this.panelConfiguration.addStyleTxtGray( lbl );
    }

}