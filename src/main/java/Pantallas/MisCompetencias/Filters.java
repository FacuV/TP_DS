package Pantallas.MisCompetencias;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Filters extends JPanel {
    private JButton Aceptar = new JButton("Aceptar");
    private JComboBox Deporte = new JComboBox();
    private JComboBox Modalidad = new JComboBox();
    private JComboBox Estado = new JComboBox();
    private GridBagConstraints gbc = new GridBagConstraints();
    private JPanel View = new JPanel();
    private List Lista;

    public Filters(List Lista) {
        super();
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        setBorder(new EmptyBorder(20,20,20,20));
        View.setLayout(new GridBagLayout());
        View.setBorder(BorderFactory.createTitledBorder("Filtros"));
        View.add(new JLabel("Deporte"),gbc); gbc.gridy++;
        View.add(Deporte,gbc); gbc.gridy++;
            Deporte.setBorder(new EmptyBorder(0,0,40,0));
            Deporte.addItem("");
            Deporte.addItem("Futbol");
            Deporte.addItem("League of Legends");
        View.add(new JLabel("Modalidad"),gbc); gbc.gridy++;
        View.add(Modalidad,gbc); gbc.gridy++;
            Modalidad.setBorder(new EmptyBorder(0,0,40,0));
            Modalidad.addItem("");
            Modalidad.addItem("Liga");
            Modalidad.addItem("Eliminatoria Simple");
            Modalidad.addItem("Eliminatoria Doble");
        View.add(new JLabel("Estado"),gbc); gbc.gridy++;
        View.add(Estado,gbc); gbc.gridy++;
            Estado.setBorder(new EmptyBorder(0,0,40,0));
            Estado.addItem("");
            Estado.addItem("CREADA");
            Estado.addItem("PLANIFICADA");
            Estado.addItem("EN_CURSO");
            Estado.addItem("FINALIZADA");
        View.add(Aceptar,gbc);
        add(View);
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lista.filtrarModalidad(Modalidad.getSelectedItem().toString());
                Lista.filtrarEstado(Estado.getSelectedItem().toString());
                Lista.filtrarDeporte(Deporte.getSelectedItem().toString());
            }
        });
        this.Lista = Lista;
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            gridx = 0;
            gridy = 1;
            anchor = GridBagConstraints.NORTH;
        };
    };
}
