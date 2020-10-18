package Pantallas.MenuDeUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInferior extends JPanel {
    JButton ingresar = new JButton("Ingresar");
    JButton registrarse = new JButton("Registrarse");
    JButton listarCompetencias = new JButton("Listar Competencias");
    public PanelInferior(){
        super();
        //setBackground(Color.red);
        ingresar.setPreferredSize(new Dimension(100,50));
        setLayout(new GridLayout(3,1,0,35));
        //ActionListeners
        add(ingresar);add(registrarse);add(listarCompetencias);
    }

    public void onIngresar(ActionListener actionListener){
        ingresar.addActionListener(actionListener);
    }

    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 1;
            gridy = 2;
            fill = GridBagConstraints.HORIZONTAL;
            anchor = GridBagConstraints.NORTH;
            insets = new Insets(20,250,20,250);
        }
    }
}

