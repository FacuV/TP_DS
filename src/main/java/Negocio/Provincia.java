package Negocio;

import javax.persistence.*;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @Column(name = "id_provincia")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_provincia;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    public Provincia() {}
    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
