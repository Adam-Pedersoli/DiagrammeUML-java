package src.ihm.configuration.panelMembre;


import java.awt.event.ActionEvent;

import src.ihm.StyleOutils;
import src.ihm.configuration.PanelConfiguration;
import src.ihm.configuration.btnAcceuil.BtnAcceuilAttribut;
import src.ihm.configuration.btnMembre.BtnAttribut;

public class PanelAttribut extends PanelMembre
{
    public PanelAttribut( PanelConfiguration panelConfiguration )
    {
        super( panelConfiguration );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        super.btnAcceuil    = new BtnAcceuilAttribut();
        StyleOutils.removeStyleBtn( this.btnAcceuil );
        super.btnAddMembre.setText("+ Ajouter un attribut");

        this.add( btnAcceuil, 0 );

        this.btnAcceuil.addActionListener(this);

        super.setAttributsVisible(!this.estActif);
    }

    public void addAttribut()
    {
        BtnAttribut btnAttribut = new BtnAttribut();
        super.addMembre( btnAttribut );
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == super.btnAddMembre )
        {
            super.setAttributsVisible( true );
            this.addAttribut();
        }
        
        super.actionPerformed( e );
    }
}