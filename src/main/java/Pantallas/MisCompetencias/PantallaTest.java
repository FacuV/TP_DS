package Pantallas.MisCompetencias;

import Interface.JPantalla;
import Pantallas.MisCompetencias.VerCompetencia.VerCompetencia;

import javax.swing.*;
import java.awt.*;

public class PantallaTest extends JPantalla {
    public PantallaTest() {
        super("Pantalla CU20 test");
        body.setLayout(new GridBagLayout());
        JPanel verCompetencia = new VerCompetencia(this);
        body.add(verCompetencia,new VerCompetencia.Constraint());
    }

}
