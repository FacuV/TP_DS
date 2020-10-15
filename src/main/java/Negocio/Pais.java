package Negocio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
public class Pais{
    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_pais;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pais",fetch = FetchType.LAZY)
    private List<Provincia> provincias;
    public Pais(){}
    public Pais(String nombre) {
        this.nombre = nombre;
        this.provincias = new ArrayList<>();
    }
    public void addProvincia(Provincia provincia){this.provincias.add(provincia);}

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
