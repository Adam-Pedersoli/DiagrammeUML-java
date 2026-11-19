package src.ihm;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Cursor;
import java.awt.Font;

public class StyleOutils 
{
    public static void setBackground( JComponent comp, Color color )
    {
        comp.setBackground( color == null ? Color.WHITE : color );
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
        g2.fillRoundRect( 0, 0, comp.getWidth(), comp.getHeight(), 15, 15 );

        g2.dispose();
    }

    public static void addStyleSelect( JButton btn )
    {
        btn.setBackground( new Color( 199, 209, 255 ) );
    }

    public static void addStyleScrollPane( JScrollPane sp )
    {
        sp.setBorder( null );
        sp.setBackground( null );
        sp.getViewport().setBackground(null);
        sp.setViewportBorder( BorderFactory.createEmptyBorder(0, 0, 0, 10) );
        sp.setWheelScrollingEnabled(true);
        sp.getVerticalScrollBar().setUnitIncrement(2);
    }

    public static void removeStyleBtn( JButton btn )
    {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
    }

    public static void addStyleBtnAdd( JButton btn )
    {
        StyleOutils.removeStyleBtn( btn );
        btn.setHorizontalAlignment( SwingConstants.LEFT );
        btn.setForeground( new Color( 56, 107, 255 ) );
        btn.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    }

    public static void addStyleBtnGray( JButton btn )
    {
        StyleOutils.removeStyleBtn( btn );
        btn.setContentAreaFilled(true);
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setBorder( BorderFactory.createLineBorder(Color.GRAY, 1, true) );
    }

    public static void addStyleTxtBold( JLabel lbl )
    {
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public static void addStyleTxtGray( JLabel lbl )
    {
        lbl.setForeground(Color.GRAY);
    }
}
