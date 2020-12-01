package Pantallas.ListarParticipantes;

import GestorPantallas.Gestor;
import Servicio.GestorCompetencia;
import com.amazonaws.services.dynamodbv2.xspec.S;

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
        criterioOrden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantallaParticipantes.panelDerecho.cargarTabla(pantallaParticipantes);
            }
        });
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(GestorCompetencia.hayDisponibilidad()) {
                    Thread thread1 = new Thread() {
                        @Override
                        public void run() {
                            Gestor.push("nuevo participante");
                        }
                    };
                    thread1.start();
                    Thread thread2 = new Thread() {
                        @Override
                        public void run() {
                            synchronized (pantallaParticipantes) {
                                try {
                                    if (Gestor.peek().isVisible()) pantallaParticipantes.wait();
                                } catch (InterruptedException interruptedException) {
                                    interruptedException.printStackTrace();
                                }
                                pantallaParticipantes.panelDerecho.cargarTabla(pantallaParticipantes);
                            }
                        }
                    };
                    thread2.start();
                }else {
                    JOptionPane.showMessageDialog(pantallaParticipantes, "No hay disponibilidad suficiente para agregar otro participante","Error",JOptionPane.ERROR_MESSAGE);
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
