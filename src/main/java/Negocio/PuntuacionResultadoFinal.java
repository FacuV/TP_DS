package Negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "puntuacion_resultado_final")
@PrimaryKeyJoinColumn(name="id_puntuacion")
public class PuntuacionResultadoFinal extends Puntuacion{
    public PuntuacionResultadoFinal(){
        super();
    }
}
