package Pantallas.MisCompetencias.VerCompetencia.PanelCentral;

import Negocio.Participante;
import Servicio.GestorCompetencia;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCentral extends JPanel{
    PanelSuperior panelSuperior = new PanelSuperior();
    PanelInferior panelInferior = new PanelInferior();
    public PanelCentral(){
        setLayout(new GridBagLayout());
        add(panelSuperior,new PanelSuperior.Constraint());
        add(panelInferior,new PanelInferior.Constraint());

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
