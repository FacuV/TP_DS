package Negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "puntuacion_set")
@PrimaryKeyJoinColumn(name="id_puntuacion")
public class PuntuacionSet extends Puntuacion{
    @Column(name = "cant_sets_max")
    private int cant_sets_max;

    public PuntuacionSet() {
        super();
    }

    public PuntuacionSet(int cant_sets_max) {
        super();
        this.cant_sets_max = cant_sets_max;
    }

    public int getCant_sets_max() {
        return cant_sets_max;
    }

    public void setCant_sets_max(int cant_sets_max) {
        this.cant_sets_max = cant_sets_max;
    }
}
