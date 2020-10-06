package Negocio;

public class Localidad {
    private int id_localidad;
    private String nombre;
    private Provincia provincia;
    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
}
