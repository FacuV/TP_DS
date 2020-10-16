package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cuerpo extends JPanel {

    public Cuerpo() {
        setLayout(new GridLayout(1,2));
        FormularioDerecho formularioDerecho = new FormularioDerecho();
        FormularioIzquierdo formularioIzquierdo = new FormularioIzquierdo();

        add(formularioIzquierdo);
        add(formularioDerecho);

        formularioDerecho.onAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = formularioIzquierdo.getNombre();
                String modalidad = formularioIzquierdo.getModalidad();
                String deporte = formularioIzquierdo.getDeporte();
                String puntosPorGanar = formularioIzquierdo.getPuntosPorGanar();
                String puntosPorPresentarse = formularioIzquierdo.getPuntosPorPresentarse();
                System.out.println(puntosPorGanar);
                System.out.println(puntosPorPresentarse);
            }
        });
    }

    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 1;
            gridy = 1;
            fill = GridBagConstraints.BOTH;
        }
    }
}
