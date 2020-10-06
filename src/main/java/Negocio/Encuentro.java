package Negocio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Encuentro {
    private int id_encuentro;
    private LocalDate fecha;
    private Integer fase;
    private Participante participanteA;
    private Participante participanteB;
    private Resultado resultado_actual;
    private ArrayList<Resultado> historial_resultados_modificados;
    private Ronda ronda;
    private Encuentro ganador_anterior1;
    private Encuentro ganador_anterior2;
    private Encuentro perdedor_anterior1;
    private Encuentro perdedor_anterior2;

    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB,Resultado resultado_actual,ArrayList<Resultado> historial_resultados_modificados, Ronda ronda, Encuentro ganador_anterior1, Encuentro ganador_anterior2, Encuentro perdedor_anterior1, Encuentro perdedor_anterior2) {
        this.fecha = fecha;
        this.fase = fase;
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.resultado_actual = resultado_actual;
        this.historial_resultados_modificados = historial_resultados_modificados;
        this.ronda = ronda;
        this.ganador_anterior1 = ganador_anterior1;
        this.ganador_anterior2 = ganador_anterior2;
        this.perdedor_anterior1 = perdedor_anterior1;
        this.perdedor_anterior2 = perdedor_anterior2;
    }
    //Constructor para competencia liga
    public Encuentro(LocalDate fecha, Participante participanteA, Participante participanteB) {
        this(fecha,null, participanteA, participanteB,null,new ArrayList<Resultado>(), null, null, null, null, null);
    }
    /*
    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB,Resultado resultado_actual,ArrayList<Resultado> historial_resultados_modificados, Ronda ronda, Encuentro ganador_anterior1, Encuentro ganador_anterior2, Encuentro perdedor_anterior1, Encuentro perdedor_anterior2) {
        this(fecha,null, participanteA, participanteB,null,new ArrayList<Resultado>(), null, null, null, null, null);

    }

     */



}
