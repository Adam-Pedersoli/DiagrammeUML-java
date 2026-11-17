package src.metier;

public class Attribut
{
    private Visibilite visibilite;
    private boolean    estStatic;
    private Variable   variable;

    public Attribut()
    {
        this(false, Visibilite.PRIVATE, null);
    }

    public Attribut( boolean estStatic, Visibilite visibilite, Variable variable )
    {
        this.visibilite = Visibilite.PRIVATE;
        this.estStatic = false;
        this.variable = null;
    }

    public void setVisibilite( Visibilite visibilite )
    {
        if ( visibilite == null )
            return;
        this.visibilite = visibilite;
    }

    public void setEstStatic( boolean estStatic )
    {
        this.estStatic = estStatic;
    }

    public void setVariable( Variable variable )
    {
        if ( variable == null )
            return;
        this.variable = variable;
    }
}
