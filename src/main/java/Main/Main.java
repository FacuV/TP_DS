package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Interface.JPantalla;
import Negocio.Competencia;
import Pantallas.Competencias;
import Pantallas.Home;
import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
//        JFrame home = new Home("Menu de usuario");
//        home.setVisible(true);
//        JFrame pantalla = new JPantalla("una pantalla","tu vijea");
//        GestorPantallas.add(new Pantalla("home",home));
//        GestorPantallas.add(Home.class);
//        GestorPantallas.add(new Pantalla("pantalla",pantalla));
        GestorPantallas.add(new Pantalla("home",Home.class));
        GestorPantallas.add(new Pantalla("competencias", Competencias.class));
        GestorPantallas.init("home");
    }
}
