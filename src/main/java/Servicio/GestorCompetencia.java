package Servicio;

import Daos.*;
import Errores.Error;
import Errores.ErrorEmailParticipanteRepetido;
import Errores.ErrorNombreParticipanteRepetido;
import Exceptions.CompetenciaVaciaException;
import GestorPantallas.Gestor;
import Helpers.CrearEncuentrosHelper;
import Negocio.*;
import javax.swing.*;
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

    public static CompetenciaDTO getCompetenciaDTO(){
        CompetenciaDTO competenciaDTO = new CompetenciaDTO();
            competenciaDTO.id_competencia= competencia.getId_competencia();
            competenciaDTO.nombre = competencia.getNombre();
            competenciaDTO.reglamento = competencia.getReglamento();
            competenciaDTO.deporte = competencia.getDeporte().getNombre();
            competenciaDTO.estado = competencia.getEstado().toString();
            if(competencia instanceof Liga)competenciaDTO.modalidad_competencia =GestorCompetencia.LIGA;
            if(competencia instanceof EliminatoriaSimple)competenciaDTO.modalidad_competencia =GestorCompetencia.ELIMINATORIA_SIMPLE;
            if(competencia instanceof EliminatoriaDoble)competenciaDTO.modalidad_competencia =GestorCompetencia.ELIMINATORIA_DOBLE;
            competenciaDTO.participantesDTO=getParticipantesDTO();
            competenciaDTO.disponibilidadesDTO=getDisponibilidadesDTO();

        return competenciaDTO;
    }
    public static List<DisponibilidadDTO> getDisponibilidadesDTO(){
        List<DisponibilidadDTO> disponibilidadesDTO = new ArrayList<>();
        for(Disponibilidad disponibilidad:competencia.getDisponibilidades()){
            disponibilidadesDTO.add(new DisponibilidadDTO(disponibilidad.getDisponibilidad(),disponibilidad.getLugarRealizacion().getId_lugar_realizacion()));
        }
        return disponibilidadesDTO;
    }
    public static List<ParticipanteDTO> getParticipantesDTO(){
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
    public static boolean hayDisponibilidad(){
        boolean rtn = false;
        int disponibilidadTotal = 0;
        int cantParticipantes = competencia.getParticipantes().size();
        for(Disponibilidad disponibilidad:competencia.getDisponibilidades()){
            disponibilidadTotal+=disponibilidad.getDisponibilidad();
        }
        if(disponibilidadTotal == 0)return rtn;
        if(disponibilidadTotal > cantParticipantes/2)rtn = true;
        return rtn;
    }
    public static List<Error> crearPart(ParticipanteDTO participanteDTO){
        List<Error> errores = new ArrayList<>();
        if(participanteDao.nombreUnico(participanteDTO)) errores.add(new ErrorNombreParticipanteRepetido());
        if(participanteDao.emailUnico(participanteDTO)) errores.add(new ErrorEmailParticipanteRepetido());
        if(!errores.isEmpty()) return errores;
        Participante participante;
        if(participanteDTO.tipo)participante = new Equipo(participanteDTO.nombre,participanteDTO.email);
        else participante = new Individuo(participanteDTO.nombre,participanteDTO.email);
        competencia.addParticipante(participante);
        competencia.setEstado(Estado.CREADA);
        competencia = competenciaDao.updateCompetencia(competencia);
        return errores;
    }
    public static void generarFixture(){
        if(competencia.getEstado() == Estado.FINALIZADA || competencia.getEstado() == Estado.EN_CURSO){
            JOptionPane.showMessageDialog(Gestor.peek(), "<html><center>No se puede volver a generar fixture <p> la competencia esta en curso o ya finalizo<html>","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(competencia.getParticipantes().size() <=1){
            JOptionPane.showMessageDialog(Gestor.peek(), "<html><center>No se puede volver a generar fixture <p> no hay participantes suficientes<html>","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(competencia.getParticipantes().size() % 2 != 0){
            competencia.addParticipante(new Individuo("FANTASMA","FANTASMA@gmail.com"));
            competencia = competenciaDao.updateCompetencia(competencia);
        }
        Fixture fixture = new Fixture();
        fixture.setEncuentros(CrearEncuentrosHelper.crearEncuentros(competencia.getParticipantes(),competencia.getDisponibilidades()));
        competencia.setFixture(fixture);
        competencia.setEstado(Estado.PLANIFICADA);
        competencia = competenciaDao.updateCompetencia(competencia);

        JOptionPane.showMessageDialog(Gestor.peek(), "<html><center>Fixture creado con exito<html>");
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
    public static Competencia getCompetencia() {
        return competencia;
    }
    public static void setCompetencia(Competencia competencia) {
        if(competencia == null)GestorCompetencia.competencia=null;
        else GestorCompetencia.competencia= competenciaDao.getCompetencia(competencia.getId_competencia());
    }
}
