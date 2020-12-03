package Pantallas.MisCompetencias.VerCompetencia;

import javax.swing.*;
import java.awt.*;

public class PanelCentral extends JPanel{
    public PanelCentral(){
        setBackground(Color.blue);
    }
    public static class Constraint extends GridBagConstraints {
        public Constraint(){
            super();
            gridx=1;
            weightx=3;
            weighty=1;
            fill= GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
