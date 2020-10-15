package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;

public class Cuerpo extends JPanel {
    public Cuerpo() {
        setLayout(new GridLayout(1,2));
        add(new FormularioIzquierdo());
        add(new FormularioDerecho());
    }

    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 1;
            gridy = 1;
            fill = GridBagConstraints.BOTH;
        }
    }
}
