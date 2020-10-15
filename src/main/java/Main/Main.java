package Main;

import GestorPantallas.Gestor;
import GestorPantallas.Pantalla;

public class Main {
    public static void main(String[] args) {
//        Gestor.add(new Pantalla("home", Pantallas.Home.class));
//        Gestor.add(new Pantalla("competencias", Pantallas.MisCompetencias.class));
        Gestor.add(new Pantalla("nueva_competencia", Pantallas.NuevaCompetencia.Pantalla.class));
        Gestor.init("nueva_competencia");
    }
}
