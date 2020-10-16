package Pantallas.NuevaCompetencia;

import Daos.DeporteDao;
import Daos.DeportePostgreSQLDao;
import Negocio.Deporte;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.List;

public class FormularioIzquierdo extends JPanel {
    DeporteDao deporteDao = new DeportePostgreSQLDao();
    private int index = 0;

    public FormularioIzquierdo() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel nombreLabel = new JLabel("Nombre de la competencia");
        JLabel nombreError = new JLabel("Tiene que haber un nombre");
        nombreError.setForeground(Color.red);
        GridBagConstraints nombreLabelConstraints = new GridBagConstraints();
        nombreLabelConstraints.gridy = index++;
        nombreLabelConstraints.weightx = 1;
        nombreLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(nombreLabel,nombreLabelConstraints);
        nombreLabelConstraints.gridy = index++;
        add(nombreError,nombreLabelConstraints);

        JTextField nombre = new JTextField();
        GridBagConstraints nombreConstraints = new GridBagConstraints();
        nombreConstraints.weightx = 1;
        nombreConstraints.gridy = index++;
        nombreConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(nombre,nombreConstraints);

        JLabel deporteLabel = new JLabel("Deporte asociado");
        GridBagConstraints deporteLabelConstraints = new GridBagConstraints();
        deporteLabelConstraints.gridy = index++;
        deporteLabelConstraints.weightx = 1;
        deporteLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(deporteLabel,deporteLabelConstraints);

        JComboBox deporte = new JComboBox();
        List<Deporte> deportes = deporteDao.getDeportes();
        for (Deporte _deporte : deportes) deporte.addItem(_deporte.getNombre());
        GridBagConstraints deporteConstraints = new GridBagConstraints();
        deporteConstraints.weightx = 1;
        deporteConstraints.gridy = index++;
        deporteConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(deporte,deporteConstraints);

        JLabel modalidadLabel = new JLabel("Modalidad de competencia");
        GridBagConstraints modalidadLabelConstraints = new GridBagConstraints();
        modalidadLabelConstraints.gridy = index++;
        modalidadLabelConstraints.weightx = 1;
        modalidadLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(modalidadLabel,modalidadLabelConstraints);

        FormaPuntuacion formaPuntuacion = new FormaPuntuacion();
        JComboBox modalidad = new JComboBox();
        modalidad.addItem("Sistema de liga");
        modalidad.addItem("Eliminatoria simple");
        modalidad.addItem("Eliminatoria doble");
        GridBagConstraints modalidadConstraints = new GridBagConstraints();
        modalidadConstraints.weightx = 1;
        modalidadConstraints.gridy = index++;
        modalidadConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(modalidad,modalidadConstraints);

        modalidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formaPuntuacion.hidePuntosGanados(modalidad.getSelectedItem() == "Sistema de liga");
            }
        });

        add(formaPuntuacion, new FormaPuntuacion.Constraints());

        JPanel empty = new JPanel();
        GridBagConstraints emptyConstraints = new GridBagConstraints();
        emptyConstraints.weighty = 1;
        emptyConstraints.gridy = 99999;
        add(empty,emptyConstraints);

    }
}
