package Negocio;

import javax.persistence.Column;

public class DeporteDTO {
    public int id_deporte;
    public String nombre;

    public DeporteDTO() {
    }

    public DeporteDTO(int id_deporte, String nombre) {
        this.id_deporte = id_deporte;
        this.nombre = nombre;
    }
}
