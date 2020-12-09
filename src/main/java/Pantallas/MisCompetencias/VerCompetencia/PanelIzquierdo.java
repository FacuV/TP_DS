package Pantallas.MisCompetencias.VerCompetencia;

import GestorPantallas.Gestor;
import Negocio.CompetenciaDTO;
import Negocio.Encuentro;
import Negocio.EncuentroDTO;
import Negocio.Estado;
import Pantallas.MisCompetencias.MisCompetencias;
import Servicio.GestorCompetencia;
import com.amazonaws.services.dynamodbv2.xspec.S;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelIzquierdo extends JPanel {
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JLabel proximosEncuentros = new JLabel("Proximos encuentros");
    public PanelIzquierdo(){
        setLayout(new GridBagLayout());
        JButton atras = new JButton("X");
        JPanel panelProximosEncuentros = new JPanel();
            atras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((MisCompetencias) Gestor.peek()).unsetCompetencia();
                }
            });
        GridBagConstraints gbc = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
            //ImageIcon imageIcon = new ImageIcon("./src/main/java/Iconos/basquet.jpg");
            //JLabel imagen = new JLabel(imageIcon);
            //imagen.setSize(100,100);
        add(atras,gbc);
            gbc.anchor=GridBagConstraints.WEST;
            gbc.weighty=1;gbc.weightx=1;
            gbc.gridy++;
        add(proximosEncuentros,gbc);
            gbc.anchor=GridBagConstraints.CENTER;
            gbc.weighty=2;gbc.weightx=2;
            panelProximosEncuentros.setLayout(new GridBagLayout());
            cargarTablaProximosEncuentros();
            panelProximosEncuentros.add(scrollPane,gbc);
            gbc.gridy++;
        add(panelProximosEncuentros,gbc);
    }
    public void cargarTablaProximosEncuentros(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Fase");
        model.addColumn("ParticipanteA");
        model.addColumn("ParticipanteB");
        CompetenciaDTO competenciaDTO = GestorCompetencia.getCompetenciaDTO();
        if(competenciaDTO.estado.equals(Estado.CREADA.toString())){
            table.setModel(model);
            return;
        }
        List<EncuentroDTO> encuentrosParaMostrar = new ArrayList<>();
        int tamFase = competenciaDTO.participantesDTO.size()/2;
        System.out.println(competenciaDTO.fixtureDTO.encuentrosDTO);
        for(EncuentroDTO encuentro:competenciaDTO.fixtureDTO.encuentrosDTO){
            if(encuentrosParaMostrar.size()==tamFase)break;
            encuentrosParaMostrar.add(encuentro);
        }
        for(EncuentroDTO encuentro:encuentrosParaMostrar){
            if(!(encuentro.participanteA.nombre.equals("FANTASMA") || encuentro.participanteB.nombre.equals("FANTASMA"))){
                Object[] row = new Object[3];
                row[0] = encuentro.fase;
                row[1] = encuentro.participanteA.nombre;
                row[2] = encuentro.participanteB.nombre;
                model.addRow(row);
            }
        }
        table.setModel(model);
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
