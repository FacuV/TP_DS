package Pantallas.MisCompetencias;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Filters extends JPanel {
    private JComboBox Deporte = new JComboBox();
    private JComboBox Modalidad = new JComboBox();
    private JComboBox Estado = new JComboBox();
    private List Lista;
    private JButton Aceptar = new JButton("Aceptar");
    private JPanel AceptarContainer = new JPanel(new GridBagLayout());

    public Filters(List Lista) {
        super();
        setLayout(new GridLayout(4,1));
        setBorder(new EmptyBorder(20,20,20,20));
        setPreferredSize(new Dimension(200,0));
        add(Deporte);
            Deporte.addItem("");
            Deporte.addItem("Futbol");
            Deporte.addItem("League of Legends");
        add(Modalidad);
            Modalidad.addItem("");
            Modalidad.addItem("Liga");
            Modalidad.addItem("Eliminatoria Simple");
            Modalidad.addItem("Eliminatoria Doble");
        add(Estado);
            Estado.addItem("");
            Estado.addItem("CREADA");
            Estado.addItem("PLANIFICADA");
            Estado.addItem("EN_CURSO");
            Estado.addItem("FINALIZADA");
        add(AceptarContainer); AceptarContainer.add(Aceptar,null);
        Deporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lista.filtrarDeporte(Deporte.getSelectedItem().toString());
            }
        });
        Estado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lista.filtrarEstado(Estado.getSelectedItem().toString());
            }
        });
        Modalidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lista.filtrarModalidad(Modalidad.getSelectedItem().toString());
            }
        });
        this.Lista = Lista;
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            gridx = 0;
            gridy = 1;
            weighty = 1;
            fill = GridBagConstraints.BOTH;
        };
    };
}
