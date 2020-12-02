package Pantallas.MisCompetencias;
import GestorPantallas.Gestor;
import Interface.JPantalla;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MisCompetencias extends JPantalla {
    public MisCompetencias() {
        super("Mis competencias","Volver");
        body.setLayout(new GridBagLayout());
        body.add(new Header(), new Header.Constraints());
        body.add(new Filters(), new Filters.Constraints());
        body.add(new List(), new List.Constraints());
//        body.add(Cabecera(),CabeceraConstraints());
//        body.add(Cuerpo(),CuerpoConstraints());
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

    private JPanel Filtros () {
        JPanel Filtros = new JPanel();
        Filtros.setLayout(new GridBagLayout());
        Filtros.setBackground(Color.white);

        JComboBox deporte = new JComboBox();
        deporte.setToolTipText("Filtrar por deporte");
        GridBagConstraints deporteConstraint = new GridBagConstraints();
        deporteConstraint.gridy = 0;
        deporteConstraint.fill = GridBagConstraints.HORIZONTAL;
        deporteConstraint.weightx = 1;
        deporteConstraint.weighty = 1;

        JComboBox modalidad = new JComboBox();
        modalidad.setToolTipText("Filtrar por deporte");
        GridBagConstraints modalidadConstraint = new GridBagConstraints();
        modalidadConstraint.fill = GridBagConstraints.HORIZONTAL;
        modalidadConstraint.gridy = 1;
        modalidadConstraint.weightx = 1;
        modalidadConstraint.weighty = 1;

        JComboBox estado = new JComboBox();
        estado.setToolTipText("Filtrar por deporte");
        GridBagConstraints estadoConstraint = new GridBagConstraints();
        estadoConstraint.fill = GridBagConstraints.HORIZONTAL;
        estadoConstraint.gridy = 2;
        estadoConstraint.weightx = 1;
        estadoConstraint.weighty = 1;

        JButton boton = new JButton();
        GridBagConstraints botonConstraint = new GridBagConstraints();
        botonConstraint.fill = GridBagConstraints.HORIZONTAL;
        botonConstraint.gridy = 3;
        botonConstraint.weightx = 1;
        boton.setText("Aceptar");

        Filtros.add(deporte,deporteConstraint);
        Filtros.add(modalidad,modalidadConstraint);
        Filtros.add(estado,estadoConstraint);
        Filtros.add(boton,botonConstraint);

        return Filtros;
    }

    private GridBagConstraints FiltrosConstraints () {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(20,20,20,20);
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }

    private JScrollPane Lista () {
        JScrollPane Scroller = new JScrollPane();
        JPanel Lista = new JPanel();
        Lista.setLayout(new GridBagLayout());
        ArrayList<String> competencias = new ArrayList<String>();
        competencias.add("Competencia 1");
        competencias.add("Competencia 2");
        competencias.add("Competencia 2");
        competencias.add("Competencia 2");
        competencias.add("Competencia 2");

        JButton nuevaTarjeta = new JButton();
        nuevaTarjeta.setBackground(Color.white);
        nuevaTarjeta.setPreferredSize(new Dimension(0,100));
        GridBagConstraints nuevaTarjetaConstraints = new GridBagConstraints();
        nuevaTarjetaConstraints.gridy = 0;
        nuevaTarjetaConstraints.insets = new Insets(5,20,5,20);
        nuevaTarjetaConstraints.weightx = 1;
        nuevaTarjetaConstraints.fill = GridBagConstraints.BOTH;
        nuevaTarjetaConstraints.anchor = GridBagConstraints.SOUTH;
        JLabel texto = new JLabel("Crear competencia");
//        texto.setBackground(Color.orange);
        GridBagConstraints textoConstraint = new GridBagConstraints();
        textoConstraint.anchor = GridBagConstraints.CENTER;
        textoConstraint.weightx = 1;
        textoConstraint.weighty = 1;
        nuevaTarjeta.add(texto,textoConstraint);
        Lista.add(nuevaTarjeta,nuevaTarjetaConstraints);

        nuevaTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestor.push("nueva_competencia");
            }
        });

        for (int index = 1; index < competencias.size(); index++) {
            JPanel tarjeta = new JPanel();
            tarjeta.setBackground(Color.LIGHT_GRAY);
            tarjeta.setPreferredSize(new Dimension(0,100));
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridy = index;
            constraints.weightx = 1;
            constraints.insets = new Insets(20,20,5,20);
            constraints.fill = GridBagConstraints.BOTH;
            final int ind = index;
            tarjeta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.format("Tarjeta clickeada: %d \n",ind);
                }
            });
            Lista.add(tarjeta,constraints);
        }

        Scroller.setViewportView(Lista);
        return Scroller;
    }

    private GridBagConstraints ListaConstraints () {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 4;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        return constraints;
    }
}