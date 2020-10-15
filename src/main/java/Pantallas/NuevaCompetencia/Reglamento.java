package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;

public class Reglamento extends JPanel {
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

        JButton boton = new JButton("Aceptar");
        GridBagConstraints botonConstraints = new GridBagConstraints();
        botonConstraints.gridy = 1;
        add(boton, botonConstraints);
    }
}
