package Pantallas.MisCompetencias.VerCompetencia.PanelCentral;

import Negocio.CompetenciaDTO;
import Negocio.EliminatoriaDoble;
import Negocio.EliminatoriaSimple;
import Negocio.Liga;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    CompetenciaDTO competenciaDTO = GestorCompetencia.getCompetenciaDTO();
    String competenciaFormatedString = String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 400,competenciaDTO.nombre);
    JLabel competencia = new JLabel(competenciaFormatedString);
    JLabel deporte = new JLabel(competenciaDTO.deporte);
    JLabel modalidad = new JLabel((competenciaDTO.modalidad_competencia==0)?"Liga":(competenciaDTO.modalidad_competencia==1)?"Eliminatoria Simple":"Eliminatoria Doble");
    JLabel estado = new JLabel(competenciaDTO.estado);
    String reglamentoMessage = String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 400, competenciaDTO.reglamento);
    JLabel reglamento = new JLabel(reglamentoMessage);
    public PanelSuperior() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0);
        competencia.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        deporte.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        modalidad.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        estado.setFont(new Font(Font.DIALOG,Font.BOLD,15));
        reglamento.setFont(new Font(Font.DIALOG,Font.ITALIC,10));
        add(competencia,constraints);
            constraints.gridy++;
        add(deporte,constraints);
            constraints.gridy++;
        add(modalidad,constraints);
            constraints.gridx++;
        add(estado,constraints);
            constraints.gridx--;
            constraints.gridy++;
        add(reglamento,constraints);
    }
    public void actualizarEstado(){
        estado.setText(GestorCompetencia.getEstado().toString());
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
    };
};
