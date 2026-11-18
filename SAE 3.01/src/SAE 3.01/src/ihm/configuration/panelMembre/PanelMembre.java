package src.ihm.configuration.panelMembre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import src.ihm.StyleOutils;
import src.ihm.configuration.PanelConfiguration;
import src.ihm.configuration.PanelMembres;
import src.ihm.configuration.btnAcceuil.BtnAcceuil;
import src.ihm.configuration.btnMembre.BtnMembre;

public class PanelMembre extends JPanel implements ActionListener
{
    protected PanelConfiguration panelConfiguration;

    protected BtnAcceuil         btnAcceuil;
    protected boolean            estActif;

    private   PanelMembres       panelMembres;
    private   JScrollPane        spMembres;

    protected JButton            btnAddMembre;

    protected PanelMembre( PanelConfiguration panelConfiguration )
    {
        this.panelConfiguration = panelConfiguration;
        this.estActif = true;
        this.spMembres = null;

        StyleOutils.setBackgroundWhite( this );
        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
        
        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.panelMembres = new PanelMembres();
        this.btnAddMembre = new JButton();
        StyleOutils.addStyleBtnAdd( this.btnAddMembre );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( panelMembres );
        this.add( btnAddMembre );

        /*---------------------------*/
        // Activation des composants //
        /*---------------------------*/
        this.btnAddMembre.addActionListener(this);
    }

    public void addMembre( BtnMembre btnMembre )
    {  
        this.panelMembres.addMembre(btnMembre);
                

        if (this.panelMembres.getTaille() > 3 && this.spMembres == null)
        {
            this.spMembres = new JScrollPane(this.panelMembres);

            this.remove(this.panelMembres);
            this.add(this.spMembres, 1);
        }

        this.btnAcceuil.setTxtNb( this.panelMembres.getTaille() );

        this.revalidate();
        this.repaint();
    }

    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == this.btnAcceuil )
            this.setAttributsVisible( ! this.estActif );
    }

    protected void setAttributsVisible( boolean isVisible )
    {
        this.estActif = isVisible;
        if ( this.estActif )
        {
            if ( this.spMembres != null )
                this.add( this.spMembres, 1 );
            else
                this.add( this.panelMembres, 1 );
            this.btnAcceuil.setIconFlecheBas();
        }
        else
        {
            if ( this.spMembres != null )
                this.remove( this.spMembres );
            else
                this.remove( this.panelMembres );
            this.btnAcceuil.setIconFlecheGauche();
        }
    this.revalidate();
    this.repaint();
    }
}
