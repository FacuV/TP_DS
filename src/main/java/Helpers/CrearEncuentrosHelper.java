package Helpers;

import Negocio.Encuentro;
import Negocio.Participante;
import com.amazonaws.services.dynamodbv2.xspec.S;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrearEncuentrosHelper {
    public static List<Encuentro> crearEncuentros(List<Participante> participantes){
        List<Encuentro> encuentros = new ArrayList<>();
            List<Participante> lista1 = participantes.subList(0,(participantes.size()/2));
            List<Participante> lista2 = participantes.subList((participantes.size()/2),participantes.size());
            //fases
            for(int i=0;i<participantes.size()-1;i++){
                //por cada fase
                for(int j = 0;j<participantes.size()/2;j++){
                    encuentros.add(new Encuentro(i+1,lista1.get(j),
                            lista2.get(j)));
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
    private static List<Encuentro> calculoTodosLosPares(List<Participante> participantes){
        List<Encuentro> encuentrosPosibles = new ArrayList<>();
        for(int i=0;i<participantes.size();i++){
            for(int j=i;j<participantes.size();j++){
                if(!participantes.get(i).equals(participantes.get(j))){
                    Encuentro encuentro = new Encuentro();
                    encuentro.setParticipanteA(participantes.get(i));
                    encuentro.setParticipanteB(participantes.get(j));
                    encuentrosPosibles.add(encuentro);
                }
            }
        }
        return encuentrosPosibles;
    }
    private static boolean noRepetido(Encuentro par,List<Encuentro> fase){
        for(Encuentro encuentro:fase){
            if(encuentro.getParticipanteA().equals(par.getParticipanteA()) || encuentro.getParticipanteA().equals(par.getParticipanteB())||
               encuentro.getParticipanteB().equals(par.getParticipanteA()) || encuentro.getParticipanteB().equals(par.getParticipanteB())){
                return false;
            }
        }
        return true;
    }
    /*
        int cantFases = participantes.size()-1;
        List<Encuentro> encuentrosPosibles = calculoTodosLosPares(participantes);
        System.out.println(encuentrosPosibles);
        int tamFase = participantes.size()/2;
        for(int i=0;i<cantFases;i++){
            int cantEncuentros=0;
            List<Encuentro> fase = new ArrayList<>();
            for(int j=0;j<encuentrosPosibles.size();j++){
                if((fase.isEmpty() || noRepetido(encuentrosPosibles.get(j),fase) && cantEncuentros<tamFase)){
                    encuentrosPosibles.get(j).setFase(i+1);
                    fase.add(encuentrosPosibles.get(j));
                    cantEncuentros++;
                    encuentrosPosibles.remove(j);
                }else{if(cantEncuentros==tamFase)break;}

            }
            if(fase.size()<tamFase){
                for (Encuentro encuentro:fase){
                    encuentro.setFase(null);
                    encuentrosPosibles.add(encuentro);
                }
                i--;
            }else{encuentros.add(fase);}
        }
        List<Encuentro> rtn = encuentros.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        return rtn;
        */
}
