package Negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "puntuacion_puntaje")
@PrimaryKeyJoinColumn(name="id_puntuacion")
public class PuntuacionPuntaje extends Puntuacion{
    @Column(name = "puntos_vic_ausencia")
    private int puntos_vic_ausencia;

    public PuntuacionPuntaje() {
        super();
    }
    public PuntuacionPuntaje(int puntos_vic_ausencia) {
        super();
        this.puntos_vic_ausencia = puntos_vic_ausencia;
    }

    public int getPuntos_vic_ausencia() {
        return puntos_vic_ausencia;
    }

    public void setPuntos_vic_ausencia(int puntos_vic_ausencia) {
        this.puntos_vic_ausencia = puntos_vic_ausencia;
    }
}
