package src.metier;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class Projet
{
    private String nom;
    private List<Classe> lstClasse;
    private ArrayList<File> lstPath;

    public Projet( File path )
    {  
        this.lstClasse = new ArrayList<Classe>();
        this.lstPath   = new ArrayList<File>();

        this.lstPath.add( path );
    }

    public void addClasse( Classe classe )
    {
        if ( classe == null )
            return;
        this.lstClasse.add( classe );
    }

    public void setNom( String nom )
    {
        this.nom = nom;
    }

    public List<Classe> getClasses()
    {
        return this.lstClasse;
    }
}
