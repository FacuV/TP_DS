package Servicio;

import Daos.CompetenciaDao;
import Daos.CompetenciaPostgreSQLDao;

import java.util.Stack;

public abstract class GestorCompetencia {
    private CompetenciaDao competenciaDao = new CompetenciaPostgreSQLDao();
    public static Stack<String> crearComp(){
        Stack<String> stackErrores = new Stack<String>();

        return stackErrores;
    }
}
