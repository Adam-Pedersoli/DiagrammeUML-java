package src.metier;

import java.util.List;

public abstract class MembreClasse
{
    protected String         nom;
    private List<Variable> lstParametres;
    protected Visibilite     visibilite;

    protected MembreClasse( String nom, List<Variable> lstParametres, Visibilite visibilite )
    {
        this.nom = nom;
        this.lstParametres = lstParametres;
        this.visibilite = visibilite;
    }

    public void addParametre( Variable variable )
    {
        if ( variable == null )
            return;
        this.lstParametres.add( variable );
    }
}
