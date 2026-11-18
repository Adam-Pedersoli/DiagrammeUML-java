package src.ihm.configuration.btnAcceuil;

public class BtnAcceuilAttribut extends BtnAcceuil
{    
    public BtnAcceuilAttribut()
    {
        super();
        super.lblTitre.setText( "Attribut" );
    }

    public void setTxtNb( int cpt )
    {
        this.lblTitre.setText( cpt > 1 ? "Attributs" : "Attribut" );
        super.lblNbAttribut.setText( cpt + "" );
    }
}
