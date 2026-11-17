package src;

import src.ihm.Frame;

import java.io.File;

import src.xml.GestionC;

public class Controleur
{
    private Frame    frame;
    private GestionC gestC;

    public Controleur()
    {
        this.frame = new Frame( this );
        this.gestC = new GestionC();
    }

    public void scannerFichier( File path )
    {
        this.gestC.scannerFichier( path );
    }

    public static void main( String[] args )
    {
        new Controleur();
    }
}
