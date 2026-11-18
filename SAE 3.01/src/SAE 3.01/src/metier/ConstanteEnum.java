package src.metier;

import java.util.ArrayList;
import java.util.List;

public class ConstanteEnum
{
    private String nom;
    private List<String> lstNomVariable;

    public ConstanteEnum()
    {
        this( null, new ArrayList<String>() );
    }

    public ConstanteEnum( String nom, ArrayList<String> lstNomVariable)
    {
        this.nom  = nom;
        this.lstNomVariable = lstNomVariable;
    }

    public void setNom( String nom )
    {
        if ( nom == null )
            return;
        this.nom = nom;
    }

    public void addType( String nomVariable )
    {
        if ( nomVariable == null )
            return;
        this.lstNomVariable.add( nomVariable );
    }

}
