package Main;

import GestorPantallas.Gestor;
import GestorPantallas.Pantalla;
import Pantallas.MisCompetencias;
import Pantallas.Home;


public class Main {
    public static void main(String[] args) {
        Gestor.add(new Pantalla("home", Home.class));
        Gestor.add(new Pantalla("competencias", MisCompetencias.class));
        Gestor.add(new Pantalla("nueva_competencia", Pantallas.NuevaCompetencia.Pantalla.class));
        Gestor.init("home");
    }
}
