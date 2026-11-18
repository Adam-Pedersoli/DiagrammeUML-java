package src.metier;

public class Constante extends Variable
{
    private String valeur;
    
    public Constante()
    {
        this( null, null, null );
    }

    public Constante( String type, String nom, String valeur )
    {
        super( type, nom );
        this.valeur = valeur;
    }

    public void setValeur( String valeur )
    {
        if ( valeur == null )
            return;
        this.valeur = valeur;
    }
}
