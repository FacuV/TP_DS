package Negocio;

import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;

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
    @ManyToMany
    @JoinTable(name = "lugar_realizando_deporte", joinColumns = @JoinColumn(name = "id_deporte"),
            inverseJoinColumns = @JoinColumn(name = "id_lugar_realizacion"))
    private List<Deporte> deportes;
    public LugarRealizacion() {}
    public LugarRealizacion(String nombre,Usuario usuario, ArrayList<Deporte> deportes) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.deportes = deportes;
    }
    public LugarRealizacion(String nombre,Usuario usuario) {
        this(nombre,usuario,new ArrayList());
    }
    public int getId_lugar_realizacion() {
        return id_lugar_realizacion;
    }

    public void setId_lugar_realizacion(int id_lugar_realizacion) {
        this.id_lugar_realizacion = id_lugar_realizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
