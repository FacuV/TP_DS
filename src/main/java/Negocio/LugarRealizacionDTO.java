package Negocio;

import java.util.ArrayList;
import java.util.List;

public class LugarRealizacionDTO {
    public int id_lugar_realizacion;
    public String nombre;
    public String descripcion;
    public List<DeporteDTO> deportesDTO;

    public LugarRealizacionDTO() {
    }

    public LugarRealizacionDTO(int id_lugar_realizacion, String nombre, String descripcion, List<DeporteDTO> deportesDTO) {
        this.id_lugar_realizacion = id_lugar_realizacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.deportesDTO = deportesDTO;
    }

    public LugarRealizacionDTO(int id_lugar_realizacion, String nombre, String descripcion) {
        this(id_lugar_realizacion,nombre,descripcion,new ArrayList<>());
    }
}
