package src.metier;

import java.util.ArrayList;
import java.util.List;

public class Constructeur extends MembreClasse
{
    public Constructeur()
    {
        this( null, new ArrayList<Variable>(), Visibilite.PUBLIC );
    }

    public Constructeur( String nom, List<Variable> lstParametres, Visibilite visibilite )
    {
        super(nom, lstParametres, visibilite);
    }
}
