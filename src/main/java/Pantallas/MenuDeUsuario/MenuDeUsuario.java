package Pantallas.MenuDeUsuario;

import Interface.JPantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDeUsuario extends JPantalla {
    PanelSuperior panelSuperior = new PanelSuperior();
    PanelInferior panelInferior = new PanelInferior();
    public MenuDeUsuario() {
        super("Menu de Usuario", null);
        body.setLayout(new GridBagLayout());
        body.add(panelSuperior,new PanelSuperior.Constraints());
        body.add(panelInferior,new PanelInferior.Constraints());
        //ActionListeners
        panelInferior.onIngresar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validar las entradas e ingresar al sistema
                System.out.println(panelSuperior.getTextCorreo());
            }
        });
    }
}
