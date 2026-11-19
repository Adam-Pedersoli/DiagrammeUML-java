package src.ihm.configuration.btnMembre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import src.ihm.LblIconFleche;
import src.ihm.StyleOutils;
import src.ihm.configuration.PanelMembres;

public class BtnMembre extends JPanel implements ActionListener
{
    private PanelMembres panelMembres;
    
    private JButton btn;
    private Color couleurBordure;
    
    private JLabel lblVisibilite;
    private JLabel lblNom;

    private LblIconFleche lblIconFleche;

    private boolean estActif;

    public BtnMembre()
    {        
        this.estActif = true;
        this.couleurBordure = new Color( 245, 245, 245 );

        this.setLayout( new GridLayout(0, 1) );
        this.setBackground( Color.WHITE );

        this.btn = new JButton()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                StyleOutils.dessinerArrondi(g, this);
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setColor( couleurBordure );
                g2.setStroke(new BasicStroke( 1 ));

                g2.drawRoundRect(
                    0, 0,
                    getWidth() - 1,
                    getHeight() - 1,
                    15, 15
                );

                g2.dispose();
            }
        };
        
        JPanel panelText;
        
        /*-------------------------*/
        // Creation des composants //
        /*-------------------------*/
        this.btn.setLayout( new BorderLayout() );

        this.btn.setContentAreaFilled( false );
        this.btn.setBorderPainted( false );
        this.btn.setFocusPainted( false );
        this.btn.setOpaque( false );

        this.btn.setBackground( new Color( 245, 245, 245 ) );
        
        panelText = new JPanel();
        panelText.setOpaque( false );

        this.lblVisibilite = new JLabel( "-" );
        this.lblVisibilite.setOpaque( false );
        this.lblNom = new JLabel( "Numero" );
        this.lblNom.setOpaque( false );


        this.lblIconFleche = new LblIconFleche();
        StyleOutils.setBackground( this.lblIconFleche, new Color( 245, 245, 245 ) );
        this.lblIconFleche.setOpaque( false );

        /*-------------------------------*/
        // Positionnement des composants //
        /*-------------------------------*/
        panelText.add( lblVisibilite );
        panelText.add( lblNom );

        this.btn.add( panelText, BorderLayout.WEST );
        this.btn.add( lblIconFleche, BorderLayout.EAST );

        this.add( this.btn );

        /*---------------------------*/
        // Activation des composants //
        /*---------------------------*/
        this.btn.addActionListener( this );
    }
    
    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == this.btn )
        {
            this.panelMembres.setActivBtn( this.btn );
            estActif = ! estActif;
        }
    }

    public void btnActif( boolean estActif )
    {
        if ( estActif )
        {
            this.btn.setBackground( new Color(199, 209, 255) );
            this.setCouleurBordure( new Color(118, 125, 139) );
            this.lblIconFleche.setIconFlecheBas();
        }
        else
        {
            this.btn.setBackground( new Color(245, 245, 245) );
            this.setCouleurBordure( new Color(245, 245, 245) );
            this.lblIconFleche.setIconFlecheGauche();
        }
    }

    protected void paintComponent( Graphics g )
    {
        StyleOutils.dessinerArrondi( g, this );
        super.paintComponent( g );
    }

    public JButton getBtn()
    {
        return this.btn;
    }

    public void setCouleurBordure(Color couleur)
    {
        this.couleurBordure = couleur;
        this.btn.repaint();
    }

    public void setPanelMembres( PanelMembres panelMembres )
    {
        this.panelMembres = panelMembres;
    }
}
