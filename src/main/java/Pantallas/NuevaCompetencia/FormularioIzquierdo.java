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
    JLabel nombreError = new JLabel("");
    JTextField nombre = new JTextField();
    JComboBox deporte = new JComboBox();
    JComboBox modalidad = new JComboBox();
    FormaPuntuacion formaPuntuacion = new FormaPuntuacion();
    private int index = 0;

    public FormularioIzquierdo() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel nombreLabel = new JLabel("Nombre de la competencia");
        nombreError.setForeground(Color.red);
        GridBagConstraints nombreLabelConstraints = new GridBagConstraints();
        nombreLabelConstraints.gridy = index++;
        nombreLabelConstraints.weightx = 1;
        nombreLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(nombreLabel,nombreLabelConstraints);
        nombreLabelConstraints.gridy = index++;
        add(nombreError,nombreLabelConstraints);

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
        deporte.addItem("");
        deporte.addItem("Futbol");
        deporte.addItem("Baloncesto");
        deporte.addItem("Voleibol");
        deporte.addItem("Waterpolo");
        deporte.addItem("Polo");
        deporte.addItem("League of Legends");
        deporte.addItem("Handball");
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
        modalidad.addItem("Liga");
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
                formaPuntuacion.hidePuntosGanados(modalidad.getSelectedItem() == "Liga");
            }
        });

        add(formaPuntuacion, new FormaPuntuacion.Constraints());

        JPanel empty = new JPanel();
        GridBagConstraints emptyConstraints = new GridBagConstraints();
        emptyConstraints.weighty = 1;
        emptyConstraints.gridy = 99999;
        add(empty,emptyConstraints);
    };

    public void setNombreError(String error) {
        this.nombreError.setText(error);
    };
    public void setErrorFormaPuntuacion(String error) { this.formaPuntuacion.setErrorFormaPuntuacion(error);};
    public void setErrorPuntos(String error) { this.formaPuntuacion.setErrorPuntos(error);};
    public String getNombre() {
        return this.nombre.getText();
    };
    public String getDeporte() {
        return this.deporte.getSelectedItem().toString();
    };
    public String getModalidad() { return this.modalidad.getSelectedItem().toString(); };
    public String getPuntosPorGanar() { return this.formaPuntuacion.getPuntosPorGanar(); };
    public String getCantidadSets() {
        return this.formaPuntuacion.getCantidadSets();
    };
    public String getPuntosPorPresentarse() {
        return this.formaPuntuacion.getPuntosPorPresentarse();
    };
    public String getPuntosPorAusencia() {
        return this.formaPuntuacion.getPuntosPorAusencia();
    };
    public String getPuntosPorEmpate() {
        return this.formaPuntuacion.getPuntosPorEmpate();
    };
    public boolean getHasPuntos() {
        return this.formaPuntuacion.getHasPuntos();
    };
    public boolean getHasSets() {
        return this.formaPuntuacion.getHasSets();
    };
    public boolean getHasFinalResult() {
        return this.formaPuntuacion.getHasFinalResult();
    };
    public boolean getHasTie() { return this.formaPuntuacion.getHasTie(); };
    public void setErrorSets(String error){formaPuntuacion.setErrorSets(error);}
    public void setOnDeporteChange(ActionListener action) { deporte.addActionListener(action); };

//    public void setPuntosPartGanadoEmpatadoError(String error){formaPuntuacion.setPuntosPartGanadoEmpatadoError(error);}

//    public void setPuntosPartGanadoPresentarseError(String error){formaPuntuacion.setPuntosPartGanadoPresentarseError(error);}

}
