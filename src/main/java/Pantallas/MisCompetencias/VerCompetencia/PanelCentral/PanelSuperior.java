package Pantallas.MisCompetencias.VerCompetencia.PanelCentral;

import Negocio.EliminatoriaDoble;
import Negocio.EliminatoriaSimple;
import Negocio.Liga;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    JLabel competencia = new JLabel(GestorCompetencia.getCompetencia().getNombre());
    JLabel deporte = new JLabel(GestorCompetencia.getCompetencia().getDeporte().toString());
    JLabel modalidad = new JLabel();
    JLabel estado = new JLabel(GestorCompetencia.getCompetencia().getEstado().toString());
    JLabel reglamento = new JLabel(GestorCompetencia.getCompetencia().getReglamento());
    public PanelSuperior(){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0);
        competencia.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        deporte.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        modalidad.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        estado.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        reglamento.setFont(new Font(Font.DIALOG,Font.ITALIC,15));
        add(competencia,constraints);
            constraints.gridy++;
        add(deporte,constraints);
            constraints.gridy++;
            if(GestorCompetencia.getCompetencia() instanceof Liga) modalidad.setText("LIGA");
            if(GestorCompetencia.getCompetencia() instanceof EliminatoriaSimple)modalidad.setText("ELIMINATORIA SIMPLE");
            if(GestorCompetencia.getCompetencia() instanceof EliminatoriaDoble)modalidad.setText("ELIMINATRIA DOBLE");
        add(modalidad,constraints);
            constraints.gridx++;
        add(estado,constraints);
            constraints.gridx--;
            constraints.gridy++;
        add(reglamento,constraints);
    }
    public static class Constraint extends GridBagConstraints{
        public Constraint(){
            super();
            gridx=0;
            gridy=0;
            weightx=1;
            weighty=1;
            fill=GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
