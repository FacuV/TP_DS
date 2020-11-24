package Servicio;

import Daos.*;
import Negocio.*;

import java.util.ArrayList;

public abstract class GestorCompetencia {
    private static CompetenciaDao competenciaDao = new CompetenciaPostgreSQLDao();
    private static LugarRealizacionDao lugarRealizacionDao = new LugarRealizacionPostgreSQLDao();
    private static UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();
    private static DeporteDao deporteDao = new DeportePostgreSQLDao();
    public static final int LIGA = 0;
    public static final int ELIMINATORIA_SIMPLE = 1;
    public static final int ELIMINATORIA_DOBLE = 2;
    public static final int PUNTAJE = 0;
    public static final int SETS = 1;
    public static final int FINAL = 2;

    public static ArrayList<String> crearComp(CompetenciaDTO competenciaDTO){
        ArrayList<String> errores = new ArrayList<>(4);

        //validaciones logicas
        errores.add(nombreValido(competenciaDTO));
        errores.add(setsValidos(competenciaDTO));
        errores.add(puntuacionEmpateValido(competenciaDTO));
        errores.add(puntuacionPresentarseValido(competenciaDTO));
        //retorno de errores
        for(String error:errores){if(error != null)return errores;}
        //Puntaje
        Puntuacion puntuacion = null;
        switch (competenciaDTO.forma_Puntuación){
            case 0: puntuacion = new PuntuacionPuntaje(competenciaDTO.tantos_equipo_ganador_por_ausencia); break;
            case 1: puntuacion = new PuntuacionSet(competenciaDTO.cantidad_máxima_sets); break;
            case 2: puntuacion = new PuntuacionResultadoFinal(); break;
        }
        //Deporte
        Deporte deporte = deporteDao.getDeporte(competenciaDTO.id_deporte);
        //Usuario
        Usuario usuario = usuarioDao.getUsuario(competenciaDTO.id_usuario);
        //Competencia
        Competencia competencia = null;
        switch (competenciaDTO.modalidad_competencia){
            case 0: competencia = new Liga(competenciaDTO.nombre,competenciaDTO.reglamento,puntuacion,usuario,deporte,competenciaDTO.puntos_partido_ganado,competenciaDTO.puntos_presentarse,competenciaDTO.permite_empate,competenciaDTO.puntos_partido_empatado); break;
            case 1: competencia = new EliminatoriaSimple(competenciaDTO.nombre,competenciaDTO.reglamento,puntuacion,usuario,deporte); break;
            case 2: competencia = new EliminatoriaDoble(competenciaDTO.nombre,competenciaDTO.reglamento,puntuacion,usuario,deporte); break;
        }
        //Disponibilidades
        ArrayList<Disponibilidad> disponibilidades = new ArrayList<>();
        for(DisponibilidadDTO disponibilidadDTO:competenciaDTO.disponibilidades){
            Disponibilidad disponibilidad = new Disponibilidad(disponibilidadDTO.disponibilidad,competencia,lugarRealizacionDao.getLugarRealizacion(disponibilidadDTO.id_lugar_realizacion));
            disponibilidades.add(disponibilidad);
        }
        competencia.setDisponibilidades(disponibilidades);
        competenciaDao.createCompetencia(competencia);
        return errores;
    }

    private static String nombreValido(CompetenciaDTO competenciaDTO){
        System.out.println("hola");
        if(competenciaDao.nombreUnico(competenciaDTO.nombre)){return "El nombre ingresado ya existe en otra competencia";}
        else{return null;}
    }
    private static String setsValidos(CompetenciaDTO competenciaDTO){
        if(competenciaDTO.forma_Puntuación == SETS &&(competenciaDTO.cantidad_máxima_sets % 2 == 0) || competenciaDTO.cantidad_máxima_sets > 10){return "Cantidad sets par o mayor a 10";}
        else{return null;}
    }
    private static String puntuacionEmpateValido(CompetenciaDTO competenciaDTO){
        if(competenciaDTO.modalidad_competencia == LIGA && competenciaDTO.puntos_partido_ganado < competenciaDTO.puntos_partido_empatado){return "Puntos por partido ganado menor que puntos partido empatado";}
        else{return null;}
    }
    private static String puntuacionPresentarseValido(CompetenciaDTO competenciaDTO){
        if(competenciaDTO.modalidad_competencia == LIGA && competenciaDTO.puntos_presentarse >= competenciaDTO.puntos_partido_ganado){return "Puntos por presentarse mayor o igual a puntos por partido ganado";}
        else{return null;}
    }
}
