package src.ihm.menu_bar;

import javax.swing.JButton;

import java.awt.Graphics;

import src.ihm.StyleOutils;

public class BtnMenuBar extends JButton
{
    public BtnMenuBar( String txt )
    {
        this.setText( txt );
        this.setContentAreaFilled( false );
        this.setBorderPainted( false );
        this.setFocusPainted( false );
        this.setOpaque( false );
    }

    protected void paintComponent( Graphics g )
    {
        StyleOutils.dessinerArrondi( g, this );
        super.paintComponent( g );
    }
}
