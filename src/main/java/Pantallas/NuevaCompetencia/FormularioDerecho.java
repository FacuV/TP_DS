package Pantallas.NuevaCompetencia;

import Negocio.DisponibilidadDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioDerecho extends JPanel {
    Reglamento reglamento = new Reglamento();
    Lugares lugares = new Lugares();

    public FormularioDerecho () {
        setLayout(new GridLayout(2,1));
        add(lugares);
        add(reglamento);
    }

    public ArrayList<DisponibilidadDTO> getDisponibilidades() {
        return lugares.getDisponibilidades();
    }

    public String getReglamento () {
        return this.reglamento.getReglamento();
    }

    public void onAceptar (ActionListener action) {
        this.reglamento.onAceptar(action);
    }
}
