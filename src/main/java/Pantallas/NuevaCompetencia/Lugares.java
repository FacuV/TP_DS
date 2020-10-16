package Pantallas.NuevaCompetencia;

import Negocio.Disponibilidad;
import Negocio.DisponibilidadDTO;
import Negocio.LugarRealizacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class Lugares extends JPanel {
    ArrayList<DisponibilidadDTO> disponibilidades = new ArrayList<>();
    JTable tabla = new JTable();
    Lugares self = this;
    DefaultTableModel model = (DefaultTableModel) tabla.getModel();

    public Lugares () {
        setLayout(new GridBagLayout());

        model.addColumn("Nombre");
        model.addColumn("Cantidad");

        JScrollPane lugaresScroll = new JScrollPane(tabla);
        GridBagConstraints lugaresScrollConstraints = new GridBagConstraints();
        lugaresScrollConstraints.gridy = 0;
        lugaresScrollConstraints.gridwidth = 2;
        lugaresScrollConstraints.weighty = 1;
        lugaresScrollConstraints.weightx = 1;
        lugaresScrollConstraints.fill = GridBagConstraints.BOTH;
        lugaresScrollConstraints.insets = new Insets(20,20,20,20);
        add(lugaresScroll,lugaresScrollConstraints);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new addDisponibilidad());
        GridBagConstraints botonAgregarConstraints = new GridBagConstraints();
        botonAgregarConstraints.gridy = 1;
        botonAgregarConstraints.weightx = 1;
        add(botonAgregar, botonAgregarConstraints);

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeRow(tabla.getSelectedRow());
            }
        });
        GridBagConstraints botonEliminarConstraints = new GridBagConstraints();
        botonEliminarConstraints.gridy = 1;
        botonEliminarConstraints.weightx = 1;
        add(botonEliminar, botonEliminarConstraints);
    };

    public ArrayList<DisponibilidadDTO> getDisponibilidades() {
        return this.disponibilidades;
    };

    public class addDisponibilidad implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NuevoLugar prompt = new NuevoLugar(SwingUtilities.getWindowAncestor(self),"Agregar Lugar",model,disponibilidades);
            prompt.setVisible(true);
        }
    }
}
