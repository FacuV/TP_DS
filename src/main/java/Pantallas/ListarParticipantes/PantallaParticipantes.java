package Pantallas.ListarParticipantes;

import Interface.JPantalla;
import Pantallas.NuevaCompetencia.Cabecera;
import Pantallas.NuevaCompetencia.Cuerpo;

import java.awt.*;

public class PantallaParticipantes extends JPantalla{
    public PantallaParticipantes(){
        super("Participantes","< Volver");
        body.setLayout(new GridBagLayout());
        body.add(new PanelIzquierdo(),new PanelIzquierdo.Constraints());
        body.add(new PanelDerecho(),new PanelDerecho.Constraints());

    }
}
