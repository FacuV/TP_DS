package Servicio;

import Daos.*;
import Negocio.CompetenciaDTO;

import java.util.ArrayList;

public abstract class GestorCompetencia {
    private static CompetenciaDao competenciaDao = new CompetenciaPostgreSQLDao();
    private static LugarRealizacionDao lugarRealizacionDao = new LugarRealizacionPostgreSQLDao();
    private static UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();
    private static DeporteDao deporteDao = new DeportePostgreSQLDao();

    public static ArrayList<String> crearComp(CompetenciaDTO competenciaDTO){
        ArrayList<String> errores = new ArrayList<>(4);
        //validaciones logicas
        if(competenciaDao.nombreUnico(competenciaDTO.nombre)){errores.add("El nombre ingresado ya existe en otra competencia");}else{errores.add(null);}
        if((competenciaDTO.cantidad_máxima_sets % 2 == 0) || competenciaDTO.cantidad_máxima_sets > 10){errores.add(" La cantidad máxima de sets no es un número impar o es un número mayor a 10");}else{errores.add(null);}
        if(competenciaDTO.puntos_partido_ganado < competenciaDTO.puntos_partido_empatado){errores.add("La cantidad de puntos por partido ganado es menor que la cantidad de puntos por partido empatado");}else{errores.add(null);}
        if(competenciaDTO.puntos_presentarse >= competenciaDTO.puntos_partido_ganado){errores.add("Los puntos por presentarse son mayor o igual a la cantidad de puntos por partido ganado");}else{errores.add(null);}
        return errores;
    }
}
