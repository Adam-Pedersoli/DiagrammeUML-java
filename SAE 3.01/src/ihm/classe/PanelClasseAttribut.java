package src.ihm.classe;

import java.awt.GridLayout;

import java.awt.font.TextAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelClasseAttribut extends JPanel
{
    private List<JLabel> lstLbl;

    public PanelClasseAttribut()
    {
        this.lstLbl = new ArrayList<JLabel>();

        this.setLayout( new GridLayout( 0, 1 ) );
    }

    private void setLbl( String txt, boolean estStatic )
    {
        JLabel lblAttribut;

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        lblAttribut = new JLabel( txt, JLabel.CENTER );
        
        if ( estStatic )
        {
            HashMap<TextAttribute, Object> attributs = new HashMap<TextAttribute, Object>();
            attributs.put( TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON );
            lblAttribut.setFont( lblAttribut.getFont().deriveFont( attributs ) );
        }

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( lblAttribut );

        lstLbl.add( lblAttribut );
        

    }
}