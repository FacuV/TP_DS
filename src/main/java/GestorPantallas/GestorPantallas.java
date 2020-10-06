package GestorPantallas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public abstract class GestorPantallas {
    static ArrayList<Pantalla> pantallas = new ArrayList<Pantalla>();
    static ArrayList<String> history = new ArrayList<String>();

    public static void add(Pantalla pantalla) {
        pantallas.add(pantalla);
    }

    public static void init(String nombrePantalla) {
        push(nombrePantalla);
    }

    public static void push(String nombrePantalla) {
        push(nombrePantalla, true);
    }

    public static void push(String nombrePantalla, boolean replace) {
        Pantalla ultimaPantalla = new Pantalla("",new JFrame());
        Pantalla proximaPantalla = new Pantalla("",new JFrame());
        for (Pantalla pantalla : pantallas) {
            if (pantalla.nombre.equals(nombrePantalla)) proximaPantalla = pantalla;
            if (history.size() > 0 && pantalla.nombre.equals(history.get(history.size() - 1))) ultimaPantalla = pantalla;
        }
        if (replace) ultimaPantalla.componente.setVisible(false);
        proximaPantalla.componente.setVisible(true);
        history.add(nombrePantalla);
    }

    public static void pop() {
        Pantalla ultimaPantalla = new Pantalla("",new JFrame());
        for (Pantalla pantalla : pantallas) {
            if (history.size() > 0 && pantalla.nombre.equals(history.get(history.size() - 1))) ultimaPantalla = pantalla;
        }
        if (history.size() > 1) {
            ultimaPantalla.componente.setVisible(false);
            history.remove(history.size() - 1);
        }
    }
}
