package src.xml;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.File;

import org.jdom2.input.SAXBuilder;
import org.jdom2.JDOMException;
import org.jdom2.Document;
import org.jdom2.Element;

import src.metier.ConstanteEnum;
import src.metier.Constructeur;
import src.metier.Declaration;
import src.metier.Visibilite;
import src.metier.Constante;
import src.metier.Attribut;
import src.metier.Variable;
import src.metier.Methode;
import src.metier.Classe;
import src.metier.Projet;

public class GestionC
{
    private SAXBuilder sxb;
    private List<Projet> lstProjets;

    public GestionC()
    {
        this.lstProjets = new ArrayList<Projet>();
        this.sxb = new SAXBuilder();
    }

    public void scannerFichier( File path )
    {
        try
        {
            Projet projet = new Projet( path );
            this.scannerClasses( sxb.build( path ).getRootElement(), projet );
        }
        catch( IOException | JDOMException e )
        {
            e.printStackTrace();
        }
    }

    private void scannerClasses( Element racine, Projet projet )
    {
        projet.setNom( racine.getChildText( "nomProjet" ) );

        for ( Element elemClasse : racine.getChildren("classe" ) )
        {     
            Classe classe = this.scannerClasse( elemClasse, projet );

            if ( elemClasse.getChild( "heritages" ) != null )
                for ( Element elemHeritage : elemClasse.getChild( "heritages" ).getChildren("heritage") )
                    this.scannerHeritage( elemHeritage, classe, projet );

            if ( elemClasse.getChild( "implementations" ) != null )
                for ( Element elemImplementation : elemClasse.getChild( "implementations" ).getChildren("implementation") )
                    this.scannerImplementation( elemImplementation, classe, projet );
            
            if ( elemClasse.getChild( "constantesEnum" ) != null )
                for ( Element elemConstanteEnum : elemClasse.getChild( "constantesEnum" ).getChildren("constanteEnum") )
                    classe.addConstanteEnum( ( this.scannerConstanteEnum( elemConstanteEnum ) ) );

            if ( elemClasse.getChild( "attributs" ) != null )
                for ( Element elemAttribut : elemClasse.getChild( "attributs" ).getChildren("attribut") )
                    classe.addAttribut( this.scannerAttribut( elemAttribut ) );
            
            if ( elemClasse.getChild( "constructeurs" ) != null )
                for ( Element elemConstructeur : elemClasse.getChild( "constructeurs" ).getChildren("constructeur") )
                    classe.addConstructeur( this.scannerConstructeur(  elemConstructeur, classe ) );

            if ( elemClasse.getChild( "methodes" ) != null )
                for ( Element elemMethode : elemClasse.getChild( "methodes" ).getChildren("methode") )
                    classe.addMethode( this.scannerMethode( elemMethode ) );
            
            
            if ( this.existeClasse( classe.getNom(), projet ) == null )
                projet.addClasse( classe );
        }

        this.lstProjets.add( projet );
    }

    private Visibilite scannerVisibilite( Element elem )
    {
        char txtVisibilite = elem.getChildText( "visibilite" ).charAt( 0 );
        for ( Visibilite v : Visibilite.values() )
            if ( v.getVisibilite() == txtVisibilite )
                return v;
        return null;
    }

    private Classe scannerClasse( Element elem, Projet projet )
    {
        if ( elem == null )
            return null;

        boolean estAbstraite = this.estActif(elem, "abstraite");
        boolean estStatique  = this.estActif(elem, "statique");
        boolean estConstante = this.estActif(elem, "constante");

        Visibilite visibilite = this.scannerVisibilite(elem);
        
        String txtDeclaration = elem.getChildText( "declaration" );
        Declaration declaration = null;
        for ( Declaration d : Declaration.values() )
            if ( d.getDeclaration().equals( txtDeclaration ) )
                declaration = d;
        
        String nomClasse = elem.getChildText( "nomClasse" );

        Classe c = this.existeClasse( nomClasse, projet );
        if ( c != null )
        {
            c.setClasse(estAbstraite, estStatique, estConstante, visibilite, declaration, nomClasse);
            return c;
        }
        c = new Classe( estAbstraite, estStatique, estConstante, visibilite, declaration, nomClasse );
        projet.addClasse(c);
        
        return c;
    }

    private void   scannerHeritage( Element elem, Classe classe, Projet projet )
    {
        Classe c = this.existeClasse( elem.getChildText( "heritage" ), projet );
        if ( c == null )
        {
            c = new Classe();
            c.setNom( elem.getChildText( "heritage" ) );
            projet.addClasse( c );
        }
            
        classe.addHeritage(c);                     
    }

    private void   scannerImplementation( Element elem, Classe classe, Projet projet )
    {
        Classe c = this.existeClasse( elem.getChildText( "implementation" ), projet );
        if ( c == null )
        {
            c = new Classe();
            c.setNom( elem.getChildText( "implementation" ) );
            projet.addClasse( c );

        }
            
        classe.addImplementation(c);                     
    }

    private ConstanteEnum scannerConstanteEnum( Element elem )
    {
        String nomConstanteEnum = elem.getChildText( "nomConstanteEnum" );

        ArrayList<String> lstValeursConstanteEnum = new ArrayList<String>();
        if ( elem.getChild( "valeursConstanteEnum" ) != null )
            for ( Element elemValeurConstanteEnum : elem.getChild("valeursConstanteEnum").getChildren("valeurConstanteEnum") )
                lstValeursConstanteEnum.add( elemValeurConstanteEnum.getText() );

        return new ConstanteEnum(nomConstanteEnum, lstValeursConstanteEnum);
    }

    private Attribut scannerAttribut( Element elem )
    {
        boolean estStatique  = this.estActif(elem, "statique");
        
        Visibilite visibilite = scannerVisibilite(elem);
        Variable   variable   = scannerVariable(elem, "Attribut");

        return new Attribut( estStatique, visibilite, variable );
    }

    private Variable scannerVariable( Element elem, String nom )
    {
        String  type = elem.getChildText( "type" );
        String  nomAttribut = elem.getChildText( "nom" + nom );

        if ( this.estActif(elem, "constante") )
        {
            String valeur = elem.getChildText( "valeur" );
            return new Constante( type, nomAttribut, valeur );
        }

        return new Variable( type, nomAttribut );
    }

    private Constructeur scannerConstructeur( Element elem, Classe classe )
    {
        ArrayList<Variable> lstVariables = new ArrayList<Variable>();
        if ( elem.getChild( "parametres" ) != null )
            lstVariables = this.scannerParametre( elem );
        
        Visibilite visibilite = this.scannerVisibilite(elem);

        return new Constructeur( classe.getNom(), lstVariables, visibilite );
    }

    private Methode scannerMethode( Element elem )
    {
        boolean estAbstraite   = this.estActif(elem, "abstraite");
        boolean estStatique    = this.estActif(elem, "statique");
        boolean estConstante   = this.estActif(elem, "constante");
        boolean estSynchronise = this.estActif(elem, "synchronise");
        
        String typeRetour = elem.getChildText( "typeRetour" );

        String nomMethode = elem.getChildText( "nomMethode" );

        ArrayList<Variable> lstVariable = new ArrayList<Variable>();
        if ( elem.getChild( "parametres" ) != null )
            lstVariable = this.scannerParametre( elem );

        Visibilite visibilite = this.scannerVisibilite(elem);

        return new Methode( estStatique, estAbstraite, estConstante, estSynchronise, typeRetour, nomMethode, lstVariable, visibilite );       
    }

    private ArrayList<Variable> scannerParametre( Element elem )
    {
        ArrayList<Variable> lstVariables = new ArrayList<Variable>();
        for ( Element elemParametre : elem.getChild( "parametres" ).getChildren("parametre") )
            lstVariables.add( this.scannerVariable( elemParametre, "Parametre" ) );
        return lstVariables;
    }

    private Classe existeClasse( String nomClasse, Projet projet )
    {
        for ( Classe c : projet.getClasses() )
            if ( c.getNom().equals( nomClasse ) )
                return c;
        return null;
    }

    private boolean estActif( Element elem, String attribut )
    {
        return Boolean.parseBoolean( elem.getAttributeValue( attribut ) );
    }
}