package Negocio;

import javax.persistence.*;

@Entity
@Table(name = "puntuacion")
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Puntuacion {
    @Id
    @Column(name = "id_puntuacion")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id_puntuacion;
    protected Puntuacion(){}

    public int getId_puntuacion() {
        return id_puntuacion;
    }

    public void setId_puntuacion(int id_puntuacion) {
        this.id_puntuacion = id_puntuacion;
    }
}
