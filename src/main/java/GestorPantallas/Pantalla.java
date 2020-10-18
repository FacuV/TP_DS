package GestorPantallas;

import java.util.ArrayList;

public class Pantalla {
    String nombre;
    Class clase;

    public Pantalla (String nombre, Class clase) {
        this.nombre = nombre;
        this.clase = clase;
    }

    public static Pantalla find (String nombre, ArrayList<Pantalla> pantallas) {
        for (Pantalla pantalla : pantallas) {
            if (pantalla.nombre.equals(nombre)) return pantalla;
        }
        return pantallas.get(0);
    }
}
