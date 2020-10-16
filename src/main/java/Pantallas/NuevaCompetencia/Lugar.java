package Pantallas.NuevaCompetencia;

import Negocio.Disponibilidad;

import javax.swing.*;
import java.awt.*;

public class Lugar implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Disponibilidad disponibilidad = (Disponibilidad) value;
        JPanel row = new JPanel();
        row.setLayout(new GridBagLayout());

        JLabel nombre = new JLabel(disponibilidad.getNombreLugar());
        GridBagConstraints nombreConstraints = new GridBagConstraints();
        nombreConstraints.weightx = 2;

        JLabel cantidad = new JLabel(String.valueOf(disponibilidad.getDisponibilidad()));
        GridBagConstraints cantidadConstraints = new GridBagConstraints();
        cantidadConstraints.weightx = 1;

        row.add(nombre,nombreConstraints);
        row.add(cantidad,cantidadConstraints);

        if (isSelected) {
            row.setBackground(Color.orange);
            row.setForeground(Color.white);
        } else {
            row.setBackground(Color.white);
            row.setForeground(Color.black);
        }

        return row;
    }
}
