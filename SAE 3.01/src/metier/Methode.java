package src.metier;

import java.util.ArrayList;
import java.util.List;

public class Methode extends MembreClasse
{
    private boolean estAbstraite;
    private boolean estStatique;
    private boolean estConstante;
    private boolean estSyncro;
    
    private String  typeRetour;

    public Methode()
    {
        this(false, false, false, false, null, null, new ArrayList<Variable>(), Visibilite.PUBLIC );
    }

    public Methode( boolean estStatique, boolean estAbstraite, boolean estConstante, boolean estSyncro, String typeRetour, String nom, List<Variable> lstParametres, Visibilite visibilite )
    {
        super(nom, lstParametres, visibilite);
        this.estAbstraite = estAbstraite;
        this.estStatique = estStatique;
        this.estConstante = estConstante;
        this.estSyncro = estSyncro;
        
        this.typeRetour = typeRetour;
    }
}