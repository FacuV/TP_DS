package Pantallas.MisCompetencias.VerCompetencia.PanelCentral;

import Negocio.CompetenciaDTO;
import Negocio.Participante;
import Negocio.ParticipanteDTO;
import Servicio.GestorCompetencia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelInferior extends JPanel {
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JLabel participantes = new JLabel("Participantes");
    public PanelInferior(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx=0;gbc.gridy=0;
            gbc.weightx=1;gbc.weighty=1;
            gbc.fill=GridBagConstraints.BOTH;
            gbc.anchor=GridBagConstraints.WEST;
        add(participantes,gbc);
            gbc.gridy++;
            gbc.weighty++;gbc.weightx++;
            gbc.anchor=GridBagConstraints.CENTER;
            cargarTablaParticipantes();
        add(scrollPane,gbc);
    }
    public void cargarTablaParticipantes() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Participantes");
        CompetenciaDTO competenciaDTO = GestorCompetencia.getCompetenciaDTO();
        if (competenciaDTO.participantesDTO.isEmpty()){
            table.setModel(model);
            return;
        }
        for(ParticipanteDTO participante:competenciaDTO.participantesDTO) {
            if(!participante.nombre.equals("FANTASMA")){
                Object[] row = new Object[1];
                row[0] = participante.nombre;
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
    public static class Constraint extends GridBagConstraints {
        public Constraint(){
            super();
            gridx=0;
            gridy=1;
            weightx=1;
            weighty=1;
            fill=GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
