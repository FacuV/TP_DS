package Pantallas.MisCompetencias.VerCompetencia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelIzquierdo extends JPanel {
    public PanelIzquierdo(){
        setBackground(Color.red);
        setLayout(new GridBagLayout());
        JPanel panelImagen = new JPanel();
        JPanel panelProximosEncuentros = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
            panelImagen.setLayout(new GridBagLayout());
            panelImagen.add(new JLabel(new ImageIcon("C:\\Users\\facun\\IdeaProjects\\TP_DS\\src\\main\\java\\Iconos\\descarga.jpg")),gbc);
        add(panelImagen,gbc);
            panelProximosEncuentros.setLayout(new GridBagLayout());
            JTable table = new JTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addColumn("ParticipanteA");
                model.addColumn("ParticipanteB");
            JScrollPane scrollPane = new JScrollPane(table);
            panelProximosEncuentros.add(scrollPane,gbc);
            gbc.gridy++;
        add(panelProximosEncuentros,gbc);
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
