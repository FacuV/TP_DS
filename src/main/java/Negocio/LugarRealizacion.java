package Negocio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lugar_realizacion")
public class LugarRealizacion{
    @Id
    @Column(name = "id_lugar_realizacion")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_lugar_realizacion;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany
    @JoinTable(name = "lugar_realizacion_deporte", joinColumns = @JoinColumn(name = "id_lugar_realizacion"), inverseJoinColumns = @JoinColumn(name = "id_deporte"))
    private List<Deporte> deportes;
    public LugarRealizacion() {}
    public LugarRealizacion(String nombre,Usuario usuario, ArrayList<Deporte> deportes, String descripcion) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.deportes = deportes;
        this.descripcion = descripcion;
    }
    public LugarRealizacion(String nombre,Usuario usuario, String descripcion) {
        this(nombre,usuario,new ArrayList(),descripcion);
    }
    public int getId_lugar_realizacion() {
        return id_lugar_realizacion;
    }

    public void setId_lugar_realizacion(int id_lugar_realizacion) {
        this.id_lugar_realizacion = id_lugar_realizacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Deporte> getDeportes() {
        return this.deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "LugarRealizacion{" +
                "id_lugar_realizacion=" + id_lugar_realizacion +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }
}
