package Pantallas;

import Interface.JPantalla;

import javax.swing.*;
import java.awt.*;

public class NuevaCompetencia extends JPantalla {
    public NuevaCompetencia () {
        super("Nueva competencias","Volver");
        body.setLayout(new GridBagLayout());
        body.add(Cabecera(),CabeceraConstraints());
        body.add(Cuerpo(),CuerpoConstraints());
    }

    private JPanel Cabecera() {
        JPanel Cabecera = new JPanel();
//        Cabecera.setBackground(Color.BLUE);
        Cabecera.setLayout(new GridBagLayout());
        Cabecera.add(BotonHome(),BotonHomeConstraints());
        Cabecera.add(Titulo(),TituloConstraints());
        return Cabecera;
    }

    private GridBagConstraints CabeceraConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20,20,20,20);
        constraints.weightx = 1;
        return constraints;
    }

    private JLabel Titulo() {
        JLabel Titulo = new JLabel("Nueva competencia");
        Titulo.setFont(new Font("Verdana", Font.PLAIN, 30));
        return Titulo;
    }

    private GridBagConstraints TituloConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        return constraints;
    }

    private JButton BotonHome () {
        JButton BotonHome = new JButton();
        BotonHome.setText("Home");
        return BotonHome;
    }

    private GridBagConstraints BotonHomeConstraints () {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,0,0,40);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        return constraints;
    }

    private JPanel Cuerpo () {
        JPanel Cuerpo = new JPanel();
        Cuerpo.setLayout(new GridBagLayout());
//        Cuerpo.setBackground(Color.orange);
        Cuerpo.add(Left(),LeftConstraints());
        Cuerpo.add(Right(),RightConstraints());
        return Cuerpo;
    }

    private GridBagConstraints CuerpoConstraints () {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }

    private JPanel Left () {
        JPanel Left = new JPanel();
        Left.setLayout(new GridBagLayout());

        JTextField nombre = new JTextField();
        GridBagConstraints nombreConstraints = new GridBagConstraints();
        nombreConstraints.gridy = 0;
        nombreConstraints.weightx = 1;
        nombreConstraints.insets = new Insets(0,20,40,20);
        nombreConstraints.fill = GridBagConstraints.HORIZONTAL;

        JComboBox deporte = new JComboBox();
        GridBagConstraints deporteConstraints = new GridBagConstraints();
        deporteConstraints.insets = new Insets(0,20,40,20);
        deporteConstraints.gridy = 1;
        deporteConstraints.weightx = 1;
        deporteConstraints.fill = GridBagConstraints.HORIZONTAL;

        JComboBox modalidad = new JComboBox();
        GridBagConstraints modalidadConstraints = new GridBagConstraints();
        modalidadConstraints.insets = new Insets(0,20,40,20);
        modalidadConstraints.gridy = 2;
        modalidadConstraints.weightx = 1;
        modalidadConstraints.fill = GridBagConstraints.HORIZONTAL;

        Left.add(nombre,nombreConstraints);
        Left.add(deporte,deporteConstraints);
        Left.add(modalidad,modalidadConstraints);

        return Left;
    }

    private GridBagConstraints LeftConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.insets = new Insets(20,60,20,60);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        return constraints;
    }

    private JPanel Right () {
        JPanel Right = new JPanel();
        return Right;
    }

    private GridBagConstraints RightConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.insets = new Insets(20,60,20,60);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        return constraints;
    }
}
