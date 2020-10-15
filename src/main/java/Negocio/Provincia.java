package Negocio;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "provincia",fetch = FetchType.LAZY)
    private List<Localidad> localidades;
    public Provincia() {}
    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.localidades = new ArrayList<>();
    }
    public void addLocalidad(Localidad localidad){this.localidades.add(localidad);}
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

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
