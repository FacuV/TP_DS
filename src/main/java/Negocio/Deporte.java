package Negocio;

import javax.persistence.*;

@Entity
@Table(name = "deporte")
public class Deporte {
    @Id
    @Column(name = "id_deporte")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_deporte;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    public Deporte(){}
    public Deporte(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    public int getId_deporte() {
        return id_deporte;
    }

    public void setId_deporte(int id_deporte) {
        this.id_deporte = id_deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
