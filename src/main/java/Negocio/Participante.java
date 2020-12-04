package Negocio;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participante")
public abstract class Participante {
    @Id
    @Column(name = "id_participante")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id_participante;
    @Column(name = "nombre")
    protected String nombre;
    @Column(name = "email")
    protected String email;

    public Participante() {}

    public Participante(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return id_participante == that.id_participante;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
