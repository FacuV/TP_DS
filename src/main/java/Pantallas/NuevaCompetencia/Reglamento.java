package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reglamento extends JPanel {
    private JButton boton = new JButton("Aceptar");
    private JTextArea textArea = new JTextArea();
    private GridBagConstraints gbc = new GridBagConstraints();
    private int index = 0;

    public Reglamento () {
        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(20,20,10,20);

        gbc.gridy = index++; add(new JLabel("Reglamento (opcional)"),gbc);

        JScrollPane scroll = new JScrollPane();
        textArea.setMargin(new Insets(10,10,10,10));
        GridBagConstraints scrollConstraints = new GridBagConstraints();
        scrollConstraints.gridy = index++;
        scrollConstraints.weighty = 1;
        scrollConstraints.weightx = 1;
        scrollConstraints.fill = GridBagConstraints.BOTH;
        scrollConstraints.insets = new Insets(0,20,10,20);
        scroll.setViewportView(textArea);
        add(scroll,scrollConstraints);

        gbc.fill = 0; gbc.insets.top = 0; gbc.gridy = index++; add(boton,gbc);
    }

    public String getReglamento() {
        return this.textArea.getText();
    };

    public void onAceptar(ActionListener action) {
        this.boton.addActionListener(action);
    }
}
