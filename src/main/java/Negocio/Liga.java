package Negocio;

import java.util.ArrayList;

public class Liga extends Competencia{
    private int puntos_partido_ganado;
    private int puntos_presentarse;
    private boolean empate_permitido;
    private int puntos_empate;

    public Liga(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, ArrayList<Disponibilidad> disponibilidades, ArrayList<Participante> participantes,int puntos_partido_ganado,int puntos_presentarse,boolean empate_permitido,int puntos_empate) {
        super(nombre, reglamento, puntuacion, estado, usuario, deporte, disponibilidades, participantes);
        this.puntos_partido_ganado = puntos_partido_ganado;
        this.puntos_presentarse = puntos_presentarse;
        this.empate_permitido = empate_permitido;
        this.puntos_empate = puntos_empate;
    }
    public Liga(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte,int puntos_partido_ganado,int puntos_presentarse,boolean empate_permitido,int puntos_empate) {
        this(nombre, reglamento, puntuacion, estado, usuario, deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>(),puntos_partido_ganado,puntos_presentarse,empate_permitido,puntos_empate);
    }
}
