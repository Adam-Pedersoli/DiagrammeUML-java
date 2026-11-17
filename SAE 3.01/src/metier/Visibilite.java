package src.metier;

public enum Visibilite
{
    PRIVATE( '-' ),
    PUBLIC( '+' ),
    PROTECTED( '#' ),
    PACKAGE( '~' );

    private final char visibilite;

    private Visibilite( char visibilite )
    {
        this.visibilite = visibilite;
    }

    public char getVisibilite()
    {
        return this.visibilite;
    }
}
