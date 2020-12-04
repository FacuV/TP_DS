package Pantallas.MisCompetencias.VerCompetencia;

import GestorPantallas.Gestor;
import Negocio.Encuentro;
import Negocio.Estado;
import Servicio.GestorCompetencia;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelIzquierdo extends JPanel {
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JLabel proximosEncuentros = new JLabel("Proximos encuentros");
    public PanelIzquierdo(){
        setLayout(new GridBagLayout());
        JPanel panelProximosEncuentros = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
            ImageIcon imageIcon = new ImageIcon("./src/main/java/Iconos/basquet.jpg");
            JLabel imagen = new JLabel(imageIcon);
            imagen.setSize(100,100);
        add(imagen,gbc);
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
        if(GestorCompetencia.getCompetencia().getEstado()== Estado.CREADA){
            table.setModel(model);
            return;
        }
        List<Encuentro> encuentrosParaMostrar = new ArrayList<>();
        int tamFase = GestorCompetencia.getCompetencia().getParticipantes().size()/2;
        for(Encuentro encuentro:GestorCompetencia.getCompetencia().getFixture().getEncuentros()){
            if(encuentrosParaMostrar.size()==tamFase)break;
            if(encuentro.getFecha()==null)encuentrosParaMostrar.add(encuentro);
        }
        for(Encuentro encuentro:encuentrosParaMostrar){
            Object [] row = new Object[3];
            row[0] = encuentro.getFase();
            row[1] = encuentro.getParticipanteA();
            row[2] = encuentro.getParticipanteB();
            model.addRow(row);
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
