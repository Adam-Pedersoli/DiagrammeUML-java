package src.metier;

public class Variable
{
    private String     type;
    private String     nom;

    public Variable()
    {
        this(null, null);
    }

    public Variable( String type, String nom )
    {
        this.type = type;
        this.nom = nom;
    }
    
    public void setVariable( String variable )
    {
        if ( variable == null )
            return;
        this.type = variable;
    }

    public void setNom( String nom )
    {
        if ( nom == null )
            return;
        this.nom = nom;
    }

    public String getType()
    {
        return this.type;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String toString()
    {
        return this.nom + " : " + this.type;
    }

}
