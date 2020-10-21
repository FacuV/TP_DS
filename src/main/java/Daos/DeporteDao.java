package Daos;

import Negocio.Deporte;

import java.util.List;

public interface DeporteDao {
    Deporte getDeporte(int id_deporte);
    Deporte getDeporte(String nombre);

    List<Deporte> getDeportes();
}
