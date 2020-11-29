package Pantallas.ListarParticipantes;

import GestorPantallas.Gestor;
import GestorPantallas.Pantalla;
import Pantallas.Home;
import Pantallas.NuevoParticipante.PantallaNuevoParticipante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIzquierdo extends JPanel {
    public static final String NOMBRE = "NOMBRE";
    public static final String EMAIL = "EMAIL";
    JButton home = new JButton("HOME");
    JLabel ordenarPor = new JLabel("Ordenar Por");
    JComboBox<String> criterioOrden = new JComboBox<String>();
    JButton agregar = new JButton("AGREGAR PARTICIPANTE");
    JButton modificar = new JButton("MODIFICAR PARTICIPANTE");
    JButton eliminar = new JButton("ELIMINAR PARTICIPANTE");
    public PanelIzquierdo(PantallaParticipantes pantallaParticipantes){
        criterioOrden.addItem(NOMBRE);criterioOrden.addItem(EMAIL);
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                synchronized (pantallaParticipantes){
                    Gestor.push("nuevo participante");
                    try {
                        pantallaParticipantes.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    pantallaParticipantes.panelDerecho.cargarTabla(pantallaParticipantes);
                    pantallaParticipantes.revalidate();
                }
            }
        });
        setLayout(new GridBagLayout());
        GridBagConstraints constraintGeneral = new GridBagConstraints();
            constraintGeneral.weighty = 1;
            constraintGeneral.weightx = 1;
            constraintGeneral.fill = GridBagConstraints.VERTICAL;
            constraintGeneral.anchor = GridBagConstraints.CENTER;
            constraintGeneral.gridy = 0;
            constraintGeneral.gridx = 0;
        add(home,constraintGeneral);
            constraintGeneral.gridy++;
        add(new JSeparator(SwingConstants.HORIZONTAL),constraintGeneral);
            constraintGeneral.gridy++;
        add(ordenarPor,constraintGeneral);
            constraintGeneral.gridx++;
            constraintGeneral.weightx++;
        add(criterioOrden,constraintGeneral);
            constraintGeneral.gridy++;
            constraintGeneral.gridx--;
            constraintGeneral.weightx--;
        add(new JSeparator(SwingConstants.HORIZONTAL),constraintGeneral);
            constraintGeneral.gridy++;
        add(agregar,constraintGeneral);
            constraintGeneral.gridy++;
        add(new JSeparator(SwingConstants.HORIZONTAL),constraintGeneral);
            constraintGeneral.gridy++;
        add(modificar,constraintGeneral);
            constraintGeneral.gridy++;
        add(new JSeparator(SwingConstants.HORIZONTAL),constraintGeneral);
            constraintGeneral.gridy++;
        add(eliminar,constraintGeneral);
    }
    public String getCriterioOrden(){
        return (String) criterioOrden.getSelectedItem();
    }
    public static class Constraints extends GridBagConstraints{
        public Constraints () {
            fill = GridBagConstraints.BOTH;
            gridx = 1;
            insets = new Insets(20,20,20,20);
            weightx = 1;
            weighty = 1;
        }
    }
}
