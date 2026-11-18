package src.ihm.configuration.panelMembre;


import java.awt.event.ActionEvent;

import src.ihm.StyleOutils;
import src.ihm.configuration.PanelConfiguration;
import src.ihm.configuration.btnAcceuil.BtnAcceuilMethode;
import src.ihm.configuration.btnMembre.BtnMethode;

public class PanelMethode extends PanelMembre
{
    public PanelMethode( PanelConfiguration panelConfiguration )
    {
        super( panelConfiguration );

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        super.btnAcceuil    = new BtnAcceuilMethode();
        StyleOutils.removeStyleBtn( this.btnAcceuil );
        super.btnAddMembre.setText("+ Ajouter une methode");

        this.add( btnAcceuil, 0 );

        this.btnAcceuil.addActionListener(this);

        super.setAttributsVisible(!this.estActif);
    }

    public void addMethode()
    {
        BtnMethode btnMethode = new BtnMethode();
        super.addMembre( btnMethode );
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == super.btnAddMembre )
        {
            super.setAttributsVisible( true );
            this.addMethode();
        }
        
        super.actionPerformed( e );
    }
}