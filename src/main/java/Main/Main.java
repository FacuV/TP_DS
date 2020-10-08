package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Pantallas.MisCompetencias;
import Pantallas.Home;
import Pantallas.NuevaCompetencia;

public class Main {
    public static void main(String[] args) {
        GestorPantallas.add(new Pantalla("home", Home.class));
        GestorPantallas.add(new Pantalla("competencias", MisCompetencias.class));
        GestorPantallas.add(new Pantalla("nueva_competencia", NuevaCompetencia.class));
        GestorPantallas.init("home");
    }
}
