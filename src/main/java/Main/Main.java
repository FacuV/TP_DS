package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Interface.JPantalla;
import Pantallas.Home;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame home = new Home("Menu de usuario");
        JFrame pantalla = new JPantalla("una pantalla","tu vijea");
        GestorPantallas.add(new Pantalla("home",home));
        GestorPantallas.add(new Pantalla("pantalla",pantalla));
        GestorPantallas.init("home");

    }
}
