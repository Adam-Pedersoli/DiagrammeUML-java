package src.metier;

import java.util.ArrayList;
import java.util.List;

public class Classe
{
    private boolean             estAbstraite;
    private boolean             estStatique;
    private boolean             estConstante;

    private Visibilite          visibilite;
    private Declaration         declaration;
    private String              nom;

    private List<Classe>        lstHeritages;
    private List<Classe>        lstImplementations;
    private List<Classe>        lstImbrication;

    private List<Constructeur>  lstConstructeur;
    private List<Attribut>      lstAttributs;
    private List<Methode>       lstMethodes;
    private List<ConstanteEnum> lstConstantesEnum;

    public Classe()
    {
        this( false, false, false, Visibilite.PUBLIC, Declaration.CLASSE, null );
    }

    public Classe( boolean estAbstraite, boolean estStatique, boolean estConstante, Visibilite visibilite, Declaration declaration, String nom )
    {
        setClasse( estAbstraite, estStatique, estConstante, visibilite, declaration, nom );
    }

    public Classe setClasse( boolean estAbstraite, boolean estStatique, boolean estConstante, Visibilite visibilite, Declaration declaration, String nom )
    {
        this.estAbstraite = estAbstraite;
        this.estStatique = estStatique;
        this.estConstante = estConstante;

        this.visibilite = visibilite;
        this.declaration = declaration;
        this.nom = nom;

        this.lstHeritages = new ArrayList<Classe>();
        this.lstImplementations = new ArrayList<Classe>();
        this.lstImbrication = new ArrayList<Classe>();

        this.lstConstructeur = new ArrayList<Constructeur>();
        this.lstAttributs = new ArrayList<Attribut>();
        this.lstMethodes  = new ArrayList<Methode>();
        this.lstConstantesEnum = new ArrayList<ConstanteEnum>();

        return this;
    }

    public void addHeritage( Classe classe )
    {
        if ( classe == null || this.lstHeritages.contains( classe ) )
            return;
        this.lstHeritages.add( classe );
    }

    public void addImplementation( Classe classe )
    {
        if ( classe == null || this.lstImplementations.contains( classe ) )
            return;
        this.lstImplementations.add( classe );
    }

    public void addAttribut( Attribut attribut )
    {
        if ( attribut == null || this.lstAttributs.contains( attribut ) )
            return;
        this.lstAttributs.add( attribut );
    }

    public void addConstructeur( Constructeur constructeur )
    {
        if ( constructeur == null )
            return;
        this.lstConstructeur.add( constructeur );
    }

    public void addMethode( Methode methode )
    {
        if ( methode == null || this.lstMethodes.contains( methode ) )
            return;
        this.lstMethodes.add( methode );
    }

    public void addConstanteEnum( ConstanteEnum constanteEnum )
    {
        if ( constanteEnum == null || ! this.declaration.equals( Declaration.ENUMERATION ) || this.lstConstantesEnum.contains( constanteEnum ) )
            return;
        this.lstConstantesEnum.add( constanteEnum );
    }

    public void setNom( String nom )
    {
        this.nom = nom;
    }

    public String getNom()
    {
        return this.nom;
    }
}