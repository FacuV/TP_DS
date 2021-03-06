package Negocio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lugar_realizacion_competencia")
public class Disponibilidad implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_lugar_realizacion")
    private LugarRealizacion lugarRealizacion;

    @Column(name = "disponibilidad")
    private int disponibilidad;

    public Disponibilidad() {}

    public Disponibilidad(int disponibilidad,Competencia competencia, LugarRealizacion lugarRealizacion) {
        this.disponibilidad = disponibilidad;
        this.competencia = competencia;
        this.lugarRealizacion = lugarRealizacion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public LugarRealizacion getLugarRealizacion() {
        return lugarRealizacion;
    }

    public void setLugarRealizacion(LugarRealizacion lugarRealizacion) {
        this.lugarRealizacion = lugarRealizacion;
    }

    public String getNombreLugar() {
        return lugarRealizacion.getNombre();
    }

    @Override
    public String toString() {
        return "["+competencia +","+ lugarRealizacion +","+ disponibilidad+"]";
    }
}
