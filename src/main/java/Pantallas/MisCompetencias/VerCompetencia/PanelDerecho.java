package Pantallas.MisCompetencias.VerCompetencia;

import GestorPantallas.Gestor;
import Pantallas.ListarParticipantes.PantallaParticipantes;
import Pantallas.NuevoParticipante.PantallaNuevoParticipante;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDerecho extends JPanel {
    JButton generarFixture = new JButton("<html><center>GENERAR <p> FIXTURE<html>");
    JButton mostrarFixture = new JButton("<html><center>MOSTRAR <p> FIXTURE<html>");
    JButton posiciones = new JButton("<html><center>POSICIONES<html>");
    JButton participantes = new JButton("<html><center>PARTICIPANTES<html>");
    JButton eliminarCompetencia = new JButton("<html><center>ELIMINAR <p> COMPETENCIA<html>");
    public PanelDerecho(VerCompetencia panelVerCompetencia){
        setLayout(new GridBagLayout());
        generarFixture.setFont(new Font(Font.DIALOG,Font.PLAIN,12));
        mostrarFixture.setFont(new Font(Font.DIALOG,Font.PLAIN,12));
        posiciones.setFont(new Font(Font.DIALOG,Font.PLAIN,12));
        participantes.setFont(new Font(Font.DIALOG,Font.PLAIN,12));
        eliminarCompetencia.setFont(new Font(Font.DIALOG,Font.PLAIN,12));
        generarFixture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorCompetencia.generarFixture();
                panelVerCompetencia.panelIzquierdo.cargarTablaProximosEncuentros();
            }
        });
        participantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread1 = new Thread() {
                    @Override
                    public void run() {
                        Gestor.push("participantes");
                    }
                };
                thread1.start();
                Thread thread2 = new Thread() {
                    @Override
                    public void run() {
                        synchronized (panelVerCompetencia.miFrame) {
                            try {
                                if (Gestor.peek().isVisible()) panelVerCompetencia.miFrame.wait();
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            panelVerCompetencia.panelIzquierdo.cargarTablaProximosEncuentros();
                        }
                    }
                };
                thread2.start();
            }
        });

        GridBagConstraints constraintGeneral = new GridBagConstraints();
            constraintGeneral.weightx=1;constraintGeneral.weighty=1;
            constraintGeneral.fill=GridBagConstraints.BOTH;
            constraintGeneral.anchor=GridBagConstraints.NORTH;
            constraintGeneral.gridy=0;constraintGeneral.gridx=0;
            constraintGeneral.insets = new Insets(10,15,10,15);
        add(generarFixture,constraintGeneral);
            constraintGeneral.gridy++;
        add(mostrarFixture,constraintGeneral);
            constraintGeneral.gridy++;
        add(posiciones,constraintGeneral);
            constraintGeneral.gridy++;
        add(participantes,constraintGeneral);
            constraintGeneral.gridy++;
            constraintGeneral.weighty=5;
        add(new JSeparator(),constraintGeneral);
            constraintGeneral.gridy++;
            constraintGeneral.weighty=1;
            constraintGeneral.anchor=GridBagConstraints.SOUTH;
        add(eliminarCompetencia,constraintGeneral);

    }
    public static class Constraint extends GridBagConstraints {
        public Constraint(){
            super();
            gridx=2;
            weightx=1;
            weighty=1;
            fill= GridBagConstraints.BOTH;
            anchor=GridBagConstraints.CENTER;
        }
    }
}
