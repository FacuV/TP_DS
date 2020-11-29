package Pantallas.ListarParticipantes;

import Interface.JPantalla;
import Pantallas.NuevaCompetencia.Cabecera;
import Pantallas.NuevaCompetencia.Cuerpo;

import javax.swing.*;
import java.awt.*;

public class PantallaParticipantes extends JPantalla{
    PanelIzquierdo panelIzquierdo = new PanelIzquierdo(this);
    PanelDerecho panelDerecho = new PanelDerecho(this);
    public PantallaParticipantes(){
        super("Participantes");
        body.setLayout(new GridBagLayout());
        body.add(panelIzquierdo,new PanelIzquierdo.Constraints());
        body.add(panelDerecho,new PanelDerecho.Constraints());

    }
}
