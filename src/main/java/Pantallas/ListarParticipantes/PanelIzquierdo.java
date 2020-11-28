package Pantallas.ListarParticipantes;

import javax.swing.*;
import java.awt.*;

public class PanelIzquierdo extends JPanel {
    JButton home = new JButton("HOME");
    JLabel ordenarPor = new JLabel("Ordenar Por");
    JComboBox nombre = new JComboBox();
    JButton agregar = new JButton("AGREGAR PARTICIPANTE");
    JButton modificar = new JButton("MODIFICAR PARTICIPANTE");
    JButton eliminar = new JButton("ELIMINAR PARTICIPANTE");
    public PanelIzquierdo(){
        setLayout(new GridBagLayout());
        GridBagConstraints constraintGeneral = new GridBagConstraints();
            constraintGeneral.weighty = 1;
            constraintGeneral.weightx = 1;
            constraintGeneral.fill = GridBagConstraints.VERTICAL;
            constraintGeneral.anchor = GridBagConstraints.CENTER;
            constraintGeneral.insets = new Insets(40,5,40,5);
        constraintGeneral.gridy = 0;
            constraintGeneral.gridx = 0;
        add(home,constraintGeneral);
            constraintGeneral.gridy++;
        add(ordenarPor,constraintGeneral);
            constraintGeneral.gridx++;
            constraintGeneral.weightx++;
        add(nombre,constraintGeneral);
            constraintGeneral.gridy++;
            constraintGeneral.gridx--;
            constraintGeneral.weightx--;
        add(agregar,constraintGeneral);
            constraintGeneral.gridy++;
        add(modificar,constraintGeneral);
            constraintGeneral.gridy++;
        add(eliminar,constraintGeneral);
    }
    public static class Constraints extends GridBagConstraints{
        public Constraints () {
            fill = GridBagConstraints.BOTH;
            gridx = 1;
            //insets = new Insets(20,20,20,20);
            weightx = 1;
            weighty = 1;
        }
    }
}
