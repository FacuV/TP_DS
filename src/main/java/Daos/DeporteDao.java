package Daos;

import Negocio.Deporte;

public interface DeporteDao {
    Deporte getDeporte(int id_deporte);
    Deporte getDeporte(String nombre);
}
