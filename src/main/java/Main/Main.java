package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Pantallas.MisCompetencias;
import Pantallas.Home;

public class Main {
    public static void main(String[] args) {
        GestorPantallas.add(new Pantalla("home", Home.class));
        GestorPantallas.add(new Pantalla("competencias", MisCompetencias.class));
        GestorPantallas.init("competencias");
    }
}
