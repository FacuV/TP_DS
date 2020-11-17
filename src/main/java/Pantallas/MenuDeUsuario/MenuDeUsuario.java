package Pantallas.MenuDeUsuario;

import Interface.JPantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDeUsuario extends JPantalla {
    PanelSuperior panelSuperior = new PanelSuperior();
    JButton ingresar = new JButton("Ingresar");
    public MenuDeUsuario() {
        super("Menu de Usuario", null);
        body.setLayout(new GridBagLayout());
        body.add(panelSuperior, new PanelSuperior.Constraints());
            ingresar.setMinimumSize(new Dimension(100,50));
            ingresar.setPreferredSize(new Dimension(300,50));
            ingresar.setMaximumSize(new Dimension(400,50));
            ingresar.setFont(new Font(Font.DIALOG,Font.PLAIN,25));
            GridBagConstraints gridBagConstraintBotonIngresar = new GridBagConstraints();
                gridBagConstraintBotonIngresar.gridy = 2;
                gridBagConstraintBotonIngresar.weighty = 1;
                gridBagConstraintBotonIngresar.weightx = 1;
                gridBagConstraintBotonIngresar.anchor = GridBagConstraints.NORTH;
        body.add(ingresar, gridBagConstraintBotonIngresar);
    }
}
