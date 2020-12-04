package Pantallas.MisCompetencias.VerCompetencia;

import Pantallas.MisCompetencias.VerCompetencia.PanelCentral.PanelCentral;

import javax.swing.*;
import java.awt.*;

public class VerCompetencia extends JPanel{
    PanelIzquierdo panelIzquierdo = new PanelIzquierdo();
    PanelCentral panelCentral = new PanelCentral();
    PanelDerecho panelDerecho = new PanelDerecho(this);
    JFrame miFrame;
    public VerCompetencia(JFrame frame){
        setLayout(new GridBagLayout());
        miFrame = frame;
        add(panelIzquierdo,new PanelIzquierdo.Constraint());
        add(panelCentral,new PanelCentral.Constraint());
        add(panelDerecho,new PanelDerecho.Constraint());

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
