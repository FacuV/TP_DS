package Negocio;

import java.util.ArrayList;

public abstract class Competencia {
    protected int id_competencia;
    protected String nombre;
    protected String reglamento;
    protected boolean baja_logica;
    protected Puntuacion puntuacion;
    protected Estado estado;
    protected Usuario usuario;
    protected Deporte deporte;
    protected ArrayList<Disponibilidad> disponibilidades;
    protected ArrayList<Participante> participantes;
    protected Fixture fixture;

    protected Competencia(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, ArrayList<Disponibilidad> disponibilidades, ArrayList<Participante> participantes) {
        this.nombre = nombre;
        this.reglamento = reglamento;
        this.puntuacion = puntuacion;
        this.estado = estado;
        this.usuario = usuario;
        this.deporte = deporte;
        this.disponibilidades = disponibilidades;
        this.participantes = participantes;
    }
    protected Competencia(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte){
        this(nombre,reglamento,puntuacion,estado,usuario,deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>());
    }
}
