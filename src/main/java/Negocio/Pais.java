package Negocio;

import javax.persistence.*;

@Entity
@Table(name = "pais")
public class Pais{
    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_pais;
    @Column(name = "nombre")
    private String nombre;
    public Pais(){}
    public Pais(String nombre) {
        this.nombre = nombre;
    }

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

    @Override
    public String toString() {
        return nombre;
    }
}
