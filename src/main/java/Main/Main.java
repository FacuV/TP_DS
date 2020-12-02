package Main;

import Daos.CompetenciaPostgreSQLDao;
import GestorPantallas.Gestor;
import GestorPantallas.Pantalla;
import Negocio.Competencia;
import Pantallas.MisCompetencias.MisCompetencias;
import Pantallas.Home;
import Pantallas.NuevoParticipante.PantallaNuevoParticipante;
import Servicio.GestorCompetencia;

public class Main {
    public static void main(String[] args) {
        Gestor.add(new Pantalla("home", Home.class));
        Gestor.add(new Pantalla("competencias", MisCompetencias.class));
        Gestor.add(new Pantalla("nueva_competencia", Pantallas.NuevaCompetencia.Pantalla.class));
        Gestor.add(new Pantalla("menu_de_usuario",Pantallas.MenuDeUsuario.MenuDeUsuario.class));
        Gestor.add(new Pantalla("participantes",Pantallas.ListarParticipantes.PantallaParticipantes.class));
        Gestor.add(new Pantalla("nuevo participante", PantallaNuevoParticipante.class));
        //Gestor.init("menu_de_usuario");
        Competencia competencia = new CompetenciaPostgreSQLDao().getCompetencia(5);
        GestorCompetencia.setCompetencia(competencia);
        Gestor.init("participantes");
    }
}
