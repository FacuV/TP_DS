package Negocio;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "documento")
    private String numero_documento;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento")
    private TipoDeDocumento tipoDeDocumento;
    @OneToMany
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
    @OneToMany(mappedBy = "usuario")
    private ArrayList<LugarRealizacion> lugaresRealizacion;
    @OneToMany(mappedBy = "usuario")
    private ArrayList<Competencia> competencias;

    public Usuario(){}
    public Usuario(String nombre, String apellido, String numero_documento, TipoDeDocumento tipoDeDocumento, Localidad localidad, ArrayList<LugarRealizacion> lugaresRealizacion, ArrayList<Competencia> competencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_documento = numero_documento;
        this.tipoDeDocumento = tipoDeDocumento;
        this.localidad = localidad;
        this.lugaresRealizacion = lugaresRealizacion;
        this.competencias = competencias;
    }
    public Usuario(String nombre, String apellido, String numero_documento, TipoDeDocumento tipoDeDocumento, Localidad localidad) {
        this(nombre,apellido,numero_documento,tipoDeDocumento,localidad,new ArrayList<LugarRealizacion>(),new ArrayList<Competencia>());
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public TipoDeDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public ArrayList<LugarRealizacion> getLugaresRealizacion() {
        return lugaresRealizacion;
    }

    public void setLugaresRealizacion(ArrayList<LugarRealizacion> lugaresRealizacion) {
        this.lugaresRealizacion = lugaresRealizacion;
    }

    public ArrayList<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }
}