package src.ihm.classe;

import java.awt.GridLayout;

import java.awt.font.TextAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import src.metier.Variable;

public class PanelClasseMethode extends JPanel
{
    private List<JLabel> lstLbl;

    public PanelClasseMethode()
    {
        this.lstLbl = new ArrayList<JLabel>();

        this.setLayout( new GridLayout( 0, 1 ) );
    }

    public void addMethode( String visibilite, String nom, List<Variable> lstParametres, String typeRetour, boolean estStatic ,boolean estAbstraite )
    {
        JLabel lblMethode;
        String txt = "";
        
        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        txt += visibilite + " " + nom + "( ";

        for ( Variable variable : lstParametres )
            txt += variable.getNom() + " : " + variable.getType() + " ,";
        txt = txt.substring( 0, txt.length() );

        txt += ") : " + typeRetour; 

        lblMethode = new JLabel( txt, JLabel.CENTER );

        if ( estStatic )
        {
            HashMap<TextAttribute, Object> attributs = new HashMap<TextAttribute, Object>();
            attributs.put( TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON );
            lblMethode.setFont( lblMethode.getFont().deriveFont( attributs ) );
        }

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add( lblMethode );

        lstLbl.add( lblMethode );
    }
}
