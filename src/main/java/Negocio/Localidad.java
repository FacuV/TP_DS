package Negocio;

import javax.persistence.*;

@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @Column(name = "id_localidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_localidad;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
    public Localidad(){}
    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
    public int getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(int id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
