package Pantallas.MisCompetencias.VerCompetencia;

import GestorPantallas.Gestor;
import Negocio.CompetenciaDTO;
import Negocio.EncuentroDTO;
import Negocio.Estado;
import Pantallas.MisCompetencias.MisCompetencias;
import Servicio.GestorCompetencia;
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
        setLayout(new GridLayout(2,1));
        ImageIcon imagenCruz = new ImageIcon("src/main/java/Iconos/cruz1.png");
        JButton atras = new JButton();
        atras.setBounds(0,0,50,50);
        Icon icono = new ImageIcon(imagenCruz.getImage().getScaledInstance(atras.getWidth(),atras.getHeight(),Image.SCALE_DEFAULT)) ;
        atras.setIcon(icono);
        JPanel panelProximosEncuentros = new JPanel();
        ImagenDeporte imagenDeporte = new ImagenDeporte(GestorCompetencia.getDeporteDTO());
            atras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((MisCompetencias) Gestor.peek()).unsetCompetencia();
                }
            });
        GridBagConstraints gbc = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
        imagenDeporte.add(atras,new ImagenDeporte.ConstraintBoton());
        imagenDeporte.add(new JSeparator(),new ImagenDeporte.ConstraintSeparator1());
        imagenDeporte.add(new JSeparator(),new ImagenDeporte.ConstraintSeparator2());
        add(imagenDeporte);
            panelProximosEncuentros.setLayout(new GridBagLayout());
            cargarTablaProximosEncuentros();
            panelProximosEncuentros.add(proximosEncuentros,gbc);
            gbc.gridy++;
            gbc.weightx=5;gbc.weighty=5;
            panelProximosEncuentros.add(scrollPane,gbc);
        add(panelProximosEncuentros);
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
            weightx=10;
            weighty=1;
            fill= GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
