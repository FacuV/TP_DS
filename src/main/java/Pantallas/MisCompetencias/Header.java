package Pantallas.MisCompetencias;
import GestorPantallas.Gestor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Header extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JButton BotonHome = new JButton("Home");
    private JTextField buscador = new JTextField();
    private List Lista;

    public Header (List Lista) {
        super(); gbc.fill = GridBagConstraints.BOTH;
        setBorder(new EmptyBorder(20,20,20,20));
        setLayout(new GridBagLayout());
        add(BotonHome); BotonHome.setPreferredSize(new Dimension(120,40));
        BotonHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestor.popToTop();
                Gestor.push("home");
            }
        });
        gbc.gridx = 1; gbc.insets = new Insets(0,20,0,0); add(new JLabel("Buscador:"),gbc);
        gbc.weightx = 1; gbc.gridx = 2; gbc.insets = new Insets(0,0,0,0); add(buscador,gbc);
        this.buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lista.filtrarBusqueda(buscador.getText().toString());
            }
        });
        this.Lista = Lista;
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            gridy = 0;
            gridx = 0;
            weightx = 1;
            gridwidth = 2;
            fill = GridBagConstraints.BOTH;
        };
    };
};
