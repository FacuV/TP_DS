package Negocio;

import java.util.ArrayList;

public class LugarRealizacion {
    private int id_lugar_realizacion;
    private String nombre;
    private ArrayList<Deporte> deportes;
    public LugarRealizacion(String nombre, ArrayList<Deporte> deportes) {
        this.nombre = nombre;
        this.deportes = deportes;
    }
    public LugarRealizacion(String nombre) {
        this(nombre,new ArrayList());
    }

    public String getNombre() {
        return nombre;
    }
}
