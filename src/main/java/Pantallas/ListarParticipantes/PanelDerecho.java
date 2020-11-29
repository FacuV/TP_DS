package Pantallas.ListarParticipantes;

import Negocio.ParticipanteDTO;
import Servicio.GestorCompetencia;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class PanelDerecho extends JPanel{
    public JTable tabla = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabla);
    public DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    public PanelDerecho(PantallaParticipantes pantallaParticipantes){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx=1;gbc.weighty=1;
            gbc.fill = GridBagConstraints.BOTH;
        model.addColumn("Nombre Participante/Equipo");
        model.addColumn("Correo Electronico");
        add(scrollPane,gbc);
        cargarTabla(pantallaParticipantes);
    }
    public void cargarTabla(PantallaParticipantes pantallaParticipantes){
        model = new DefaultTableModel();
        model.addColumn("Nombre Participante/Equipo");
        model.addColumn("Correo Electronico");
        List<ParticipanteDTO> participanteDTOList = GestorCompetencia.getParticipantes();
        if(pantallaParticipantes.panelIzquierdo.getCriterioOrden().equals(PanelIzquierdo.NOMBRE)) Collections.sort(participanteDTOList, (x, y) -> x.nombre.compareToIgnoreCase(y.nombre));
        else Collections.sort(participanteDTOList, (x, y) -> x.email.compareToIgnoreCase(y.email));
        for(ParticipanteDTO participanteDTO: participanteDTOList){
            Object [] row = new Object[2];
            row[0] = participanteDTO.nombre;
            row[1] = participanteDTO.email;
            model.addRow(row);
        }
        tabla.setModel(model);
    }
    public void actualizar(){
        remove(scrollPane);
        scrollPane = new JScrollPane(tabla);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx=1;gbc.weighty=1;gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane,gbc);
    }
    public static class Constraints extends GridBagConstraints {
        public Constraints () {
            fill = GridBagConstraints.BOTH;
            gridx = 2;
            weightx = 4;
            weighty = 1;
        }
    }
}
