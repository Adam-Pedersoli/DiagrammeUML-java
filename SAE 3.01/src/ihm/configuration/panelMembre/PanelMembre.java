package src.ihm.configuration.panelMembre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import src.ihm.StyleOutils;
import src.ihm.configuration.PanelConfiguration;
import src.ihm.configuration.PanelMembres;
import src.ihm.configuration.btnAcceuil.BtnAcceuil;
import src.ihm.configuration.btnMembre.BtnMembre;

public class PanelMembre extends JPanel implements ActionListener
{
    protected PanelConfiguration panelConfiguration;
    protected BtnAcceuil btnAcceuil;
    protected boolean estActif;

    private PanelMembres panelMembres;
    private JScrollPane spMembres;

    protected JButton btnAddMembre;

    protected PanelMembre(PanelConfiguration panelConfiguration)
    {
        this.panelConfiguration = panelConfiguration;
        this.estActif = false;

        StyleOutils.setBackground( this, null );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMinimumSize(new Dimension( Integer.MAX_VALUE, 150 ));
        this.setMaximumSize(new Dimension( Integer.MAX_VALUE, 500 ) );
        this.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.panelMembres = new PanelMembres();
        this.btnAddMembre = new JButton();


        this.spMembres = new JScrollPane(this.panelMembres);
        StyleOutils.addStyleScrollPane(this.spMembres);

        StyleOutils.addStyleBtnAdd(this.btnAddMembre);

        this.add(this.spMembres);
        this.add(this.btnAddMembre);

        this.btnAddMembre.addActionListener(this);
    }

    public void addMembre(BtnMembre btnMembre)
    {
        this.panelMembres.addMembre(btnMembre);
        this.btnAcceuil.setTxtNb(this.panelMembres.getTaille());
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnAcceuil)
            this.setAttributsVisible(!this.estActif);
    }

    protected void setAttributsVisible(boolean isVisible)
    {
        this.estActif = isVisible;

        if (this.estActif)
        {
            if (this.spMembres != null)
                this.add(this.spMembres, 1);

            this.setMinimumSize(new Dimension( Integer.MAX_VALUE, 150 ));
            this.setMaximumSize(new Dimension( Integer.MAX_VALUE, 500 ) );
            this.btnAcceuil.setIconFlecheBas();
        }
        else
        {
            if (this.spMembres != null)
                this.remove(this.spMembres);

            this.setMinimumSize(new Dimension( Integer.MAX_VALUE, 100 ));
            this.setMaximumSize(new Dimension( Integer.MAX_VALUE, 100 ) );
            this.btnAcceuil.setIconFlecheGauche();
        }

        this.revalidate();
        this.repaint();
    }
}