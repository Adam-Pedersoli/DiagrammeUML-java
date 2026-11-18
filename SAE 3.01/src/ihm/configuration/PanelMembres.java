package src.ihm.configuration;

import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import src.ihm.StyleOutils;
import src.ihm.configuration.btnMembre.BtnMembre;

public class PanelMembres extends JPanel
{
    private List<BtnMembre> lstBtnMembre;

    public PanelMembres()
    {
        this.lstBtnMembre = new ArrayList<BtnMembre>();
        
        StyleOutils.setBackgroundWhite(this);

        this.setLayout( new GridLayout( 0, 1 ) );
    }

    public int  getTaille()
    {
        return this.lstBtnMembre.size();
    }

    public BtnMembre getBtnMembre( int indice )
    {
        return this.lstBtnMembre.get( indice );
    }

    public void addMembre( BtnMembre btnMembre )
    {  
        this.lstBtnMembre.add( btnMembre );
        
        this.add( btnMembre );
    
        this.revalidate();
        this.repaint();
    }
}
