package Negocio;

public class Provincia {
    private int id_provincia;
    private String nombre;
    private Pais pais;
    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
}
