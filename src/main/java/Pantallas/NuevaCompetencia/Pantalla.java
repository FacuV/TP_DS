package Pantallas.NuevaCompetencia;

import Interface.JPantalla;
import java.awt.*;

public class Pantalla extends JPantalla {
    public Pantalla() {
        super("Nueva competencia","Volver");
        body.setLayout(new GridBagLayout());
        body.add(new Cabecera(),new Cabecera.Constraints());
        body.add(new Cuerpo(), new Cuerpo.Constraints());
    }
}
