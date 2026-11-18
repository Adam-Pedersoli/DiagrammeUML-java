package src.ihm.menu_bar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import src.ihm.Frame;
import src.ihm.StyleOutils;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenuBar extends JPanel implements ActionListener
{
    private Frame   frame;
    
    private BtnMenuBar btnImporter;
    private BtnMenuBar btnEnregistrer;
    private BtnMenuBar btnEnregistrerSous;

    public PanelMenuBar( Frame frame )
    {
        this.frame = frame;

        StyleOutils.setBackground( this, null );
        
        StyleOutils.addStyleBorder( this, 1, 1, 0, 1 );
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.btnImporter = new BtnMenuBar("Importer");
        this.btnEnregistrer = new BtnMenuBar("Enregistrer");
        this.btnEnregistrerSous = new BtnMenuBar("Enregistrer Sous");

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        this.add(btnImporter );
        this.add(btnEnregistrer);
        this.add(btnEnregistrerSous);

        /*---------------------------*/
        // Activation des composants //
        /*---------------------------*/
        this.btnImporter.addActionListener(this);
        this.btnEnregistrer.addActionListener(this);
        this.btnEnregistrerSous.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnImporter)
        {
            JFileChooser selecteur = new JFileChooser();

            FileNameExtensionFilter filtre = new FileNameExtensionFilter( "Fichiers XML (*.xml)", "xml" );

            selecteur.setFileFilter(filtre);
            selecteur.setAcceptAllFileFilterUsed(false);
            
            int resultat = selecteur.showOpenDialog(this);

            if ( resultat == JFileChooser.APPROVE_OPTION )
                this.frame.scannerFichier( selecteur.getSelectedFile() );                
        }
        if (e.getSource() == this.btnEnregistrer)
        {

        }
        if (e.getSource() == this.btnEnregistrerSous)
        {

        }
    }
}