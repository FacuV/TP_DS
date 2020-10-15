package Negocio;

public class Disponibilidad {
    private int id_disponibilidad;
    private LugarRealizacion lugarRealizacion;
    private int cantidad;

    public Disponibilidad(LugarRealizacion lugarRealizacion, int cantidad) {
        this.lugarRealizacion = lugarRealizacion;
        this.cantidad = cantidad;
    }

    public String getNombreLugar() {
        return lugarRealizacion.getNombre();
    }

    public int getCantidad () {
        return cantidad;
    }
}
