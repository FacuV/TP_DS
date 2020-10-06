package Pantallas;

import Interface.JPantalla;

import javax.swing.*;
import java.awt.*;

public class Home extends JPantalla {
    public Home(String nombrePantalla){
        super(nombrePantalla,"< Cambiar de usuario");
        body.setLayout(new GridBagLayout());
        JPanel panelTitulo = new JPanel();
            panelTitulo.setLayout(new GridBagLayout());
            panelTitulo.setBackground(Color.white);
            JLabel principal = new JLabel("usuario frankillerxdxdxd");
            panelTitulo.add(principal);
            principal.setFont(new Font(Font.DIALOG,1,40));
        GridBagConstraints constraintPanelTitulo = new GridBagConstraints();
            constraintPanelTitulo.gridy = 0;
            constraintPanelTitulo.weighty = 1.5;
            constraintPanelTitulo.weightx = 1;
            constraintPanelTitulo.insets = new Insets(10,150,10,150);
            constraintPanelTitulo.anchor= GridBagConstraints.CENTER;
            constraintPanelTitulo.fill= GridBagConstraints.HORIZONTAL;
        JButton misCompetencias = new JButton("Mis competencias");
        //misCompetencias.setPreferredSize(new Dimension(300,60));
        misCompetencias.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        GridBagConstraints constraintMisCompetencias = new GridBagConstraints();
        constraintMisCompetencias.gridy = 1;
        constraintMisCompetencias.weightx = 1;
        constraintMisCompetencias.weighty = 1;
        constraintMisCompetencias.insets = new Insets(80,250,10,250);
        constraintMisCompetencias.anchor= GridBagConstraints.CENTER;
        constraintMisCompetencias.fill= GridBagConstraints.BOTH;
        JButton todasLasCompetencias = new JButton("Todas las competencias");
        //todasLasCompetencias.setPreferredSize(new Dimension(300,60));
        todasLasCompetencias.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        GridBagConstraints constraintTodasLasCompetencias = new GridBagConstraints();
        constraintTodasLasCompetencias.gridy = 2;
        constraintTodasLasCompetencias.weightx = 1;
        constraintTodasLasCompetencias.weighty = 1;
        constraintTodasLasCompetencias.insets = new Insets(10,250,10,250);
        constraintTodasLasCompetencias.anchor= GridBagConstraints.CENTER;
        constraintTodasLasCompetencias.fill= GridBagConstraints.BOTH;
        JButton lugaresCompetencia = new JButton("Lugares de Competencia");
        //lugaresCompetencia.setPreferredSize(new Dimension(300,60));
        lugaresCompetencia.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        GridBagConstraints constraintLugaresCompetencia = new GridBagConstraints();
        constraintLugaresCompetencia.gridy = 3;
        constraintLugaresCompetencia.weightx = 1;
        constraintLugaresCompetencia.weighty = 1;
        constraintLugaresCompetencia.insets = new Insets(10,250,10,250);
        constraintLugaresCompetencia.anchor= GridBagConstraints.CENTER;
        constraintLugaresCompetencia.fill= GridBagConstraints.BOTH;
        JButton modificarMisDatos = new JButton("Modificar mis datos");
        //modificarMisDatos.setPreferredSize(new Dimension(300,60));
        modificarMisDatos.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        GridBagConstraints constraintModificarMisDatos = new GridBagConstraints();
        constraintModificarMisDatos.gridy = 4;
        constraintModificarMisDatos.weightx = 1;
        constraintModificarMisDatos.weighty = 1;
        constraintModificarMisDatos.insets = new Insets(10,250, 80,250);
        constraintModificarMisDatos.anchor= GridBagConstraints.CENTER;
        constraintModificarMisDatos.fill= GridBagConstraints.BOTH;
        body.add(panelTitulo,constraintPanelTitulo);
        body.add(misCompetencias,constraintMisCompetencias);
        body.add(todasLasCompetencias,constraintTodasLasCompetencias);
        body.add(lugaresCompetencia,constraintLugaresCompetencia);
        body.add(modificarMisDatos,constraintModificarMisDatos);
    }

}
