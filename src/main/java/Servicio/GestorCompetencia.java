package Servicio;

import Daos.CompetenciaDao;
import Daos.CompetenciaPostgreSQLDao;
import Negocio.CompetenciaDTO;

import java.util.ArrayList;
import java.util.Stack;

public abstract class GestorCompetencia {
    private static CompetenciaDao competenciaDao = new CompetenciaPostgreSQLDao();
    public static ArrayList<String> crearComp(CompetenciaDTO competenciaDTO){
        //En vez de enviar una pila de "errores" podria tener una lista de tamaño fijo,
        //la cual tenga indices respectivos a los campos del formulario de la interfaz.
        //De esta manera, del lado de la interfaz, solo habria que consultar cada indice,
        //viendo si almecena un error para mostrar. Pero para esto esperare que fran termine la interfaz.
        //Inclusivese podria interpretar una lista de "nulls" como un mensaje de exito.
        boolean esNombreValido = competenciaDao.validarUnicidadNombre(competenciaDTO.nombre);
        boolean esValidaCantMaxSets = validarCantMaxSets(competenciaDTO.cantidad_maxima_sets);
        boolean esValidoPuntosPartidoGanadoEmpatado = validarPuntosPartidoGanadoEmpatado(competenciaDTO.puntos_partido_ganado,competenciaDTO.puntos_empate);
        boolean esValidoPuntosPartidoGanadoPresentarse = validarPuntosPartidoGanadoPresentarse(competenciaDTO.puntos_partido_ganado,competenciaDTO.puntos_presentarse);
        ArrayList<String> listaErrores = componerMensajeError(esNombreValido,esValidaCantMaxSets,esValidoPuntosPartidoGanadoEmpatado,esValidoPuntosPartidoGanadoPresentarse);
        return listaErrores;
    }
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


    }


}
