package src.metier;

public enum Declaration
{
    CLASSE( "classe" ),
    ENUMERATION( "enumération" ),
    INTERFACE( "interface" );

    private final String declaration;

    private Declaration( String declaration )
    {
        this.declaration = declaration;
    }

    public String getDeclaration()
    {
        return this.declaration;
    }
}
