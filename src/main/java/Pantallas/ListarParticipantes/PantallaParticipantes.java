package Pantallas.ListarParticipantes;

import GestorPantallas.Gestor;
import Interface.JPantalla;
import Pantallas.NuevaCompetencia.Cabecera;
import Pantallas.NuevaCompetencia.Cuerpo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaParticipantes extends JPantalla{
    PanelIzquierdo panelIzquierdo = new PanelIzquierdo(this);
    PanelDerecho panelDerecho = new PanelDerecho(this);
    public PantallaParticipantes(){
        super("Participantes");
        body.setLayout(new GridBagLayout());
        body.add(panelIzquierdo,new PanelIzquierdo.Constraints());
        body.add(panelDerecho,new PanelDerecho.Constraints());
        footer.botonFooter.removeActionListener(footer.botonFooter.getActionListeners()[0]);
        footer.botonFooter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestor.pop();
                JFrame pantallaMisCompetencias = Gestor.peek();
                synchronized (pantallaMisCompetencias){
                    pantallaMisCompetencias.notify();
                }
            }
        });

    }
}
