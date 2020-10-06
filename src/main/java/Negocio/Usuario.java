package Negocio;

import java.util.ArrayList;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String numero_documento;
    private TipoDeDocumento tipoDeDocumento;
    private Localidad localidad;
    private ArrayList<LugarRealizacion> lugaresRealizacion;
    private ArrayList<Competencia> competencias;

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
}