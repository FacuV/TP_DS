package Pantallas.NuevaCompetencia;

import Interface.GridBagConstraintFooter;
import Interface.JPantalla;
import Negocio.Disponibilidad;
import Negocio.LugarRealizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pantalla extends JPantalla {
    public Pantalla() {
        super("Nueva competencia","Volver");
        body.setLayout(new GridBagLayout());
        body.add(new Cabecera(),new Cabecera.Constraints());
        body.add(new Cuerpo(), new Cuerpo.Constraints());
    }
}
