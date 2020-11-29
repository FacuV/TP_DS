package Servicio;

import Daos.*;
import Errores.Error;
import Errores.ErrorEmailParticipanteRepetido;
import Errores.ErrorNombreParticipanteRepetido;
import Exceptions.CompetenciaVaciaException;
import Negocio.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorCompetencia {
    private static Competencia competencia;
    private static final CompetenciaDao competenciaDao = new CompetenciaPostgreSQLDao();
    private static final LugarRealizacionDao lugarRealizacionDao = new LugarRealizacionPostgreSQLDao();
    private static final UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();
    private static final DeporteDao deporteDao = new DeportePostgreSQLDao();
    private static final ParticipanteDao participanteDao = new ParticipantePostgreSQLDao();
    public static final int LIGA = 0;
    public static final int ELIMINATORIA_SIMPLE = 1;
    public static final int ELIMINATORIA_DOBLE = 2;
    public static final int PUNTAJE = 0;
    public static final int SETS = 1;
    public static final int FINAL = 2;

    public static ArrayList<String> crearComp(CompetenciaDTO competenciaDTO){
        ArrayList<String> errores = new ArrayList<>(4);

        //validaciones logicas
        errores.add(nombreCompetenciaValido(competenciaDTO));
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

    public static List<Error> crearPart(ParticipanteDTO participanteDTO){
        List<Error> errores = new ArrayList<>();
        if(participanteDao.nombreUnico(participanteDTO)) errores.add(new ErrorNombreParticipanteRepetido());
        if(participanteDao.emailUnico(participanteDTO)) errores.add(new ErrorEmailParticipanteRepetido());
        if(!errores.isEmpty()) return errores;
        Participante participante;
        if(participanteDTO.tipo)participante = new Equipo(participanteDTO.nombre,participanteDTO.email);
        else participante = new Individuo(participanteDTO.nombre,participanteDTO.email);;
        competencia.addParticipante(participante);
        competencia.setEstado(Estado.CREADA);
        competencia= competenciaDao.updateCompetencia(competencia);
        return errores;
    }
    private static String nombreCompetenciaValido(CompetenciaDTO competenciaDTO){
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
    public static List<ParticipanteDTO> getParticipantes(){
        List<ParticipanteDTO> participanteDTOList = new ArrayList<>();
        try{
            if(competencia == null) throw new CompetenciaVaciaException();
            List<Participante> participantes = competencia.getParticipantes();
            for(Participante participante: participantes){
                boolean tipo = !(participante instanceof Individuo);
                ParticipanteDTO participanteDTO = new ParticipanteDTO(participante.getNombre(),participante.getEmail(),competencia.getId_competencia(),tipo);
                participanteDTOList.add(participanteDTO);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return participanteDTOList;
    }
    public static Competencia getCompetencia() {
        return competencia;
    }

    public static void setCompetencia(Competencia competencia) {
        GestorCompetencia.competencia = competencia;
    }

}
