package src.ihm;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CompOutils 
{
    public static void setBackgroundWhite( JComponent comp )
    {
        comp.setBackground( Color.WHITE );
        comp.setOpaque( true );
    }    

    public static void addStyleBorder( JComponent comp, int haut, int gauche, int bas, int droite )
    {
        comp.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder( haut * 2, gauche * 2, bas * 2, droite * 2, Color.GRAY ),
                BorderFactory.createEmptyBorder( 10, 10, 10, 10 )
            )
        );
    }

    public static void dessinerArrondi( Graphics g, JComponent comp )
    {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor( comp.getBackground() );
        g2.fillRoundRect( 0, 0, comp.getWidth(), comp.getHeight(), 20, 20 );

        g2.dispose();
    }
}
