package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reglamento extends JPanel {
    JButton boton = new JButton("Aceptar");

    public Reglamento () {
        setLayout(new GridBagLayout());

        JScrollPane scroll = new JScrollPane();
        JTextArea textArea = new JTextArea();
        textArea.setMargin(new Insets(10,10,10,10));
        GridBagConstraints scrollConstraints = new GridBagConstraints();
        scrollConstraints.weighty = 1;
        scrollConstraints.weightx = 1;
        scrollConstraints.fill = GridBagConstraints.BOTH;
        scrollConstraints.insets = new Insets(20,20,20,20);
        scroll.setViewportView(textArea);
        add(scroll,scrollConstraints);

        GridBagConstraints botonConstraints = new GridBagConstraints();
        botonConstraints.gridy = 1;
        add(boton, botonConstraints);
    }

    public void onAceptar(ActionListener action) {
        this.boton.addActionListener(action);
    }
}
