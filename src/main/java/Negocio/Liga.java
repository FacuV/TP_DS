package Negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
@Entity
@Table(name = "liga")
@PrimaryKeyJoinColumn(name="id_competencia")
public class Liga extends Competencia{
    @Column(name = "puntos_partido_ganado")
    private int puntos_partido_ganado;
    @Column(name = "puntos_presentarse")
    private int puntos_presentarse;
    @Column(name = "empate_permitido")
    private boolean empate_permitido;
    @Column(name = "puntos_empate")
    private int puntos_empate;
    public Liga(){
        super();
    }
    public Liga(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, ArrayList<Disponibilidad> disponibilidades, ArrayList<Participante> participantes,Fixture fixture,int puntos_partido_ganado,int puntos_presentarse,boolean empate_permitido,int puntos_empate) {
        super(nombre, reglamento, puntuacion, estado, usuario, deporte, disponibilidades, participantes,fixture);
        this.puntos_partido_ganado = puntos_partido_ganado;
        this.puntos_presentarse = puntos_presentarse;
        this.empate_permitido = empate_permitido;
        this.puntos_empate = puntos_empate;
    }
    public Liga(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte,int puntos_partido_ganado,int puntos_presentarse,boolean empate_permitido,int puntos_empate) {
        this(nombre, reglamento, puntuacion, estado, usuario, deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>(),null,puntos_partido_ganado,puntos_presentarse,empate_permitido,puntos_empate);
    }
    public Liga(String nombre, String reglamento, Puntuacion puntuacion,Usuario usuario, Deporte deporte,int puntos_partido_ganado,int puntos_presentarse,boolean empate_permitido,int puntos_empate) {
        this(nombre, reglamento, puntuacion,Estado.CREADA, usuario, deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>(),null,puntos_partido_ganado,puntos_presentarse,empate_permitido,puntos_empate);
    }

    public int getPuntos_partido_ganado() {
        return puntos_partido_ganado;
    }

    public void setPuntos_partido_ganado(int puntos_partido_ganado) {
        this.puntos_partido_ganado = puntos_partido_ganado;
    }

    public int getPuntos_presentarse() {
        return puntos_presentarse;
    }

    public void setPuntos_presentarse(int puntos_presentarse) {
        this.puntos_presentarse = puntos_presentarse;
    }

    public boolean isEmpate_permitido() {
        return empate_permitido;
    }

    public void setEmpate_permitido(boolean empate_permitido) {
        this.empate_permitido = empate_permitido;
    }

    public int getPuntos_empate() {
        return puntos_empate;
    }

    public void setPuntos_empate(int puntos_empate) {
        this.puntos_empate = puntos_empate;
    }
}
