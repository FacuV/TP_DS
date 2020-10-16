package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormularioDerecho extends JPanel {
    Reglamento reglamento = new Reglamento();

    public FormularioDerecho () {
        setLayout(new GridLayout(2,1));
        add(new Lugares());
        add(reglamento);
    }

    public void onAceptar (ActionListener action) {
        this.reglamento.onAceptar(action);
    }
}
