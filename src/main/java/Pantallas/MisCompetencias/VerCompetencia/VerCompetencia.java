package Pantallas.MisCompetencias.VerCompetencia;

import javax.swing.*;
import java.awt.*;

public class VerCompetencia extends JPanel{
    public VerCompetencia(){
        setLayout(new GridBagLayout());
        add(new PanelIzquierdo(),new PanelIzquierdo.Constraint());
        add(new PanelCentral(),new PanelCentral.Constraint());
        add(new PanelDerecho(),new PanelDerecho.Constraint());
    }
    public static class Constraint extends GridBagConstraints {
        public Constraint(){
            super();
            weightx=1;weighty=1;
            fill= GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
