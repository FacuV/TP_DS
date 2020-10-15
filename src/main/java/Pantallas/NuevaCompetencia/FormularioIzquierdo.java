package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;

public class FormularioIzquierdo extends JPanel {

    public FormularioIzquierdo() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel nombreLabel = new JLabel("Nombre de la competencia");
        GridBagConstraints nombreLabelConstraints = new GridBagConstraints();
        nombreLabelConstraints.gridy = 0;
        nombreLabelConstraints.weightx = 1;
        nombreLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(nombreLabel,nombreLabelConstraints);

        JTextField nombre = new JTextField();
        GridBagConstraints nombreConstraints = new GridBagConstraints();
        nombreConstraints.weightx = 1;
        nombreConstraints.gridy = 1;
        nombreConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(nombre,nombreConstraints);

        JLabel deporteLabel = new JLabel("Deporte asociado");
        GridBagConstraints deporteLabelConstraints = new GridBagConstraints();
        deporteLabelConstraints.gridy = 2;
        deporteLabelConstraints.weightx = 1;
        deporteLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(deporteLabel,deporteLabelConstraints);

        JComboBox deporte = new JComboBox();
        deporte.addItem("Football");
        deporte.addItem("Basketball");
        deporte.addItem("Softball");
        deporte.addItem("Baseball");
        GridBagConstraints deporteConstraints = new GridBagConstraints();
        deporteConstraints.weightx = 1;
        deporteConstraints.gridy = 3;
        deporteConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(deporte,deporteConstraints);

        JLabel modalidadLabel = new JLabel("Modalidad de competencia");
        GridBagConstraints modalidadLabelConstraints = new GridBagConstraints();
        modalidadLabelConstraints.gridy = 4;
        modalidadLabelConstraints.weightx = 1;
        modalidadLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(modalidadLabel,modalidadLabelConstraints);

        JComboBox modalidad = new JComboBox();
        modalidad.addItem("Eliminación simple");
        modalidad.addItem("Sistema de liga");
        modalidad.addItem("Segunda vuelta");
        GridBagConstraints modalidadConstraints = new GridBagConstraints();
        modalidadConstraints.weightx = 1;
        modalidadConstraints.gridy = 5;
        modalidadConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(modalidad,modalidadConstraints);

        JLabel subtitle = new JLabel("Forma de puntuación");
        GridBagConstraints subtitleConstraints = new GridBagConstraints();
        subtitleConstraints.gridy = 6;
        add(subtitle,subtitleConstraints);

        JPanel puntos = new JPanel();
        puntos.setLayout(new GridLayout(1,3));
        GridBagConstraints puntosConstraints = new GridBagConstraints();
        puntosConstraints.gridy = 7;
        puntosConstraints.weightx = 1;
        puntosConstraints.fill = GridBagConstraints.HORIZONTAL;
        JCheckBox hasPuntos = new JCheckBox();
        JLabel puntosLabel = new JLabel("Puntos victoria por ausencia",SwingConstants.LEFT);
        JTextField puntosCantidad = new JTextField();
        puntos.add(hasPuntos);
        puntos.add(puntosLabel);
        puntos.add(puntosCantidad);
        add(puntos,puntosConstraints);

        JPanel sets = new JPanel();
        sets.setLayout(new GridLayout(1,3));
        GridBagConstraints setsConstraints = new GridBagConstraints();
        setsConstraints.gridy = 8;
        setsConstraints.weightx = 1;
        setsConstraints.fill = GridBagConstraints.HORIZONTAL;
        JCheckBox hasSets = new JCheckBox();
        JLabel setsLabel = new JLabel("Cantidad máxima de sets.",SwingConstants.LEFT);
        JTextField setsCantidad = new JTextField();
        sets.add(hasSets);
        sets.add(setsLabel);
        sets.add(setsCantidad);
        add(sets,setsConstraints);

        JPanel finalResult = new JPanel();
        finalResult.setLayout(new GridLayout(1,3));
        GridBagConstraints finalResultConstraints = new GridBagConstraints();
        finalResultConstraints.gridy = 9;
        finalResultConstraints.weightx = 1;
        finalResultConstraints.fill = GridBagConstraints.HORIZONTAL;
        JCheckBox hasFinalResult = new JCheckBox();
        JLabel finalResultLabel = new JLabel("Resultado final.",SwingConstants.LEFT);
        finalResultLabel.setOpaque(true);
        finalResultLabel.setBackground(Color.red);
        finalResult.add(hasFinalResult);
        finalResult.add(finalResultLabel);
        finalResult.add(new JLabel(""));
        add(finalResult,finalResultConstraints);

        JPanel empty = new JPanel();
        GridBagConstraints emptyConstraints = new GridBagConstraints();
        emptyConstraints.weighty = 1;
        emptyConstraints.gridy = 99999;
        add(empty,emptyConstraints);

    }
}
