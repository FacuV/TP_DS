package Pantallas.MisCompetencias.VerCompetencia;

import javax.swing.*;
import java.awt.*;

public class PanelIzquierdo extends JPanel {
    public PanelIzquierdo(){
        setBackground(Color.red);
    }
    public static class Constraint extends GridBagConstraints {
        public Constraint(){
            super();
            gridx=0;
            weightx=2;
            weighty=1;
            fill= GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
