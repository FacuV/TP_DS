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
        List<List<Encuentro>> encuentros = new ArrayList<>();
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
                }//else{if(cantEncuentros==tamFase)break;}

            }
            if(fase.size()<tamFase){
                for (Encuentro encuentro:fase){
                    encuentro.setFase(null);
                    encuentrosPosibles.add(encuentro);
                }
                i--;
                //Collections.sort(encuentrosPosibles);
            }else{encuentros.add(fase);}
        }
        List<Encuentro> rtn = encuentros.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        return rtn;
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
}
