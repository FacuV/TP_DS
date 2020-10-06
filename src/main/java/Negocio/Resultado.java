package Negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Resultado {
    private LocalDate fecha;
    private LocalTime hora;
    private Resolucion resolucion;
    private ArrayList<Set> sets;
    private Encuentro encuentro;
    private Usuario usuario;
    public Resultado(LocalDate fecha, LocalTime hora, Resolucion resolucion, ArrayList<Set> sets, Encuentro encuentro, Usuario usuario){
        this.fecha = fecha;
        this.hora = hora;
        this.resolucion = resolucion;
        this.sets = sets;
        this.encuentro = encuentro;
        this.usuario = usuario;
    }
    public Resultado(Resolucion resolucion, ArrayList<Set> sets, Encuentro encuentro,Usuario usuario){
        this(LocalDate.now(),LocalTime.now(),resolucion,sets,encuentro,usuario);
    }
}
