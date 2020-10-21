package Servicio;

import Daos.*;
import Negocio.*;

import java.util.ArrayList;

public abstract class GestorCompetencia {
    private static CompetenciaDao competenciaDao = new CompetenciaPostgreSQLDao();
    private static LugarRealizacionDao lugarRealizacionDao = new LugarRealizacionPostgreSQLDao();
    private static UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();
    private static DeporteDao deporteDao = new DeportePostgreSQLDao();

    public static ArrayList<String> crearComp(CompetenciaDTO competenciaDTO){
        ArrayList<String> errores = new ArrayList<>(4);
        //validaciones logicas
        if(competenciaDao.nombreUnico(competenciaDTO.nombre)){errores.add("El nombre ingresado ya existe en otra competencia");
        }else{errores.add(null);}
        if(competenciaDTO.forma_Puntuación == 1 &&(competenciaDTO.cantidad_máxima_sets % 2 == 0) || competenciaDTO.cantidad_máxima_sets > 10){errores.add("Cantidad sets par o mayor a 10");
        }else{errores.add(null);}
        if(competenciaDTO.modalidad_competencia == 0 && competenciaDTO.puntos_partido_ganado < competenciaDTO.puntos_partido_empatado){errores.add("Puntos por partido ganado menor que puntos partido empatado");
        }else{errores.add(null);}
        if(competenciaDTO.modalidad_competencia == 0 && competenciaDTO.puntos_presentarse >= competenciaDTO.puntos_partido_ganado){errores.add("Puntos por presentarse >= a puntos por partido ganado");
        }else{errores.add(null);}
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
        // Puede que podamos guardar todo en la BD guardando una sola entidad, por ejemplo competencia o usuario, vere si funciona con competencia.
        competenciaDao.createCompetencia(competencia);
        return errores;
    }
        /*
        boolean esNombreValido = competenciaDao.validarUnicidadNombre(competenciaDTO.nombre);
        boolean esValidaCantMaxSets = validarCantMaxSets(competenciaDTO.cantidad_maxima_sets);
        boolean esValidoPuntosPartidoGanadoEmpatado = validarPuntosPartidoGanadoEmpatado(competenciaDTO.puntos_partido_ganado,competenciaDTO.puntos_empate);
        boolean esValidoPuntosPartidoGanadoPresentarse = validarPuntosPartidoGanadoPresentarse(competenciaDTO.puntos_partido_ganado,competenciaDTO.puntos_presentarse);
        ArrayList<String> listaErrores = componerMensajeError(esNombreValido,esValidaCantMaxSets,esValidoPuntosPartidoGanadoEmpatado,esValidoPuntosPartidoGanadoPresentarse);
        return listaErrores;
        private static boolean validarCantMaxSets(int cantidad_máxima_sets){}
        private static boolean validarPuntosPartidoGanadoEmpatado(int puntos_partido_ganado,int puntos_partido_empatado){}
        private static boolean validarPuntosPartidoGanadoPresentarse(int puntos_partido_ganado,int puntos_presentarse){}
        private static ArrayList<String> componerMensajeError(boolean esNombreValido,boolean esValidaCantMaxSets,boolean esValidoPuntosPartidoGanadoEmpatado,boolean esValidoPuntosPartidoGanadoPresentarse){
        ArrayList<String> listaErrores = new ArrayList<>();
        if(esNombreValido){
            listaErrores.add(null);
        }else{listaErrores.add("el nombre de la competencia ingresado ya existe");}
        if(esValidaCantMaxSets){
            listaErrores.add(null);
        }else{listaErrores.add("La cantidad máxima de sets no es un\n" +
                "número impar o es un número mayor a 10");}
        if(esValidoPuntosPartidoGanadoEmpatado){
            listaErrores.add(null);
        }else{}
        if(esValidoPuntosPartidoGanadoPresentarse){
            listaErrores.add(null);
        }else{}
        */


}
