package Helpers;

import Negocio.Disponibilidad;
import Negocio.Encuentro;
import Negocio.LugarRealizacion;
import Negocio.Participante;
import java.util.ArrayList;
import java.util.List;

public class CrearEncuentrosHelper {
    public static List<Encuentro> crearEncuentros(List<Participante> participantes, List<Disponibilidad> disponibilidades){
        List<Encuentro> encuentros = new ArrayList<>();
            List<Participante> lista1 = participantes.subList(0,(participantes.size()/2));
            List<Participante> lista2 = participantes.subList((participantes.size()/2),participantes.size());
            List<LugarRealizacion> lugaresXdisponibilidad = lugaresXdisponibilidad(disponibilidades);
            //Si solo hay 2 participantes <caso trivial>
            if(participantes.size() == 2){
                encuentros.add(new Encuentro(1,lista1.get(0),lista2.get(0),lugaresXdisponibilidad.get(0)));
                return encuentros;
            }
            //fases
            for(int i=0;i<participantes.size()-1;i++){
                //por cada fase
                for(int j = 0;j<participantes.size()/2;j++){
                    encuentros.add(new Encuentro(i+1,lista1.get(j),lista2.get(j),lugaresXdisponibilidad.get(j)));
                }
                List<List<Participante>> listasRotadas = rotar(lista1,lista2);
                lista1=listasRotadas.get(0);
                lista2=listasRotadas.get(1);
            }
        return encuentros;
    }
    private static List<List<Participante>> rotar(List<Participante> lista1,List<Participante> lista2){
        List<List<Participante>> listasRotadas = new ArrayList<>();
        List<Participante> lista1Rotada = new ArrayList<>();
        List<Participante> lista2Rotada = new ArrayList<>();
        Participante cabezaLista1 = lista1.get(1);
        Participante colaLista2 = lista2.get(lista2.size()-1);
        lista1Rotada.add(lista1.get(0));
        lista2Rotada.add(cabezaLista1);
        for(int i=1;i<lista1.size()-1;i++){
            lista1Rotada.add(lista1.get(i+1));
        }
        lista1Rotada.add(colaLista2);
        for(int i=1;i<lista2.size();i++){
            lista2Rotada.add(lista2.get(i-1));
        }
        listasRotadas.add(lista1Rotada);listasRotadas.add(lista2Rotada);
        return listasRotadas;
    }
    private static List<LugarRealizacion> lugaresXdisponibilidad(List<Disponibilidad> disponibilidades){
        List<LugarRealizacion> lugaresRealizacion = new ArrayList<>();
        for(Disponibilidad disponibilidad:disponibilidades){
            for(int i=0;i<disponibilidad.getDisponibilidad();i++){
                lugaresRealizacion.add(disponibilidad.getLugarRealizacion());
            }
        }
        return lugaresRealizacion;
    }
}
