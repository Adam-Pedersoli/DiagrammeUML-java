package src.ihm.configuration.btnAcceuil;

public class BtnAcceuilMethode extends BtnAcceuil
{    
    public BtnAcceuilMethode()
    {
        super();
        super.lblTitre.setText( "Methode" );
    }

    public void setTxtNb( int cpt )
    {
        this.lblTitre.setText( cpt > 1 ? "Methodes" : "Methode" );
        super.lblNbAttribut.setText( cpt + "" );
    }
}
