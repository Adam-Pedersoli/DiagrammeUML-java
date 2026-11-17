package src.ihm.configuration;

import javax.swing.*;

import src.ihm.CompOutils;

import java.awt.*;

public class PanelInfo extends JPanel
{
    public PanelInfo()
    {
        CompOutils.setBackgroundWhite( this );
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 5, 4, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblNom = new JLabel("Nom");
        JTextField txtNom = new JTextField("Commande");

        JLabel lblDeclaration = new JLabel("Déclaration");
        JComboBox<String> cmbDeclaration = new JComboBox<>(new String[]{"Class", "Interface", "Enum"});

        JLabel lblVisibilite = new JLabel("Visibilité");
        JComboBox<String> cmbVisibilite = new JComboBox<>(new String[]{"Public", "Private", "Protected"});

        JCheckBox chkAbstraite = new JCheckBox("Classe abstraite");

        // Colonne des labels
        gbc.gridx = 0;
        gbc.weightx = 0;

        gbc.gridy = 0;
        this.add(lblNom, gbc);

        gbc.gridy = 1;
        this.add(lblDeclaration, gbc);

        gbc.gridy = 2;
        this.add(lblVisibilite, gbc);

        // Colonne des champs
        gbc.gridx = 1;
        gbc.weightx = 1;

        gbc.gridy = 0;
        this.add(txtNom, gbc);

        gbc.gridy = 1;
        this.add(cmbDeclaration, gbc);

        gbc.gridy = 2;
        this.add(cmbVisibilite, gbc);

        // Case à cocher
        gbc.gridy = 3;
        this.add(chkAbstraite, gbc);
    }
}