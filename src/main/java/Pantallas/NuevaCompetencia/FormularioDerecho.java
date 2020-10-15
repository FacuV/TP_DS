package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;

public class FormularioDerecho extends JPanel {
    public FormularioDerecho () {
        setLayout(new GridLayout(2,1));
        add(new Lugares());
        add(new Reglamento());
    }
}
