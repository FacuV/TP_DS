package Interface;

import Serivicio.GestorPantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel{
    public Footer(String nombreBoton){
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.WEST;
        constraint.weightx = 1;
        JButton botonFooter = new JButton(nombreBoton);
        botonFooter.setFont(new Font(Font.DIALOG,Font.PLAIN,20));
        setBackground(Color.white);
        botonFooter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(botonFooter,constraint);
    }
}
